package com.uhasoft.guard.demo.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 模拟保险订单
 * @author Weihua
 * @since 1.0.0
 */
@Data
@ToString
public class Order extends BaseEntity {

  private String area;

}
