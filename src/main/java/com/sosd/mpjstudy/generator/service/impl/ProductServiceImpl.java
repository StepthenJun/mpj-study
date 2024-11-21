package com.sosd.mpjstudy.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sosd.mpjstudy.generator.domain.Product;
import com.sosd.mpjstudy.generator.service.ProductService;
import com.sosd.mpjstudy.generator.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 86187
* @description 针对表【product】的数据库操作Service实现
* @createDate 2024-11-22 01:32:03
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




