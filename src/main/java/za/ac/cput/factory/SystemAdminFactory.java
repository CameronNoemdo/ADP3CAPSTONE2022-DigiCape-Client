package za.ac.cput.factory;

import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.generic.GenericHelper;

public class SystemAdminFactory {

    public static SystemAdmin createSystemAdmin(String adminName, String adminEmail)
    {


        String adminId = GenericHelper.generateID();

        return new SystemAdmin.Builder()
                .setAdminId(adminId)
                .setAdminName(adminName)
                .setAdminEmail(adminEmail)
                .build();
    }
    public static SystemAdmin updateSystemAdmin(String adminId , String adminName, String adminEmail)
    {
        return new SystemAdmin.Builder()
                .setAdminId(adminId)
                .setAdminName(adminName)
                .setAdminEmail(adminEmail)
                .build();
    }

}
