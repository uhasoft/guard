package com.uhasoft.guard.demo.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.uhasoft.guard.demo.mybatis.entity.BaseEntity;
import com.uhasoft.guard.demo.mybatis.mapper.BaseMapper;

/**
 * @author Weihua
 * @since 1.0.0
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

  private BaseMapper<T> mapper;

  public BaseServiceImpl(BaseMapper<T> mapper){
    this.mapper = mapper;
  }

  @Override
  public T findById(String id) {
    return mapper.findById(id);
  }

  @Override
  public Page<T> findAll(int pageNum, int pageSize) {

    System.out.println(mapper.findAll());
    return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> mapper.findAll());
  }

}
