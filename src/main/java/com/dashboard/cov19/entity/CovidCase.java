package com.dashboard.cov19.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CovidCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String fullName;

    private int age;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Date confirmationDate;

    @Column(nullable = false)
    private String status;

    private Date dateOfClosure;

    public CovidCase(String fullName, String country, String state, Date confirmationDate, String status) {
        this.fullName = fullName;
        this.country = country;
        this.state = state;
        this.confirmationDate = confirmationDate;
        this.status = status;
    }

    public CovidCase() {
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfClosure() {
        return dateOfClosure;
    }

    public void setDateOfClosure(Date dateOfClosure) {
        this.dateOfClosure = dateOfClosure;
    }
}
