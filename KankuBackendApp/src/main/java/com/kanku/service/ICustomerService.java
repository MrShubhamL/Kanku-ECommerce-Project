package com.kanku.service;

import com.kanku.model.Customer;

public interface ICustomerService {

    Customer registerCustomer(Customer customer);

    Customer getCustomerByEmailPass(Customer customer);

    Boolean getCustomerByEmail(String username);
}
