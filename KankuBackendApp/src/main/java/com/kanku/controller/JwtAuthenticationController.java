package com.kanku.controller;


import com.kanku.jwt.JwtUtils;
import com.kanku.model.Customer;
import com.kanku.model.JwtRequest;
import com.kanku.model.JwtResponse;
import com.kanku.repository.ICustomerRepository;
import com.kanku.service.ICustomerService;
import com.kanku.service.impl.jwt.CustomerServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping("/api/service")
public class JwtAuthenticationController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICustomerService userService;

    @PostConstruct
    public void createAdmin(){
        Customer admin = new Customer();
        admin.setCustomerId(1L);
        admin.setFullName("Admin");
        admin.setUsername("admin@gmail.com");
        admin.setRole("ADMIN");
        admin.setAddress("Kolhapur");
        admin.setContact("7769038180");
        admin.setDate(LocalDate.now());
        admin.setPassword(new BCryptPasswordEncoder().encode("admin123"));
        customerRepository.save(admin);
    }

    @PostMapping("/customerRegistration")
    public ResponseEntity<?> createNewCustomer(@RequestBody Customer customer){
        if(userService.getCustomerByEmail(customer.getUsername())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Username already existed. Try again with new username.");
        }
        Customer cust = userService.registerCustomer(customer);
        if(cust==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cust);
    }

    @PostMapping("/login")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest request) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect Username or Password.");
        }
        UserDetails userDetails = customerService.loadUserByUsername(request.getUsername());
        Optional<Customer> optionalCustomer = customerRepository.getCustomerByUsername(userDetails.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails.getUsername());
        JwtResponse response = new JwtResponse();
        if(optionalCustomer.isPresent()){
            response.setJwtToken(jwt);
            response.setRole(optionalCustomer.get().getRole());
            response.setUsername(optionalCustomer.get().getUsername());
            return response;
        }
        return null;
    }
}
