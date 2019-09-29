package com.example.crud.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="EMPLOYEES")
@DynamicUpdate
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @NotBlank(message = "First name can't be blank")
    private String firstName;

    @Column(name="surname")
    @NotBlank(message = "Last name can't be blank")
    private String lastName;

    @Column(name="grade")
    private Integer grade;

    @Column(name="salary")
    private Integer salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", salary=" + salary +
                '}';
    }
}
