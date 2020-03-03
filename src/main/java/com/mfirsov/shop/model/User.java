package com.mfirsov.shop.model;

import lombok.*;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = {"id", "orders", "cart"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email(message = "Please provide correct email")
    private String email;

    @Min(value = 6)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
