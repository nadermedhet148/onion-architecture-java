package demoTest.infrastructure.SpringApp.DataSource.mapper;

import demoTest.Domain.Student;
import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toDomain(StudentEntity item) {
        Student student =  new Student();
        student.setName(item.getName());
        student.setId(item.getId());
        return student;
    }
}
