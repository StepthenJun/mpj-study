package com.sosd.mpjstudy.generator.service;

import com.sosd.mpjstudy.common.service.IBaseService;
import com.sosd.mpjstudy.generator.domain.User;
import com.sosd.mpjstudy.generator.domain.dto.UserDto;
import com.sosd.mpjstudy.generator.domain.dto.UserQueryDto;

/**
* @author 86187
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-22 01:32:03
*/
public interface UserService extends IBaseService<UserDto,User, UserQueryDto> {

}
