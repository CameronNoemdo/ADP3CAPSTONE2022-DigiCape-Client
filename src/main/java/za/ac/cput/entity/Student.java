package za.ac.cput.entity;

/*
Student.java
Entity for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */

public class Student
{



        private String studentId;
        private String firstName;

        private String middleName;
        private String lastName;
        private String studentEmail;
        private String courseID;

        protected Student() {

        }

        private Student(Builder builder){
            this.studentId = builder.studentId;
            this.firstName = builder.firstName;
            this.middleName = builder.middleName;
            this.lastName = builder.lastName;
            this.studentEmail = builder.studentEmail;
            this.courseID = builder.courseID;

        }

        @Override
        public String toString() {
            return "Student{" +
                    "studentId='" + studentId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", studentEmail='" + studentEmail + '\'' +
                    ", courseID='" + courseID + '\'' +
                    '}';
        }

        public String getStudentId() {
            return studentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
        public String getMiddleName() {
            return middleName;
        }

        public String getStudentEmail() {
            return studentEmail;
        }

        public String getCourseID() {
            return courseID;
        }


        // Builder Class
        public static class Builder {
            private String studentId;
            private String firstName;
            private String middleName;
            private String lastName;
            private String studentEmail;
            private String courseID;

            public Builder setStudentId(String studentId) {
                this.studentId = studentId;
                return this;
            }

            public Builder setFirstName(String firstName) {
                this.firstName = firstName;
                return this;

            }
            public Builder setMiddleName(String middleName) {
                this.middleName = middleName;
                return this;
            }
            public Builder setLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder setStudentEmail(String studentEmail) {
                this.studentEmail = studentEmail;
                return this;
            }

            public Builder setCourseID(String courseID) {
                this.courseID = courseID;
                return this;
            }
            public za.ac.cput.entity.Student build(){
                return new za.ac.cput.entity.Student(this);


            }

            public Builder copy(za.ac.cput.entity.Student student){
                this.studentId = student.studentId;
                this.firstName = student.firstName;
                this.middleName = student.middleName;
                this.lastName = student.lastName;
                this.studentEmail = student.studentEmail;
                this.courseID = student.courseID;
                return this;
            }

        }
}
