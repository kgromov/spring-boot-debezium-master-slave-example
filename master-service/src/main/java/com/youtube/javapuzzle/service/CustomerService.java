package com.youtube.javapuzzle.service;

import com.youtube.javapuzzle.entity.Customer;
import com.youtube.javapuzzle.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

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

    @Transactional
    public void batchCreate(Integer count) {
        var customers = IntStream.rangeClosed(0, count)
                .boxed()
                .map(i -> Customer.builder()
                        .fullName("Customer " + i)
                        .email("customer" + i + "@example.com")
                        .build())
                .toList();
        customerRepository.saveAll(customers);
    }
}
