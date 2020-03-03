package com.mfirsov.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "id", "cartItems"})
@ToString(exclude = "cartItems")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Please provide title of product")
    private String title;

    @Min(value = 0, message = "Amount should be greater or equal than 0")
    @Max(value = 100, message = "Amount should be less than or equal than 100")
    private int amount;

    @NotNull(message = "Please provide a price")
    @DecimalMin("0.00")
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> cartItems;
}
