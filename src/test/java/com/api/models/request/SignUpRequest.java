package com.api.models.request;

public class SignUpRequest {

    // Fields required for signing up a user
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    // Parameterized constructor to initialize all fields
    public SignUpRequest(String username, String password, String email, String firstName, String lastName,
                         String mobileNumber) {
        super(); // Calls the parent Object class constructor
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters for each field
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    // toString method for debugging or logging the object data
    @Override
    public String toString() {
        return "SignUpRequest [username=" + username + ", password=" + password + ", email=" + email
                + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
    }

    /**
     * Builder Design Pattern
     * ----------------------
     * Instead of creating objects using a large constructor (with multiple parameters),
     * we use the Builder pattern for readability and flexibility.
     * Example:
     * new SignUpRequest.Builder()
     *       .username("test")
     *       .password("123")
     *       .build();
     */
    public static class Builder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;

        // Setter methods for Builder class (return the current Builder object for chaining)
        public Builder username(String username) {
            this.username = username;
            return this;  // return current Builder object
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        // Builds the SignUpRequest object after validation
        public SignUpRequest build() {
            // Basic validation checks
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty");
            }
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty");
            }

            // Create and return the SignUpRequest object
            return new SignUpRequest(username, password, email, firstName, lastName, mobileNumber);
        }
    }
}
