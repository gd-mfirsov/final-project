package com.mfirsov.shop.model;

import lombok.*;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Data
@Setter
@NoArgsConstructor
@ToString(exclude = "productOrders")
@EqualsAndHashCode(exclude = {"id", "productOrders", "cart"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Min(value = 6)
    private String password;

    private boolean enabled;

    private String roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductOrder> productOrders;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
