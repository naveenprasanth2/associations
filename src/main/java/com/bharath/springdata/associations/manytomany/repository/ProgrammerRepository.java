package com.bharath.springdata.associations.manytomany.repository;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {
}
