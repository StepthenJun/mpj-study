package com.sosd.mpjstudy.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sosd.mpjstudy.generator.domain.Product;
import com.sosd.mpjstudy.generator.domain.User;
import com.sosd.mpjstudy.generator.domain.UserProduct;
import com.sosd.mpjstudy.generator.domain.vo.UserProductVO;
import com.sosd.mpjstudy.generator.mapper.UserProductMapper;
import com.sosd.mpjstudy.generator.service.UserProductService;
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

  @Override
  public List<UserProductVO> getUserProductDetailsByMpj() {
    MPJLambdaWrapper<UserProduct> lambdaWrapper = new MPJLambdaWrapper<>();

    lambdaWrapper
        .leftJoin(
            User.class,
            User::getId,
            UserProduct::getUserId,
            ext -> ext.selectAs(User::getUserName, UserProductVO::getUserName)
        )
        .leftJoin(
            Product.class,
            Product::getId,
            UserProduct::getProductId,
            ext -> ext.selectAs(Product::getProductName, UserProductVO::getProductName)
        );

    // 提供了对应的转化为vo类型的方法，直接调用就好了
    return userProductMapper.selectJoinList(UserProductVO.class,lambdaWrapper);
  }
}




