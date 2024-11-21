package com.sosd.mpjstudy.generator.mapper;

import com.sosd.mpjstudy.generator.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86187
* @description 针对表【product】的数据库操作Mapper
* @createDate 2024-11-22 01:32:03
* @Entity generator.domain.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}




