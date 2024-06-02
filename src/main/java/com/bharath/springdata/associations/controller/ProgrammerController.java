package com.bharath.springdata.associations.controller;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bharath.springdata.associations.validator.EmailGroup;

@RestController
@RequestMapping("/programmer")
public class ProgrammerController {

    @PostMapping
    public ResponseEntity<Programmer> createProgrammer(@Valid @RequestBody Programmer programmer) {
        return ResponseEntity.ok(programmer);
    }

    @PutMapping
    public ResponseEntity<Programmer> updateProgrammer(@Validated(value = EmailGroup.class) @RequestBody Programmer programmer) {
        return ResponseEntity.ok(programmer);
    }
}
