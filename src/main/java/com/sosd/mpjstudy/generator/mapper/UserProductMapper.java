package com.sosd.mpjstudy.generator.mapper;

import com.sosd.mpjstudy.generator.domain.UserProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sosd.mpjstudy.generator.domain.vo.UserProductVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86187
* @description 针对表【user_product】的数据库操作Mapper
* @createDate 2024-11-22 01:32:03
* @Entity generator.domain.UserProduct
*/
@Mapper
public interface UserProductMapper extends BaseMapper<UserProduct> {

  List<UserProductVO> getUserProductDetails();
}




