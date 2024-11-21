package com.sosd.mpjstudy.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosd.mpjstudy.generator.domain.User;
import com.sosd.mpjstudy.generator.service.UserService;
import com.sosd.mpjstudy.generator.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86187
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-22 01:32:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




