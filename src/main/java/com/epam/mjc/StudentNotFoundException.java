package com.epam.mjc;

public class StudentNotFoundException extends IllegalArgumentException {
    public StudentNotFoundException(long studentId) {
        super("Could not find student with ID " + studentId);
    }
}
