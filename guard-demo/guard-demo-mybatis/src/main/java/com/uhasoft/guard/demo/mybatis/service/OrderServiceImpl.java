package com.uhasoft.guard.demo.mybatis.service;

import com.uhasoft.guard.demo.mybatis.entity.Order;
import com.uhasoft.guard.demo.mybatis.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Weihua
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

  private OrderMapper mapper;

  public OrderServiceImpl(OrderMapper mapper){
    super(mapper);
    this.mapper = mapper;
  }

  @Override
  public List<Order> findByArea(String area) {
    return mapper.findAll();
  }
}
