package com.bharath.springdata.associations;

import com.bharath.springdata.associations.onetomany.entities.Customer;
import com.bharath.springdata.associations.onetomany.entities.PhoneNumber;
import com.bharath.springdata.associations.onetomany.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser(){
        Customer customer = new Customer();
        customer.setName("john");
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("cell").build();
        PhoneNumber phoneNumber1 = PhoneNumber.builder().number("0987654321").type("home").build();
        customer.addPhoneNumber(phoneNumber);
        customer.addPhoneNumber(phoneNumber1);
        customerRepository.save(customer);
    }

    @Test
    void testFindCustomer(){
        customerRepository.findAll().stream().filter(x -> x.getId().equals(252L
        )).forEach(System.out::println);
    }

}
