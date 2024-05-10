package evotek.edu.springdatajpacourse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
@Table(
    name = "products",
    schema = "ecommerce",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "sku_unique",
            columnNames = "stock_keeping_unit"
        )
    }
)
public class Product {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "product_generator"
  )

  @SequenceGenerator(
      name = "product_generator",
      sequenceName = "product_sequence_name",
      allocationSize = 1
  )
  private Long id;

  @Column(name = "stock_keeping_unit", nullable = false)
  private String sku;

  @Column(nullable = false)
  private String name;

  private String description;
  private BigDecimal price;
  private boolean active;
  private String imageUrl;

  @CreationTimestamp
  private LocalDateTime dateCreated;

  @UpdateTimestamp
  private LocalDateTime lastUpdated;
}