package za.ac.cput.factory;

import za.ac.cput.entity.Lecturer;
import za.ac.cput.generic.GenericHelper;

public class LecturerFactory {
    public static Lecturer createLecturer(String firstName, String middleName, String lastName, String lecturerEmail, String departmentId)
    {
        return new Lecturer.Builder()
                .setLecturerId(GenericHelper.generateID())
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setLecturerEmail(lecturerEmail)
                .setDepartmentId(departmentId)
                .build();
    }

    public static Lecturer updateLecturer(String lecturerId, String firstName, String middleName, String lastName, String lecturerEmail, String departmentId)
    {
        return new Lecturer.Builder()
                .setLecturerId(lecturerId)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setLecturerEmail(lecturerEmail)
                .setDepartmentId(departmentId)
                .build();
    }
}
