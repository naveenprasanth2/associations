package com.bharath.springdata.associations;

import com.bharath.springdata.associations.manytomany.repository.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

class TestProgrammer {

    private ProgrammerRepository programmerRepository;

    @Test
    void findProgrammerAndSort() {
        Pageable pageable = PageRequest.of(0, 10);
        programmerRepository.findByNameOrderByNameDesc("Naveen", pageable).stream().forEach(System.out::println);
    }
}
