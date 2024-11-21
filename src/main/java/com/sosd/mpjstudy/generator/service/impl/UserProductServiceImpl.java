package com.sosd.mpjstudy.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosd.mpjstudy.generator.domain.UserProduct;
import com.sosd.mpjstudy.generator.domain.vo.UserProductVO;
import com.sosd.mpjstudy.generator.service.UserProductService;
import com.sosd.mpjstudy.generator.mapper.UserProductMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86187
* @description 针对表【user_product】的数据库操作Service实现
* @createDate 2024-11-22 01:32:03
*/
@Service
public class UserProductServiceImpl extends ServiceImpl<UserProductMapper, UserProduct>
    implements UserProductService{

  @Autowired
  private UserProductMapper userProductMapper;

  public List<UserProductVO> getUserProductDetails() {
    return userProductMapper.getUserProductDetails();
  }
}




