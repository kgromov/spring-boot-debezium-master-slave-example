package com.youtube.javapuzzle.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.javapuzzle.entity.Customer;
import com.youtube.javapuzzle.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

    public Customer createCustomer(Customer customer) {
        // You can add additional validation or business logic here
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
       return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFullName(updatedCustomer.getFullName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void replicateData(Map<String, Object> customerData, Object operation) {
        var customer = objectMapper.convertValue(customerData, Customer.class);
        log.info("Customer = {}", customer);
        if (operation == operation) {
            log.info("delete the record");
            customerRepository.deleteById(customer.getId());
        } else {
            log.info("inserting the record");
            customerRepository.save(customer);
        }
    }
}
