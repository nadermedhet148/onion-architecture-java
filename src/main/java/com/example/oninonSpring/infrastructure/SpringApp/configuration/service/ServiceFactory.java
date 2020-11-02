package com.example.oninonSpring.infrastructure.SpringApp.configuration.service;

import com.example.oninonSpring.DomianServices.services.IStudentService;
import com.example.oninonSpring.applicationLogic.StudentService;
import com.example.oninonSpring.infrastructure.SpringApp.DataSource.repostories.implementation.StudentRepository;
import com.example.oninonSpring.infrastructure.SpringApp.DataSource.repostories.interfaces.IStudentEntityRepository;
import com.example.oninonSpring.repositoryInterfaces.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactory {
    @Autowired
    StudentRepository studentRepository;
    @Bean
    public IStudentService studentService() {
        return new StudentService(studentRepository);
    }
}
