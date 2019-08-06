package de.caylak.pidl1.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@ToString
@Entity
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    private final String postCode;
    private final String place;
    private final String address;
}