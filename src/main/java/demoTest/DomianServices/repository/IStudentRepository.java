package demoTest.DomianServices.repository;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();
    Student getById(int id) throws StudentNotExistsException;

}
