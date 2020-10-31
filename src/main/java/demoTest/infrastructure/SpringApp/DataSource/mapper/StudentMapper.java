package demoTest.infrastructure.SpringApp.DataSource.mapper;

import demoTest.Domain.Course;
import demoTest.Domain.Student;
import demoTest.infrastructure.SpringApp.DataSource.models.CourseEntity;
import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentMapper {

    @Autowired
    CourseMapper courseMapper;

    public Student toDomain(StudentEntity item) {
        Student student =  new Student();
        student.setName(item.getName());
        student.setId(item.getId());
        student.setCourses(item.getCourses().stream().map(course->{
            return this.courseMapper.toCourse(course);
        }).collect(Collectors.toList()));
        return student;
    }


}
