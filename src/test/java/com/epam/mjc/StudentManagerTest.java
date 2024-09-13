package com.epam.mjc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StudentManagerTest {
    StudentManager manager = new StudentManager();

    @Test(expected = StudentNotFoundException.class)
    public void findNotValid() {
        manager.find(1000);
    }

    @Test
    public void findValidStudent() {
        try {
            assertNotNull(manager.find(1));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExceptionMessage() {
        try {
            manager.find(1000);
        } catch (StudentNotFoundException e) {
            assertEquals("Could not find student with ID 1000", e.getMessage());
        }
    }

    @Test
    public void testIDsNotChangedV1() {
        try {
            assertNull(manager.find(11));
        } catch (StudentNotFoundException e) {
            // Expected exception
        }
    }

    @Test
    public void testIDsNotChangedV2() {
        assertEquals(Student.ARTUR, manager.find(Arrays.stream(Student.values()).map(Student::getId).max(Long::compare).get()));
    }
}
