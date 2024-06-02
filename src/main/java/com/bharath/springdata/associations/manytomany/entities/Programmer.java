package com.bharath.springdata.associations.manytomany.entities;

import jakarta.persistence.*;
import lombok.*;
import com.bharath.springdata.associations.validator.EmailGroup;
import com.bharath.springdata.associations.validator.UniqueEmailValidator;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "salary")
    private int sal;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id",
                    referencedColumnName = "id"))
    private Set<Project> projects;
    @UniqueEmailValidator(message = "Email should be unique", groups = EmailGroup.class)
    private String email;
}
