package demoTest.DomianServices.exceptions.student;

public class StudentNotExistsException extends  Exception {

    public StudentNotExistsException() {
        super("This Student Not Exists");
    }
}
