package com.sosd.mpjstudy;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sosd.mpjstudy.generator.domain.Product;
import com.sosd.mpjstudy.generator.domain.User;
import com.sosd.mpjstudy.generator.domain.UserProduct;
import com.sosd.mpjstudy.generator.domain.vo.UserProductVO;
import com.sosd.mpjstudy.generator.mapper.ProductMapper;
import com.sosd.mpjstudy.generator.mapper.UserMapper;
import com.sosd.mpjstudy.generator.mapper.UserProductMapper;
import com.sosd.mpjstudy.generator.service.UserProductService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpjStudyApplicationTests {

  @Autowired
  private ProductMapper productMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserProductMapper userProductMapper;

  @Autowired
  private UserProductService userProductService;

  @Test
  void loadMockData() {
    insertData();
    System.out.println("Mock data insert success.");
  }

  @Test
  void testJoin(){
    List<UserProductVO> userProductDetails = userProductService.getUserProductDetails();

    System.out.println("===== User Product Details =====");
    userProductDetails.forEach(detail -> {
      System.out.println("--------------------------------");
      System.out.println("User Name: " + detail.getUserName());
      System.out.println("Product Name: " + detail.getProductName());
      System.out.println("Price: $" + detail.getPrice());
      System.out.println("--------------------------------");
    });
    System.out.println("================================");

  }

  @Test
  void clearMockData(){
    clearData();
    System.out.println("Mock data cleared after test.");
  }




  void insertData(){
    // Insert mock data for Product
    Product product1 = new Product();
    product1.setProductName("Apple");
    product1.setPrice(1.5);
    productMapper.insert(product1);

    Product product2 = new Product();
    product2.setProductName("Banana");
    product2.setPrice(0.8);
    productMapper.insert(product2);

    Product product3 = new Product();
    product3.setProductName("Orange");
    product3.setPrice(1.2);
    productMapper.insert(product3);

    // Insert mock data for User
    User user1 = new User();
    user1.setUserName("John Doe");
    userMapper.insert(user1);

    User user2 = new User();
    user2.setUserName("Jane Doe");
    userMapper.insert(user2);

    // Insert mock data for UserProduct (association between User and Product)
    UserProduct userProduct1 = new UserProduct();
    userProduct1.setUserId(user1.getId());
    userProduct1.setProductId(product1.getId());
    userProductMapper.insert(userProduct1);

    UserProduct userProduct2 = new UserProduct();
    userProduct2.setUserId(user2.getId());
    userProduct2.setProductId(product2.getId());
    userProductMapper.insert(userProduct2);

    UserProduct userProduct3 = new UserProduct();
    userProduct3.setUserId(user2.getId());
    userProduct3.setProductId(product3.getId());
    userProductMapper.insert(userProduct3);
  }

  void clearData(){
  // Clear all test data from tables
    productMapper.delete(Wrappers.emptyWrapper());
    userMapper.delete(Wrappers.emptyWrapper());
    userProductMapper.delete(Wrappers.emptyWrapper());
  }
}
