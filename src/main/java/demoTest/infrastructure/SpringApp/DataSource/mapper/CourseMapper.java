package demoTest.infrastructure.SpringApp.DataSource.mapper;

import demoTest.Domain.Course;
import demoTest.infrastructure.SpringApp.DataSource.models.CourseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {
    public Course toCourse(CourseEntity course) {
        Course courseDomain = new Course();
        courseDomain.setId(course.getId());
        courseDomain.setName(course.getName());
        return courseDomain;
    }
}
