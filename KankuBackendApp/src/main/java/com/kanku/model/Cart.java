package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"))
    private List<Product> products;
    private LocalDate cartDate;
}
