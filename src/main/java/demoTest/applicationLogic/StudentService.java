package demoTest.applicationLogic;

import javax.inject.Inject;
import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import demoTest.DomianServices.services.IStudentService;
import demoTest.DomianServices.repository.IStudentRepository;

import java.util.List;

public class StudentService implements IStudentService {

    private IStudentRepository StudentRepository;
    @Inject
    public StudentService(IStudentRepository StudentRepository){
        this.StudentRepository = StudentRepository;
    }

    @Override
    public List<Student> getAll() {
        return this.StudentRepository.findAll();
    }

    @Override
    public Student getById(int id) throws StudentNotExistsException {
        Student student =  this.StudentRepository.getById(id);

        return student;
    }
}
