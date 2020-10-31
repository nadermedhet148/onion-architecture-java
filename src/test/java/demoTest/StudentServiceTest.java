package demoTest;

import demoTest.Domain.Student;
import demoTest.DomianServices.exceptions.ExceptionBase;
import demoTest.DomianServices.exceptions.student.StudentNotExistsException;
import demoTest.DomianServices.repository.IStudentRepository;
import demoTest.applicationLogic.service.StudentService;
import demoTest.infrastructure.SpringApp.DataSource.repostories.implementation.StudentRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StudentServiceTest {
    Student[] students = {};
    IStudentRepository studentRepository = Mockito.mock(StudentRepository.class);
    StudentService studentService = new StudentService(studentRepository);


    @Test(expected = StudentNotExistsException.class)
    public void shouldThrowStudentDonotExistedError() throws ExceptionBase {
        doReturn(null).when(studentRepository).getById(anyInt());
        studentService.getById(1);
    }
}
