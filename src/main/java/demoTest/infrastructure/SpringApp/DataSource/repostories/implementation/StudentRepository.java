package demoTest.infrastructure.SpringApp.DataSource.repostories.implementation;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import demoTest.infrastructure.SpringApp.DataSource.mapper.StudentMapper;
import demoTest.infrastructure.SpringApp.DataSource.models.StudentEntity;
import demoTest.infrastructure.SpringApp.DataSource.repostories.interfaces.IStudentEntityRepository;
import demoTest.DomianServices.repository.IStudentRepository;
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
    @Autowired
    private final StudentMapper studentMapper;

    @Inject
    public StudentRepository(IStudentEntityRepository studentEntityRepository, StudentMapper studentMapper) {
        StudentEntityRepository = studentEntityRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAll() {
        this.StudentEntityRepository.save(new StudentEntity());
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
