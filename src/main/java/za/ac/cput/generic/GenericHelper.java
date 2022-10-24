package za.ac.cput.generic;


import org.apache.commons.validator.routines.EmailValidator;
import java.util.UUID;


public class GenericHelper {



    // ID  String generator

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    //ID Int generator
    public static int generateUniqueIntId() {
        UUID generateId = UUID.randomUUID();

        String uniqueIntId = "" + generateId;
        int idHash = uniqueIntId.hashCode();
        String filterId = "" + idHash;
        uniqueIntId = filterId.replaceAll("-", "");
        return Integer.parseInt(uniqueIntId);
    }


    // email validator

    public static boolean emailValidation(String email) {
        if(!EmailValidator.getInstance().isValid(email))
            throw new IllegalArgumentException("Invalid email");
        return EmailValidator.getInstance().isValid(email);
    }



}
