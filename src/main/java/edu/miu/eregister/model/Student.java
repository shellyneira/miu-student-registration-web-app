package edu.miu.eregister.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public final class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column(name = "studentNumber", nullable = false)
    private String studentNumber;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "dateOfEnrollment", nullable = false)
    private LocalDate dateOfEnrollment;
    @Column(name = "cgpa")
    private Double cgpa;
    @Column(name = "isInternational")
    private boolean isInternational;

    public Student() {
        this(null, null, null, null, null, null, false);
    }

    public Student(final Integer studentId, final String studentNumber, final String firstName, final String middleName, final String lastName, final Double cgpa, final boolean isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        dateOfEnrollment = LocalDate.now();
        this.cgpa = cgpa;
        this.isInternational = isInternational;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(final String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(final Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(final LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(final Double cgpa) {
        this.cgpa = cgpa;
    }

    public boolean isInternational() {
        return this.isInternational;
    }

    public void setInternational(final boolean international) {
        this.isInternational = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", cgpa=" + cgpa +
                ", isInternational=" + isInternational +
                '}';
    }
}
