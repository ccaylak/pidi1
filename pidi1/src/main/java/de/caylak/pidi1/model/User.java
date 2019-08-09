package de.caylak.pidi1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@ToString
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private String postCode;
    private String place;
    private String address;

    public User(String firstname, String lastName, LocalDate birthDate, String postCode, String place, String address) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.postCode = postCode;
        this.place = place;
        this.address = address;
    }
}
