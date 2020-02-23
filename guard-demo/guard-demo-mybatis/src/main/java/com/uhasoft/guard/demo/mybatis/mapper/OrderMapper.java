package com.uhasoft.guard.demo.mybatis.mapper;

import com.uhasoft.guard.demo.mybatis.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Weihua
 * @since 1.0.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order>{


  default String getTableName(){
    return "t_order";
  }

}
