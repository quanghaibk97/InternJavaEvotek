package evotek.edu.springdatajpacourse.repository;

import evotek.edu.springdatajpacourse.entity.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findByName(String name);
  Optional<Product> findById(Long id);
  List<Product> findByNameOrDescription(String name, String description);
  List<Product> findByNameAndDescription(String name, String description);
  Product findDistinctByName(String name);
  List<Product> findByPriceGreaterThan(BigDecimal price);
  List<Product> findByPriceLessThan(BigDecimal price);
  List<Product> findByNameContaining(String name);
  List<Product> findByNameLike(String name);
  List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
  List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

}
