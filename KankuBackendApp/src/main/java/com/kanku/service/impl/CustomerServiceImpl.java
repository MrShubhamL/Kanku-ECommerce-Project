package com.kanku.service.impl;

import com.kanku.model.Customer;
import com.kanku.repository.ICustomerRepository;
import com.kanku.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {

        if(customerRepository.findByemail(customer.getEmail())==null){
            customer.setDate(LocalDate.now());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer getCustomerByEmailPass(Customer customer) {
        return customerRepository.getCustomerByEmailAndPassword(customer.getEmail(),customer.getPassword());
    }


}
