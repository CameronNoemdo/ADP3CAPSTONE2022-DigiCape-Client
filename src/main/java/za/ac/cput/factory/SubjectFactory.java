package za.ac.cput.factory;

import org.springframework.util.StringUtils;
import za.ac.cput.entity.Subject;
import za.ac.cput.generic.GenericHelper;

public class SubjectFactory {

    public static Subject createSubject(String subjectName, Integer subjectCredit, String lecturerId)
    {



        if(!StringUtils.hasLength(subjectName))
            throw new IllegalArgumentException("subject name was not provided.");
       
        if(!StringUtils.hasLength(lecturerId))
            throw new IllegalArgumentException("lecturer ID was not provided.");


        return new Subject.Builder()
                .setSubjectID(GenericHelper.generateUniqueIntId())
                .setSubjectName(subjectName)
                .setSubjectCredit(subjectCredit)
                .setLecturerID(lecturerId)
                .build();


    }

    public static Subject updateSubject(Integer subjectId,String subjectName,Integer subjectCredit,String lecturerId)
    {
        return new Subject.Builder()
                .setSubjectID(subjectId)
                .setSubjectName(subjectName)
                .setSubjectCredit(subjectCredit)
                .setLecturerID(lecturerId)
                .build();
    }
}
