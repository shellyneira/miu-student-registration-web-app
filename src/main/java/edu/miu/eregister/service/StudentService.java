package edu.miu.eregister.service;

import edu.miu.eregister.model.Student;
import java.util.List;

public interface StudentService {
    Student addNewStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer studentId);
    Student updateStudent(Student updatedStudent);
    void deleteStudentById(Integer studentId);
}
