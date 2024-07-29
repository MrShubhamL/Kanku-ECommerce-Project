package com.kanku.repository;

import com.kanku.model.Customer;
import com.kanku.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByemail(String email);

    Customer getCustomerByEmailAndPassword(String email,String password);
}
