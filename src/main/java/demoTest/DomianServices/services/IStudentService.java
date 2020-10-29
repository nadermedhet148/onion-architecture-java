package demoTest.DomianServices.services;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    Student getById(int id) throws StudentNotExistsException;
}
