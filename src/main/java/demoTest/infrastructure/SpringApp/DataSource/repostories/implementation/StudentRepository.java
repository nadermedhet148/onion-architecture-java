package demoTest.infrastructure.SpringApp.DataSource.repostories.implementation;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import demoTest.infrastructure.SpringApp.DataSource.mapper.StudentMapper;
import demoTest.infrastructure.SpringApp.DataSource.models.CourseEntity;
import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import demoTest.infrastructure.SpringApp.DataSource.repostories.JPAInterfaces.ICourseEntityRepository;
import demoTest.infrastructure.SpringApp.DataSource.repostories.JPAInterfaces.IStudentEntityRepository;
import demoTest.DomianServices.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentRepository implements IStudentRepository {

    @Autowired
    private final IStudentEntityRepository StudentEntityRepository;
    @Autowired
    private final ICourseEntityRepository CourseEntityRepository;
    @Autowired
    private final StudentMapper studentMapper;

    @Inject
    public StudentRepository(IStudentEntityRepository studentEntityRepository, ICourseEntityRepository courseEntityRepository, StudentMapper studentMapper) {
        StudentEntityRepository = studentEntityRepository;
        CourseEntityRepository = courseEntityRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAll() {
        CourseEntity c  = new CourseEntity();
        StudentEntity s = new StudentEntity();
        this.StudentEntityRepository.save(s);
        this.CourseEntityRepository.save(c);

        List<CourseEntity> l = new ArrayList<CourseEntity>();
        l.add(c);
        System.out.println(c.toString());
        s.setCourses(l);
        this.StudentEntityRepository.save(s);
        return this.StudentEntityRepository.findAll().stream().map(item->{
            return studentMapper.toDomain(item);
        }).collect(Collectors.toList());
    }



    @Override
    public Student getById(int id) throws StudentNotExistsException {
        Optional<StudentEntity> student = this.StudentEntityRepository.findById(id);
        if(student.isPresent())
            return studentMapper.toDomain(student.get());
        throw new StudentNotExistsException();
    }
}
