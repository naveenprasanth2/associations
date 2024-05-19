package com.bharath.springdata.associations.onetomany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers;

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
        }
        phoneNumber.setCustomer(this);
        phoneNumbers.add(phoneNumber);
    }
}
