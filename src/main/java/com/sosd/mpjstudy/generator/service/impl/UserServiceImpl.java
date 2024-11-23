package com.sosd.mpjstudy.generator.service.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sosd.mpjstudy.common.domain.dto.SearchDto;
import com.sosd.mpjstudy.common.service.BaseService;
import com.sosd.mpjstudy.generator.domain.User;
import com.sosd.mpjstudy.generator.domain.dto.UserDto;
import com.sosd.mpjstudy.generator.domain.dto.UserQueryDto;
import com.sosd.mpjstudy.generator.mapper.UserMapper;
import com.sosd.mpjstudy.generator.service.UserService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author 86187
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-22 01:32:03
*/
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseService<UserDto, User,UserQueryDto>
    implements UserService{

  private final UserMapper mapper;

  @Override
  public MPJLambdaWrapper<User> getWrapper(boolean isDetail) {
    MPJLambdaWrapper<User> wrapper = new MPJLambdaWrapper<>();
    if (isDetail) {
      wrapper.selectAll(User.class);

    } else {
      wrapper
    }

    return wrapper;
  }

  @Override
  public MPJLambdaWrapper<User> withCondition(MPJLambdaWrapper<User> wrapper,
      SearchDto<UserQueryDto> search) {
    return super.withCondition(wrapper, search);
  }

  @Override
  public boolean exists(String id) {
    return false;
  }

  @Override
  public UserDto findById(String id) {
    return null;
  }

  @Override
  public boolean create(UserDto data) {
    return false;
  }

  @Override
  public boolean update(UserDto data) {
    return false;
  }
}




