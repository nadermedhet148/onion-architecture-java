package com.example.oninonSpring.DomianServices.exceptions.student;

public class StudentNotExistsException extends  Exception {

    public StudentNotExistsException() {
        super("This Student Not Exists");
    }
}
