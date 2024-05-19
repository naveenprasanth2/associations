package com.bharath.springdata.associations.onetomany.repository;

import com.bharath.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
