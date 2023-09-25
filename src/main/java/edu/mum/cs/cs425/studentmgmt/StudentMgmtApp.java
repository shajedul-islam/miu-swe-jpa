package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentMgmtApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-unit");
        EntityManager em = emf.createEntityManager();

        /*// Create and populate a Student object
        Student student = new Student();
        student.setStudentNumber("000-61-0001");
        student.setFirstName("Anna");
        student.setMiddleName("Lynn");
        student.setLastName("Smith");
        student.setCgpa(3.45);
        // Set the dateOfEnrollment appropriately

        // Save the Student object to the database
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        // Clean up resources
        em.close();
        emf.close();*/

        // Create a Student object
        Student student = new Student();
        student.setStudentNumber("000-61-0001");
        student.setFirstName("Anna");
        student.setMiddleName("Lynn");
        student.setLastName("Smith");
        student.setCgpa(3.45);

// Create a Transcript object
        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

// Create a Classroom object
        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");

// Establish relationships
        student.setTranscript(transcript);
        student.setClassroom(classroom);

// Save the Student object along with its related entities
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(student);
        transaction.commit();

    }
}
