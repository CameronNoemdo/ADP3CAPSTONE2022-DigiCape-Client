package za.ac.cput.factory;


/* CourseFactory.java
 Factory Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 8/08/2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.entity.Course;
import za.ac.cput.generic.GenericHelper;

public class CourseFactory
{
    public static Course createCourse(String courseName,String courseDescription,String departmentId)
    {



        if(!StringUtils.hasLength(courseName))
            throw new IllegalArgumentException("course name was not provided.");
        if(!StringUtils.hasLength(courseDescription))
            throw new IllegalArgumentException("course description was not provided.");
        if(!StringUtils.hasLength(departmentId))
            throw new IllegalArgumentException("department was not provided.");


        return new Course.Builder()
                .setCourseId(GenericHelper.generateUniqueIntId())
                .setCourseName(courseName)
                .setCourseDescription(courseDescription)
                .setDepartmentId(departmentId)
                .build();


    }

    public static Course updateCourse(Integer courseId,String courseName,String courseDescription,String departmentId)
    {
        return new Course.Builder()
                .setCourseId(courseId)
                .setCourseName(courseName)
                .setCourseDescription(courseDescription)
                .setDepartmentId(departmentId)
                .build();
    }
}
