package evotek.edu.springdatajpacourse.repository;

import evotek.edu.springdatajpacourse.entity.Product;
import evotek.edu.springdatajpacourse.repository.ProductRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryMethodsTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  void saveMethod(){
    // Tạo một đối tượng Product mới
    Product product = new Product();
    product.setSku("SKU001");
    product.setName("Test Product");
    product.setDescription("This is a test product");
    product.setPrice(BigDecimal.valueOf(99.99));
    product.setActive(true);
    product.setImageUrl("https://example.com/test-product.jpg");
    product.setDateCreated(LocalDateTime.now());

    // Lưu đối tượng Product vào cơ sở dữ liệu
    Product savedProduct = productRepository.save(product);

    // Kiểm tra xem đối tượng đã được lưu thành công hay không
    assert savedProduct.getId() != null : "Failed to save product";
    System.out.println("Saved Product ID: " + savedProduct.getId());
  }

  @Test
  void findByNameMethod(){

    Product product = productRepository.findByName("product 2");

    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
  }

  @Test
  void findByIdMethod(){
    Product product = productRepository.findById(1L).get();

    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
  }

  @Test
  void findByNameOrDescriptionMethod(){

    List<Product> products = productRepository.findByNameOrDescription("product 1",
        "product 1 description");

    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findByNameAndDescriptionMethod(){

    List<Product> products = productRepository.findByNameAndDescription("product 1",
        "product 1 description");

    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findDistinctByNameMethod(){

    Product product = productRepository.findDistinctByName("product 1");
    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
  }

  @Test
  void findByPriceGreaterThanMethod(){
    List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findByPriceLessThanMethod(){

    List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findByNameContainingMethod(){

    List<Product> products = productRepository.findByNameContaining("product 1");
    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findByNameLikeMethod(){

    List<Product> products = productRepository.findByNameLike("product 1");
    products.forEach((p) -> {
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }

  @Test
  void findByPriceBetweenMethod(){
    List<Product> products = productRepository.findByPriceBetween(
        new BigDecimal(100), new BigDecimal(300)
    );

    products.forEach((p) ->{
      System.out.println(p.getId());
      System.out.println(p.getName());
    });

  }

  @Test
  void findByDateCreatedBetweenMethod(){

    // start date
    LocalDateTime startDate = LocalDateTime.of(2022,02,13,17,48,33);
    // end date
    LocalDateTime endDate = LocalDateTime.of(2022,02,13,18,15,21);

    List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

    products.forEach((p) ->{
      System.out.println(p.getId());
      System.out.println(p.getName());
    });
  }
}
