package com.youtube.javapuzzle.repository;

import com.youtube.javapuzzle.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
