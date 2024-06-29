package com.codingdojo.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(new Student(
                1L,
                "Mariam",
                "Mariam@gmail.com",
                27,
                LocalDate.of(2000, Month.JANUARY,5)));
    }
}
