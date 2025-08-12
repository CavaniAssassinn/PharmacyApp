package main.java.za.ac.cput.domain;

public class Pharmicist extends User{
    private String licenseNumber;

    private Pharmicist(PharmicistBuilder builder) {
        this.userID = builder.userID;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.licenseNumber = builder.licenseNumber;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    @Override
    public String toString() {
        return "Pharmicist{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
    public static class PharmicistBuilder {
        private int userID;
        private String username;
        private String email;
        private String password;
        private String licenseNumber;

        public PharmicistBuilder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public PharmicistBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public PharmicistBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PharmicistBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public PharmicistBuilder setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public Pharmicist build() {
            return new Pharmicist(this);
        }
    }
}
