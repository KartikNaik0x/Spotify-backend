package com.kartik.register.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

/**
 * @author {2095949}
 * @Date {28-11-2023}
 */
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String username;

    String password;

    String firstname;

    String lastname;
    @Column(unique = true)
    String mobileNumber;
    @Column(unique = true)
    @Email(message="invalid email address")
    String email;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }
}
