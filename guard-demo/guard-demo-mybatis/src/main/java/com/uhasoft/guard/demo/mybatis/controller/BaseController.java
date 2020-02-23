package com.uhasoft.guard.demo.mybatis.controller;

import com.github.pagehelper.Page;
import com.uhasoft.guard.demo.mybatis.entity.BaseEntity;
import com.uhasoft.guard.demo.mybatis.entity.Response;
import com.uhasoft.guard.demo.mybatis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Weihua
 * @since 1.0.0
 */
public abstract class BaseController<T extends BaseEntity> {

  @Autowired
  private BaseService<T> service;

  @GetMapping("/id/{id}")
  public Response<T> findById(@PathVariable String id){
    return Response.success(service.findById(id));
  }

  @GetMapping
  public Response<Page<T>> findAll(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "10") int pageSize){
    return Response.success(service.findAll(pageNum, pageSize));
  }
}
