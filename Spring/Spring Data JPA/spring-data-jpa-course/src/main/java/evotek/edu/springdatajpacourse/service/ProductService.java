package evotek.edu.springdatajpacourse.service;

import evotek.edu.springdatajpacourse.entity.Product;
import evotek.edu.springdatajpacourse.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public Product saveProduct(Product product) {
    return repository.save(product);
  }

  public List<Product> saveProducts(List<Product> products) {
    return repository.saveAll(products);
  }

  public List<Product> getProducts() {
    return repository.findAll();
  }

  public Product getProductById(long id) {
    return repository.findById(id).orElse(null);
  }

  public Product getProductByName(String name) {
    return repository.findByName(name);
  }

  public String deleteProduct(long id) {
    repository.deleteById(id);
    return "product removed !! " + id;
  }

  public Product updateProduct(Product product) {
    Product existingProduct = repository.findById(product.getId()).orElse(null);
    existingProduct.setPrice(product.getPrice());
    existingProduct.setImageUrl(product.getImageUrl());
    return repository.save(existingProduct);
  }
}
