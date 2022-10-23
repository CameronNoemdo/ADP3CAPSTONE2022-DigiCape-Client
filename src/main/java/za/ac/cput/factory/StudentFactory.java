package za.ac.cput.factory;

import za.ac.cput.entity.Student;
import za.ac.cput.generic.GenericHelper;
//import za.ac.cput.util.GenericHelper;
public class StudentFactory {



    public static Student createStudent(String firstName, String middleName, String lastName, String studentEmail, String courseID) {


        String studentId = GenericHelper.generateID();
        Student student = new Student.Builder()
                .setStudentId(studentId)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setStudentEmail(studentEmail)
                .setCourseID(courseID)
                .build();

        return student;


    }

    public static Student updateStudent(String studentId,String firstName, String middleName, String lastName, String studentEmail, String courseID)
    {

        return new Student.Builder()
                .setStudentId(studentId)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setStudentEmail(studentEmail)
                .setCourseID(courseID)
                .build();
    }
}