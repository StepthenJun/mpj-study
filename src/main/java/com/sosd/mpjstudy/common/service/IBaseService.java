package com.sosd.mpjstudy.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sosd.mpjstudy.common.domain.dto.PageResult;
import com.sosd.mpjstudy.common.domain.dto.SearchDto;
import java.util.List;


/**
 * 通用增删改查Service
 *
 * @param <T> dto类
 * @param <E> 实体类
 * @param <Q> 查询条件类
 */
public interface IBaseService<T, E, Q> extends IService<E> {

  /**
   * 构造DTO类 查询Wrapper
   *
   * @param isDetail 是否获取详情（详情获取所有字段）
   * @return 查询wrapper
   */
  MPJLambdaWrapper<E> getWrapper(boolean isDetail);

  /**
   * 构造筛选条件
   *
   * @param wrapper 查询wrapper
   * @param search 筛选条件
   * @return 查询wrapper
   */
  MPJLambdaWrapper<E> withCondition(MPJLambdaWrapper<E> wrapper, SearchDto<Q> search);

  /**
   * 查询所有项
   *
   * @param search 查询条件 null 为不筛选
   * @return 数据列表
   */
  List<T> findAll(SearchDto<Q> search);

  /**
   * 分页查询
   *
   * @param search 查询条件
   * @return 分页查询结果
   */
  PageResult<T> findAllPageable(SearchDto<Q> search);

  /**
   * 判断主键是否已存在
   *
   * @param id 主键id
   * @return 是否已存在
   */
  boolean exists(String id);

  /** 通过主键查找 */
  T findById(String id);

  /**
   * 新增
   *
   * @param data 对象
   * @return 是否插入成功
   */
  boolean create(T data);

  /**
   * 根据主键更新数据
   *
   * @param data 对象
   * @return 是否更新成功
   */
  boolean update(T data);

  /**
   * 根据主键删除
   *
   * @param id 主键
   * @return 是否删除成功
   */
  boolean delete(String id);
}
