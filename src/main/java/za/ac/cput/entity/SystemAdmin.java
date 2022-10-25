package za.ac.cput.entity;


//import org.jetbrains.annotations.Contract;

@SuppressWarnings("unused")
public class SystemAdmin {
    private String adminId;
    private String adminName;
    private String adminEmail;



    protected SystemAdmin() {}

    public SystemAdmin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.adminEmail = builder.adminEmail;
    }




    public String getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public static class Builder {
        private String adminId;
        private String adminName;
        private String adminEmail;


        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        public Builder setAdminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return this;

        }
        public Builder copy(SystemAdmin systemAdmin){
            this.adminId = systemAdmin.adminId;
            this.adminName = systemAdmin.adminName;
            this.adminEmail = systemAdmin.adminEmail;
            return this;

        }


        public SystemAdmin build(){
            return new SystemAdmin(this);
        }


    }




    @Override
    public String toString() {
        return "SystemAdmin{" +
                "adminID='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}


