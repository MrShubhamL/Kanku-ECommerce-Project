package com.kanku.repository;

import com.kanku.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerOrderDetailsRepository extends JpaRepository<Order,Long> {
}
