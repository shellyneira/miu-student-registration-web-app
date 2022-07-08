package edu.miu.eregister.service.impl;

import edu.miu.eregister.model.Student;
import edu.miu.eregister.repository.StudentRepository;
import edu.miu.eregister.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAll(Sort.by("firstName"));
        return students;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElse(null);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
