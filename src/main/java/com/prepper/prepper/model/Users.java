package com.prepper.prepper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class provides the structure of the Users table in the database
 *
 */
@Entity
@Table
public class Users {

    @Id
    @GeneratedValue
    private Long userID;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean isGoogle;

    /**
     * Constructor used for configuration
     */
    public Users(String email, String firstName, String lastName, String password, boolean isGoogle) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isGoogle = isGoogle;
    }

    /**
     * Default constructor required by Spring
     */
    public Users() {
    }

    /**
     * Getters and Setters
     */
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGoogle() {
        return isGoogle;
    }

    public void setGoogle(boolean google) {
        isGoogle = google;
    }
}
