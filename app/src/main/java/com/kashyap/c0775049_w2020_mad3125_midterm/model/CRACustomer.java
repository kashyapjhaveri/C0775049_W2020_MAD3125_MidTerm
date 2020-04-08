package com.kashyap.c0775049_w2020_mad3125_midterm.model;


import java.io.Serializable;
import java.util.Date;

public class CRACustomer implements Serializable {

    //User given values
    private String sin;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private Integer grossIncome;
    private Integer rrspContributed;



    public CRACustomer(String sin, String firstName, String lastName, Date birthDate, String gender, Integer grossIncome, Integer rrspContributed) {
        this.sin = sin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
    }


}
