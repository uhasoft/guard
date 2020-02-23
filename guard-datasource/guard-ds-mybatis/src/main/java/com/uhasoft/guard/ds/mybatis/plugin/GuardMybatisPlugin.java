package com.uhasoft.guard.ds.mybatis.plugin;

import com.uhasoft.guard.context.UserThreadLocal;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Weihua
 * @since 1.0.0
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class GuardMybatisPlugin implements Interceptor {

  private static final Logger logger = LoggerFactory.getLogger(GuardMybatisPlugin.class);

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    List<String> limitations = UserThreadLocal.getLimitation();
    if(!limitations.isEmpty()){
      Object[] args = invocation.getArgs();
      MappedStatement ms = (MappedStatement) args[0];
      Object parameter = args[1];
      RowBounds rowBounds = (RowBounds) args[2];
      ResultHandler resultHandler = (ResultHandler) args[3];
      Executor executor = (Executor) invocation.getTarget();
      BoundSql boundSql = ms.getBoundSql(parameter);
      CacheKey cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
      return executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, getBoundSql(boundSql, limitations, ms.getConfiguration()));
    }
    return invocation.proceed();
  }

  private BoundSql getBoundSql(BoundSql oldBoundSql, List<String> limitations, Configuration configuration){
    try {
      Statement statement = CCJSqlParserUtil.parse(oldBoundSql.getSql());
      if(statement instanceof Select){
        Select select = (Select)statement;
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        Expression where = plainSelect.getWhere();
        Expression expression = null;
        for (String limitation : limitations) {
          Expression condition = CCJSqlParserUtil.parseCondExpression(limitation);
          if(expression == null){
            expression = condition;
          } else {
            expression = new OrExpression(expression, condition);
          }
        }
        if(where == null){
          plainSelect.setWhere(expression);
        } else {
          String whereString = "(" + where.toString() + ")";
          Expression newWhere = CCJSqlParserUtil.parseCondExpression(whereString);
          plainSelect.setWhere(new AndExpression(newWhere, expression));
        }
        logger.info("SQL:{}", statement.toString());
        return new BoundSql(configuration, statement.toString(), oldBoundSql.getParameterMappings(), oldBoundSql.getParameterObject());
      }
    } catch (JSQLParserException e) {
      logger.error(e.getMessage(), e);
    }
    return oldBoundSql;
  }

  public Object plugin(Object target) {
    if(target instanceof Executor){
      return Plugin.wrap(target, this);
    }
    return target;
  }

}
