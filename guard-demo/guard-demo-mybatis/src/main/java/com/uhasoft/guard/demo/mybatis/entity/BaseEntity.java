package com.uhasoft.guard.demo.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有模型的基类
 * @author Weihua
 * @since 1.0.0
 */
@Data
public class BaseEntity implements Serializable {

  private String id;
  private String createdBy;
  private Date createdAt;
  private String lastModifiedBy;
  private Date lastModifiedAt;
  private int version;
  private boolean deleted;

}
