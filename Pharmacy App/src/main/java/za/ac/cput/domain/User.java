package main.java.za.ac.cput.domain;

public abstract class User {
    protected int userID;
    protected String username;
    protected String email;

    protected String password;

    public int getUserID() {
        return userID;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private int userID;
        private String username;
        private String email;
        private String password;

        public Builder setUserID(int userID){
            this.userID = userID;
            return this;
        }
        public Builder setUsername(String username){
            this.username = username;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public User build(){
            return new UserImpl(this);
        }
        private static class UserImpl extends User {
            private UserImpl(Builder builder) {
                this.userID = builder.userID;
                this.username = builder.username;
                this.email = builder.email;
                this.password = builder.password;
            }
        }
    }
}
