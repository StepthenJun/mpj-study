package com.sosd.mpjstudy.common.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sosd.mpjstudy.common.domain.dto.PageResult;
import com.sosd.mpjstudy.common.domain.dto.SearchDto;
import com.sosd.mpjstudy.common.util.ReflectUtils;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BaseService<T, E, S> extends ServiceImpl<MPJBaseMapper<E>, E>
    implements IBaseService<T, E, S> {

  @Autowired
  private MPJBaseMapper<E> mapper;
  private final Class<T> classT;

  public BaseService() {
    classT = ReflectUtils.getSuperClassGenericType(getClass());
  }

  @Override
  public MPJLambdaWrapper<E> withCondition(MPJLambdaWrapper<E> wrapper, SearchDto<S> search) {
    return wrapper;
  }

  @Override
  public List<T> findAll(SearchDto<S> search) {
    var wrapper = this.getWrapper(false);
    if (search != null) {
      wrapper = withCondition(wrapper, search);
    }

    return mapper.selectJoinList(classT, wrapper);
  }

  @Override
  public PageResult<T> findAllPageable(SearchDto<S> _search) {
    var wrapper = this.getWrapper(false);
    var search = Optional.ofNullable(_search).orElse(new SearchDto<>());
    wrapper = withCondition(wrapper, search);

    IPage<T> list =
        mapper.selectJoinPage(new Page<>(search.getPage(), search.getPageSize()), classT, wrapper);

    PageResult<T> result = new PageResult<>();
    result.setTotal(list.getTotal());
    result.setRows(list.getRecords());
    return result;
  }

  @Override
  public boolean delete(String id) {
    return removeById(id);
  }
}
