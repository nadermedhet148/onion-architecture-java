package com.example.oninonSpring.DomianServices.services;

import com.example.oninonSpring.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    Student getById(int id);
}
