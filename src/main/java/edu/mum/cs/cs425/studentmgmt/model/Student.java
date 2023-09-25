package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && studentNumber.equals(student.studentNumber) && firstName.equals(student.firstName) && middleName.equals(student.middleName) && lastName.equals(student.lastName) && Objects.equals(cgpa, student.cgpa) && Objects.equals(dateOfEnrollment, student.dateOfEnrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentNumber, firstName, middleName, lastName, cgpa, dateOfEnrollment);
    }

    private Double cgpa;

    @Temporal(TemporalType.DATE)
    private Date dateOfEnrollment;

    public Student() {

    }

    public Student(long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, Date dateOfEnrollment) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }
// Constructors, getters, setters

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transcript_id", referencedColumnName = "transcriptId")
    private Transcript transcript;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

}
