package za.ac.cput.entity;

import javax.persistence.*;
import java.util.List;

/* Course.java
 Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/

@Entity
@Table(name="course")
public class Course {


    @Id
    @GeneratedValue
    private int courseId;
    private  String courseName;
    private String courseDescription;
    private String departmentId;

    //Default constructor

    protected Course() {

    }

    //Builder Constructor

    public Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.courseDescription = builder.courseDescription;
        this.departmentId = builder.departmentId;
    }



    //Getters


    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    //Setters

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    //Builder Class

    public static class Builder {
        private int courseId;
        private String courseName;
        private String courseDescription;
        private String departmentId;



        public Builder setCourseId(int courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }


        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

        public Course.Builder copy(Course course) {
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.courseDescription = course.courseDescription;
            this.departmentId = course.departmentId;

            return this;
        }


    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}