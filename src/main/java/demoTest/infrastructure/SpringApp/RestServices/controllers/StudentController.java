package demoTest.infrastructure.SpringApp.RestServices.controllers;

import demoTest.Domain.Student;
import demoTest.DomianServices.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping(value = "/")
    public List<Student> getAll(){

        return this.StudentService.getAll();
    }




}
