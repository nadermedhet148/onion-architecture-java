package demoTest.applicationLogic;

import javax.inject.Inject;
import demoTest.Domain.Student;
import demoTest.DomianServices.services.IStudentService;
import demoTest.repositoryInterfaces.IStudentRepository;

import java.util.List;
import java.util.Optional;

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
    public Student getById(int id) {
        Student student =  this.StudentRepository.getById(id);

        return student;
    }
}
