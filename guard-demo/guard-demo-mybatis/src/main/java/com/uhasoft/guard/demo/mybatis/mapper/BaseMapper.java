package com.uhasoft.guard.demo.mybatis.mapper;

import com.uhasoft.guard.demo.mybatis.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Weihua
 * @since 1.0.0
 */
public interface BaseMapper<T extends BaseEntity>  {

  default T findById(String id) {
    return findById(getTableName(), id);
  }

  @Select("select * from ${table} where id = #{id}")
  T findById(@Param("table") String table, @Param("id") String id);

  default List<T> findAll(){
    return findAll(getTableName());
  }

  @Select("select * from ${table}")
  List<T> findAll(@Param("table") String table);

  String getTableName();

}
