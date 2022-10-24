package za.ac.cput.factory;

import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.generic.GenericHelper;

public class SystemAdminFactory {

    public static SystemAdmin createSystemAdmin(String adminName, String adminEmail)
    {


        String adminID = GenericHelper.generateUniqueIntId();

        SystemAdmin systemAdmin = new SystemAdmin.Builder()
                .setAdminID(adminID)
                .setAdminName(adminName)
                .setAdminEmail(adminEmail)
                .build();
        return systemAdmin;
    }
    public static SystemAdmin updateSystemAdmin(String adminID , String adminName, String adminEmail)
    {
        return new SystemAdmin.Builder()
                .setAdminID(adminID)
                .setAdminName(adminName)
                .setAdminEmail(adminEmail)
                .build();
    }

}
