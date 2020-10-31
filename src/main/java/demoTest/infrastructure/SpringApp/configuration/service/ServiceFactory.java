package demoTest.infrastructure.SpringApp.configuration.service;


import demoTest.DomianServices.services.IStudentService;
import demoTest.applicationLogic.service.StudentService;
import demoTest.infrastructure.SpringApp.DataSource.repostories.implementation.StudentRepository;
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
