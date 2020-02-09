package com.uhasoft.guard.demo.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Weihua
 * @since 1.0.0
 */
@Data
public class Policy extends BaseEntity {

  private Order order;
  private Date effectedFrom;
  private Date effectedTo;

}
