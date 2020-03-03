package com.mfirsov.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

@Entity
@NoArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.JOIN)
    private Set<CartItem> cartItems;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @DecimalMin("0.00")
    private BigDecimal total = BigDecimal.valueOf(0.00);

}
