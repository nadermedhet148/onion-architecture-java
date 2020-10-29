package demoTest.infrastructure.SpringApp.DataSource.repostories.implementation;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import demoTest.infrastructure.SpringApp.DataSource.repostories.interfaces.IStudentEntityRepository;
import demoTest.repositoryInterfaces.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
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
        this.StudentEntityRepository.save(new StudentEntity());
        return this.StudentEntityRepository.findAll().stream().map(item->{
            return toDomain(item);
        }).collect(Collectors.toList());
    }

    private Student toDomain(StudentEntity item) {
        Student student =  new Student();
        student.setName(item.getName());
        student.setId(item.getId());
        return student;
    }

    @Override
    public Student getById(int id) throws StudentNotExistsException {
        Optional<StudentEntity> student = this.StudentEntityRepository.findById(id);
        if(student.isPresent())
            return toDomain(student.get());
        throw new StudentNotExistsException();
    }
}
