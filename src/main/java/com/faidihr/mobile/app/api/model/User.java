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

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "countrycode")
    private String countrycode;

    @Column(name = "fullnames")
    private String fullnames;

    @Column(name = "phone_number")
    private String phoneNumber;

}
