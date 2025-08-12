package main.java.za.ac.cput.domain;

public class Customer extends User{
    private String address;
    private String phoneNumber;

    private Customer(CustomerBuilder builder) {
        this.userID = builder.userID;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class CustomerBuilder {
        private int userID;
        private String username;
        private String email;
        private String password;
        private String address;
        private String phoneNumber;

        public CustomerBuilder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public CustomerBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
