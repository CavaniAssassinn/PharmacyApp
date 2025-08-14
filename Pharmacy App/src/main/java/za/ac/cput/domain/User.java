/*
 * User.java
 * Author: Bruneez Apollis
 * Student Number:
 * Date: 05/08/2025
 */

package za.ac.cput.domain;

import jakarta.persistence.*;

@MappedSuperclass
public class User {

    public enum Role {
        CUSTOMER,
        PHARMACIST
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // DB primary key

    @Column(nullable = false, unique = true)
    protected String userId;   // Changed from Long to String

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Role role;

    // Protected default constructor for JPA
    protected User() {}

    // Builder constructor
    protected User(Builder<?> builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    // Generic Builder
    public static class Builder<T extends Builder<T>> {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Role role;

        public T setUserId(String userId) {
            this.userId = userId;
            return self();
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return self();
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return self();
        }

        public T setEmail(String email) {
            this.email = email;
            return self();
        }

        public T setPassword(String password) {
            this.password = password;
            return self();
        }

        public T setRole(Role role) {
            this.role = role;
            return self();
        }

        protected T self() {
            return (T) this;
        }

        public User build() {
            return new User(this);
        }
    }
}
