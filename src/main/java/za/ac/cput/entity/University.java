package za.ac.cput.entity;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

public class University {
    private String universityId, universityName, email;

    protected University() {
    }

    public University(Builder builder) {
        this.universityId=builder.universityId;
        this.universityName= builder.universityName;
        this.email=builder.email;
    }

    public static class Builder {
        private String universityName, email, universityId;

        public Builder setUniversityId(String universityId)
        {
            this.universityId=universityId;
            return this;
        }

        public Builder setUniversityName(String universityName)
        {
            this.universityName=universityName;
            return this;
        }
        public Builder setEmail(String email)
        {
            this.email=email;
            return this;
        }

        public Builder copy(University university)
        {
            this.universityId=university.universityId;
            this.universityName=university.universityName;
            this.email=university.email;
            //this.facultyList=university.facultyList;
            return this;
        }

        public University build()
        {
            return new University(this);
        }
    }


    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId='" + universityId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
