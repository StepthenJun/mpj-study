package com.sosd.mpjstudy.generator.service;

import com.sosd.mpjstudy.generator.domain.UserProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sosd.mpjstudy.generator.domain.vo.UserProductVO;
import java.util.List;

/**
* @author 86187
* @description 针对表【user_product】的数据库操作Service
* @createDate 2024-11-22 01:32:03
*/
public interface UserProductService extends IService<UserProduct> {
  List<UserProductVO> getUserProductDetails();
}
