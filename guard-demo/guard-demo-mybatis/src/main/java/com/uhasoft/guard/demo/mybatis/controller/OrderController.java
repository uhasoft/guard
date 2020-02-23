package com.uhasoft.guard.demo.mybatis.controller;

import com.uhasoft.guard.annotation.GuardResource;
import com.uhasoft.guard.annotation.Retrieve;
import com.uhasoft.guard.annotation.RightType;
import com.uhasoft.guard.context.UserThreadLocal;
import com.uhasoft.guard.demo.mybatis.entity.Order;
import com.uhasoft.guard.demo.mybatis.entity.Response;
import com.uhasoft.guard.demo.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Weihua
 * @since 1.0.0
 */
@GuardResource("order")
@RequestMapping("order")
@RestController
public class OrderController extends BaseController<Order> {

  @Autowired
  private OrderService service;

  @Retrieve
  @PostMapping("search")
  public Response<List<String>> search(@RequestBody Map<String, String> searchBean){
    return Response.success(UserThreadLocal.getLimitation());
  }

  /**
   * 自定义RightType
   * @param id 订单ID
   * @return 订单
   */
  @RightType("deliver")
  @PutMapping("id/{id}")
  public Response<List<String>> deliver(@PathVariable String id){
    return Response.success(UserThreadLocal.getLimitation());
  }
}
