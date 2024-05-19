package com.bharath.springdata.associations.manytomany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmers_projects", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    , inverseJoinColumns = @JoinColumn(name = "")
    )
    private Set<Programmer> programmers;
}
