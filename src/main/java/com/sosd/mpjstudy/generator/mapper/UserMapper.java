package com.sosd.mpjstudy.generator.mapper;

import com.sosd.mpjstudy.generator.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86187
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-22 01:32:03
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




