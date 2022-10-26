package za.ac.cput.entity;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

public class Lecturer {
    private String lecturerId, firstName, middleName, lastName, lecturerEmail, departmentId;

    private Lecturer(Builder builder) {
        this.lecturerId = builder.lecturerId;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.lecturerEmail = builder.lecturerEmail;
        this.departmentId = builder.departmentId;
    }

    protected Lecturer() {
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
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

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public static class Builder {
        private String lecturerId, firstName, middleName, lastName, lecturerEmail, departmentId;

        public Builder setLecturerId(String lecturerId) {
            this.lecturerId = lecturerId;
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

        public Builder setLecturerEmail(String lecturerEmail) {
            this.lecturerEmail = lecturerEmail;
            return this;
        }

        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder copy(Lecturer lecturer) {
            this.lecturerId = lecturer.lecturerId;
            this.firstName = lecturer.firstName;
            this.middleName = lecturer.middleName;
            this.lastName = lecturer.lastName;
            this.lecturerEmail = lecturer.lecturerEmail;
            this.departmentId = lecturer.departmentId;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
