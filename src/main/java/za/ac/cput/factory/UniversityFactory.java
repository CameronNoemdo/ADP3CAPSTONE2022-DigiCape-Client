package za.ac.cput.factory;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

import za.ac.cput.entity.University;
import za.ac.cput.generic.GenericHelper;

public class UniversityFactory {
    public static University createUniversity(String universityName, String email)
    {
        return new University.Builder()
                .setUniversityId(GenericHelper.generateID())
                .setUniversityName(universityName)
                .setEmail(email)
                .build();
    }

    public static University updateUniversity(String universityId, String universityName, String email)
    {
        return new University.Builder()
                .setUniversityId(universityId)
                .setUniversityName(universityName)
                .setEmail(email)
                .build();
    }
}
