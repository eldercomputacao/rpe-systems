package com.rpe.customer.repository;

import com.rpe.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJapRepository extends JpaRepository<Customer, Long> {
}
