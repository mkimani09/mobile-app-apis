package com.faidihr.mobile.app.api.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "id_no")
    private String idNo;

    @Column(name = "phone")
    private String phone;

    @Column(name = "department")
    private String department;

    @Column(name = "postal_address")
    private String postalAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "date_birth")
    private java.sql.Date dateBirth;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "estate")
    private String estate;

    @Column(name = "strt_name")
    private String strtName;

    @Column(name = "house_no")
    private Integer houseNo;

    @Column(name = "branch_loc")
    private String branchLoc;

    @Column(name = "nssf_no")
    private String nssfNo;

    @Column(name = "nhif_no")
    private String nhifNo;

    @Column(name = "kra_pin")
    private String kraPin;

    @Column(name = "acc_name")
    private String accName;

    @Column(name = "bank")
    private String bank;

    @Column(name = "branch")
    private String branch;

    @Column(name = "acc_no")
    private String accNo;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private java.sql.Date createdOn;

    @Column(name = "terminate")
    private Integer terminate;

    @Column(name = "leave_taken")
    private Integer leaveTaken;

    @Column(name = "carried_forward")
    private Integer carriedForward;

    @Column(name = "profile_pic")
    private String profilePic;

    @Column(name = "designation")
    private String designation;

    @Column(name = "gender")
    private String gender;

    @Column(name = "s_comments")
    private String sComments;

    @Column(name = "ddirector_comments")
    private String ddirectorComments;

    @Column(name = "hr_comments")
    private String hrComments;

    @Column(name = "director_comments")
    private String directorComments;

    @Column(name = "declined")
    private Integer declined;

    @Column(name = "supervisor")
    private String supervisor;

    @Column(name = "job_group")
    private String jobGroup;

    @Column(name = "salary")
    private String salary;

    @Column(name = "status")
    private Integer status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "employment_date")
    private java.sql.Date employmentDate;

    @Column(name = "confirm_date")
    private java.sql.Date confirmDate;

    @Column(name = "contra_end_date")
    private java.sql.Date contraEndDate;

    @Column(name = "decline")
    private Integer decline;

    @Column(name = "renewal_s_comments")
    private String renewalSComments;

    @Column(name = "renewal_hr_comments")
    private String renewalHrComments;

    @Column(name = "renewal_d_comments")
    private String renewalDComments;

    @Column(name = "renew")
    private Integer renew;

    @Column(name = "forwarded")
    private String forwarded;

    @Column(name = "employment_status")
    private String employmentStatus;

    @Column(name = "test")
    private Integer test;

    @Column(name = "carryoverdays")
    private Integer carryoverdays;

    @Column(name = "accumulateddays")
    private Integer accumulateddays;

    @Column(name = "leavetakendays")
    private Integer leavetakendays;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "payexempted")
    private Integer payexempted;

    @Column(name = "nssfexempted")
    private Integer nssfexempted;

    @Column(name = "nhifexempted")
    private Integer nhifexempted;

    @Column(name = "taxexmpted")
    private Integer taxexmpted;

    @Column(name = "housingexempted")
    private Integer housingexempted;

    @Column(name = "employeecode")
    private String employeecode;

    @Column(name = "s3key")
    private String s3Key;

    @Column(name = "s3type")
    private String s3Type;

    @Column(name = "s3size")
    private String s3Size;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "signature")
    private String signature;

    @Column(name = "housing_no")
    private String housingNo;

    @Column(name = "bvn_no")
    private String bvnNo;

    @Column(name = "imported")
    private Integer imported;

    @Column(name = "onboarded")
    private Integer onboarded;

    @Column(name = "onboardedpercentage")
    private Double onboardedpercentage;

    @Column(name = "employee_rate")
    private BigDecimal employeeRate;

    @Column(name = "emp_terminated")
    private Integer empTerminated;

   }
