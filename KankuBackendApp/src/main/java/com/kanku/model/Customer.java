package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String contact;
    @Column(columnDefinition = "LONGTEXT")
    private String address;

//    @ManyToMany
//    @JoinTable(
//            name = "customer_products",
//            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customerId"),
//            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"))
//    private List<Product> products;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
    private LocalDate date;
}
