package de.caylak.pidl1.viewmodel;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
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

    @Pattern(regexp = "/\\b\\d{5}\\b/g")
    private String postCode;
    @NotNull
    private String place;
    @Pattern(regexp = "^([\\S\\s]+?)\\s+([\\d-\\s]*?)\\s*([\\w])?$")
    private String address;
}