package com.faidihr.mobile.app.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "auth_key")
    private String authKey;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Column(name = "status")
    private Integer status;

    @Column(name = "superadmin")
    private Integer superadmin;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "updated_at")
    private Integer updatedAt;

    @Column(name = "registration_ip")
    private String registrationIp;

    @Column(name = "bind_to_ip")
    private String bindToIp;

    @Column(name = "email")
    private String email;

    @Column(name = "email_confirmed")
    private Integer emailConfirmed;

    @Column(name = "branch")
    private String branch;

    @Column(name = "docket")
    private String docket;

    @Column(name = "available")
    private Integer available;

    @Column(name = "employeeid")
    private Integer employeeid;

    @Column(name = "fullnames")
    private String fullnames;

    @Column(name = "profilepic")
    private String profilepic;

    @Column(name = "passexpirydate")
    private java.sql.Timestamp passexpirydate;

    @Column(name = "firstlogin")
    private Integer firstlogin;

    @Column(name = "approved")
    private Integer approved;

    @Column(name = "locked")
    private Integer locked;

    @Column(name = "blocked")
    private Integer blocked;

    @Column(name = "lastloggedin")
    private java.sql.Timestamp lastloggedin;

    @Column(name = "loggedin")
    private Integer loggedin;

    @Column(name = "supervisor")
    private String supervisor;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "dash_status")
    private Integer dashStatus;

    @Column(name = "active_statusshow")
    private Integer activeStatusshow;

    @Column(name = "countrycode")
    private String countrycode;

}
