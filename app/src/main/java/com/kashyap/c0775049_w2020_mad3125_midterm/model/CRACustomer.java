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
    private Double grossIncome = 0.0;
    private Double rrspContributed = 0.0;


    //Generated Values
    private Integer age;
    private Date taxFileDate;
    private Double federalTax = 0.0 ;
    private Double provincialTax = 0.0;
    private Double cpp = 0.0;
    private Double ei = 0.0;
    private Double totalTaxableIncome = 0.0;
    private Double totalTaxPayed = 0.0;


    public CRACustomer(String sin, String firstName, String lastName, Date birthDate, String gender, Double grossIncome, Double rrspContributed) {
        this.sin = sin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;
        calculateCpp();
        calculateEi();
        this.totalTaxableIncome = this.grossIncome - (this.ei+this.cpp+this.rrspContributed);
        calculateProvincialTax(this.totalTaxableIncome);
        calculateFederalTax(this.totalTaxableIncome);
    }

    private void calculateCpp(){
        if (this.grossIncome > 57400){
            this.cpp = 2927.4;
        }
        else {
            this.cpp = this.grossIncome*0.051;
        }
    }

    private void calculateEi(){
        if (this.grossIncome > 53100){
            this.ei = 860.22;
        }
        else {
            this.ei = this.grossIncome * 0.0162;
        }
    }


    private void calculateProvincialTax(Double tempTaxableIncome){
        double totalTax = 0;
        if (tempTaxableIncome > 10582.00)
        {
            tempTaxableIncome -= 10582.00;
            totalTax = 0.00;
            if (tempTaxableIncome > 43906.00)
            {
                totalTax += 1682.86;//(33323.99 * 5.05) / 100
                tempTaxableIncome -= 33323.99;
                if (tempTaxableIncome > 87813.00)
                {
                    totalTax += 4017.49;//(43906.99 * 9.15) / 100
                    tempTaxableIncome -= 43906.99;
                    if (tempTaxableIncome > 150000.00)
                    {
                        totalTax += 6940.07;//(62186.99 * 11.16) / 100
                        tempTaxableIncome -= 62186.99;
                        if (tempTaxableIncome > 220000.00)
                        {
                            totalTax += 8512.00;//(69999.99 * 12.16) / 100
                            tempTaxableIncome -= 69999.99;
                            if (tempTaxableIncome > 220000.01)
                            {
                                totalTax += (tempTaxableIncome * 12.16) / 100;
                            }
                        } else
                        {
                            totalTax += (tempTaxableIncome * 12.16) / 100;
                        }
                    } else
                    {
                        totalTax += (tempTaxableIncome * 11.16) / 100;
                    }
                } else
                {
                    totalTax += (tempTaxableIncome * 9.15) / 100;
                }
            } else
            {
                totalTax += (tempTaxableIncome * 5.05) / 100;
            }
        }
        this.provincialTax = Math.round(totalTax * 100.0) / 100.0;
    }

    private void calculateFederalTax(Double tempGrossIncome){
        double totalTax = 0;
        if (tempGrossIncome > 12069.00)
        {
            tempGrossIncome -= 12069.00;
            totalTax = 0.00;
            if (tempGrossIncome > 47630.00)
            {
                totalTax += 5334.00;//(35561.00 * 15) / 100
                tempGrossIncome -= 35561.00;
                if (tempGrossIncome > 95259.00)
                {
                    totalTax += 9763.94;//(47628.99 * 20.50) / 100
                    tempGrossIncome -= 47628.99;
                    if (tempGrossIncome > 147667.00)
                    {
                        totalTax += 13626.08;//(52407.99 * 26) / 100
                        tempGrossIncome -= 52407.99;
                        if (tempGrossIncome > 210371)
                        {
                            totalTax += 18184.16;//(62703.99 * 29) / 100
                            tempGrossIncome -= 62703.99;
                            if (tempGrossIncome > 210371.01)
                            {
                                totalTax += (tempGrossIncome * 33) / 100;
                            }
                        } else
                        {
                            totalTax += (tempGrossIncome * 29) / 100;
                        }
                    } else
                    {
                        totalTax += (tempGrossIncome * 26) / 100;
                    }
                } else
                {
                    totalTax += (tempGrossIncome * 20.50) / 100;
                }
            } else
            {
                totalTax += (tempGrossIncome * 15) / 100;
            }
        }
        this.federalTax = Math.round(totalTax * 100.0) / 100.0;
    }
}
