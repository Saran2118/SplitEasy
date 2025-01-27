package com.saran.SplitEasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_account", uniqueConstraints = {@UniqueConstraint(columnNames = {"email_id"})})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email_id",nullable = false)
    private String emailId;

    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    public int getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
