package com.bharath.springdata.associations;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import com.bharath.springdata.associations.manytomany.entities.Project;
import com.bharath.springdata.associations.manytomany.repository.ProgrammerRepository;
import com.bharath.springdata.associations.onetomany.entities.Customer;
import com.bharath.springdata.associations.onetomany.entities.PhoneNumber;
import com.bharath.springdata.associations.onetomany.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser() {
        Customer customer = new Customer();
        customer.setName("john");
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("cell").build();
        PhoneNumber phoneNumber1 = PhoneNumber.builder().number("0987654321").type("home").build();
        customer.addPhoneNumber(phoneNumber);
        customer.addPhoneNumber(phoneNumber1);
        customerRepository.save(customer);
    }

    @Test
    void testFindCustomer() {
        customerRepository.findAll().stream().filter(x -> x.getId().equals(252L
        )).forEach(System.out::println);
    }

    @Test
    @Transactional
    void testEditCustomer() {
       Customer customer = customerRepository.findAll().stream().filter(x -> x.getId().equals(252L
        )).findFirst().orElseThrow(NoSuchElementException::new);
        System.out.println(customer.getPhoneNumbers());;
    }

    @Test
    void testCreateProgrammer() {
        Programmer programmer = new Programmer();
        programmer.setName("john");
        programmer.setSal(10000);
        Project project = new Project();
        project.setName("Hibernate Project");
        programmer.setProjects(Set.of(project));
        programmerRepository.save(programmer);

    }

    @Test
    @Transactional
    void testFindProgrammer() {
        Programmer programmer = programmerRepository.findById(1).orElseThrow(NoSuchElementException::new);
        System.out.println(programmer);
    }
}
