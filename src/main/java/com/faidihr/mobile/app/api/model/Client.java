package com.faidihr.mobile.app.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "code")
    private String code;

    @Column(name = "companyname")
    private String companyname;

    @Column(name = "dbname")
    private String dbname;

    @Column(name = "dbuser")
    private String dbuser;

    @Column(name = "dbpassword")
    private String dbpassword;

    @Column(name = "host")
    private String host;


    @Column(name = "active_status")
    private Integer activeStatus;

    @Column(name = "admin_email")
    private String adminEmail;

    public Client() {

    }

    public Client(long client_id, String dbname, String dbuser) {
        this.clientId = client_id;
        this.dbname= dbname;
        this.dbuser = dbuser;
    }
}
