package com.employee.employee.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long employeeId;

    @NotNull(message = "firstName is required")
    @NotBlank(message = "firstName is required")
    @Column(name = "FIRSTNAME")
    private String firstName;

    @NotNull(message = "lastName is required")
    @NotBlank(message = "lastName is required")
    @Column(name = "LASTNAME")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "invalid email formate")
//    @Column(unique = true)
    private String email;

    @NotNull(message = "phoneNumbers are required")
    @ElementCollection
    @NotEmpty
    private List<@Pattern(regexp = "\\d{10}", message = "phone number must be 10 digit") String> phoneNumbers;

    @NotNull(message = "dateOfJoining is required")
    @Column(name = "DOJ")
    private Date dateOfJoining;

    @Positive(message = "salary can not be negative or zero")
    @Column(name = "SALARY")
    private double salaryPerMonth;
}
