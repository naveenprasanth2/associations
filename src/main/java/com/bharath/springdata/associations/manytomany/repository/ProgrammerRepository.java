package com.bharath.springdata.associations.manytomany.repository;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {
    Optional<Programmer> findByNameIsNull(String name);

    List<Programmer> findByNameOrderByIdDesc(String name, Pageable pageable);

    List<Programmer> findByNameOrderByIdAsc(String name, Pageable pageable);

    List<Programmer> findByNameAndId(String name, int id, Pageable pageable);

    List<Programmer> findByNameOrderByNameDesc(String name, Pageable pageable);
}