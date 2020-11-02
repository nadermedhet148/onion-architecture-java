package com.example.oninonSpring.infrastructure.SpringApp.RestServices.controllers;

import com.example.oninonSpring.Domain.Student;
import com.example.oninonSpring.DomianServices.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
@AllArgsConstructor(onConstructor = @__(
        @Inject))
public class StudentController {


    private final IStudentService StudentService;


    public List<Student> getAll(){
    return  null;
    }




}
