package com.example.oninonSpring.infrastructure.SpringApp.DataSource.repostories.implementation;

import com.example.oninonSpring.Domain.Student;
import com.example.oninonSpring.infrastructure.SpringApp.DataSource.models.StudentEntity;
import com.example.oninonSpring.infrastructure.SpringApp.DataSource.repostories.interfaces.IStudentEntityRepository;
import com.example.oninonSpring.repositoryInterfaces.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository implements IStudentRepository {

    @Autowired
    private final IStudentEntityRepository StudentEntityRepository;

    @Inject
    public StudentRepository(IStudentEntityRepository studentEntityRepository) {
        StudentEntityRepository = studentEntityRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.StudentEntityRepository.findAll().stream().map(item->{
            Student student =  new Student();
            student.setName(item.getName());
            student.setId(item.getId());
            return student;
        }).collect(Collectors.toList());
    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
