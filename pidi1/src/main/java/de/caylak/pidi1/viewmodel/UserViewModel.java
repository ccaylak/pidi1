package de.caylak.pidi1.viewmodel;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UserViewModel {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Pattern(regexp = "^\\d{5}$")
    private String postCode;

    @NotNull
    private String place;

    @Pattern(regexp = "^([\\S\\s]+?)\\s+([\\d-\\s]*?)\\s*([\\w])?$")
    private String address;
}
