package com.uhasoft.guard.demo.mybatis.service;

import com.uhasoft.guard.demo.mybatis.entity.Order;

import java.util.List;

/**
 * @author Weihua
 * @since 1.0.0
 */
public interface OrderService extends BaseService<Order> {

  List<Order> findByArea(String area);
}
