package com.example.myregistrar.dtos;

import com.example.myregistrar.models.Student;
import com.example.myregistrar.util.JsonMapper;
import com.example.myregistrar.util.entity_dto_mappers.StudentMapper;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class StudentDto {
    private Long id;

    @NotBlank(message = "student first name must not be empty")
    private String firstName;

    @NotBlank(message = "student first name must not be empty")
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of birth must be in the past")
    private LocalDate birthDate;

    private Integer age;
    private String gender;
    private String email;

    private UniversityDto university;

    public Student toStudent() {
        return StudentMapper.INSTANCE.studentDtoToStudent(this);
    }

    public String toJson() {
        return JsonMapper.toJsonString(this);
    }
}
