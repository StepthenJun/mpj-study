package com.sosd.mpjstudy.generator.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.sosd.mpjstudy.generator.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
* @author 86187
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-22 01:32:03
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends MPJBaseMapper<User> {

}




