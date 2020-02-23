package com.uhasoft.guard.demo.mybatis.entity;

import lombok.Data;

/**
 * 模拟保险订单
 * @author Weihua
 * @since 1.0.0
 */
@Data
public class Order extends BaseEntity {

  private String area;

  public String toString(){
    return "(" + getId() + ", " + getCreatedBy() + ", " + area + ")";
  }

}
