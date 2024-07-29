package com.kanku.service.impl;

import com.kanku.model.Customer;
import com.kanku.repository.ICustomerRepository;
import com.kanku.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerCustomServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {

        if(customerRepository.findByUsername(customer.getUsername())==null){
            customer.setDate(LocalDate.now());
            customer.setRole("NORMAL");
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer getCustomerByEmailPass(Customer customer) {
        return customerRepository.getCustomerByUsernameAndPassword(customer.getUsername(),customer.getPassword());
    }

    @Override
    public Boolean getCustomerByEmail(String username) {
        Optional<Customer> customerByUsername = customerRepository.getCustomerByUsername(username);
        return customerByUsername.isPresent();
    }


}
