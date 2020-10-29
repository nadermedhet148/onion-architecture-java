package demoTest.repositoryInterfaces;

import demoTest.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {

    List<Student> findAll();
    Student getById(int id);

}
