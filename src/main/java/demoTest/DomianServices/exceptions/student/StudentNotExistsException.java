package demoTest.DomianServices.exceptions.student;

import demoTest.DomianServices.exceptions.ExceptionBase;

public class StudentNotExistsException extends ExceptionBase {

    public StudentNotExistsException() {
        super("This Student Not Exists");
    }
}
