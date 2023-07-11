package com.example.practice_1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Column(updatable = false)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String email;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    @JsonIgnore
    private List<Registration> registrations = new ArrayList<>();

    public Student(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public static Student createRandomStudent() {
        Faker faker = Faker.instance();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        return new Student(
                firstName,
                lastName,
                faker.number().numberBetween(19, 33),
                firstName.toLowerCase() + '.' + lastName.toLowerCase() + "@onelab.kz"
        );
    }
}
