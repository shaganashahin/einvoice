package com.tronsync.einvoice.repository;

import com.tronsync.einvoice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
