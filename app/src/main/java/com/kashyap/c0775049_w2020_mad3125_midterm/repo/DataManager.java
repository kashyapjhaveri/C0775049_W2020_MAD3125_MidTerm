package com.kashyap.c0775049_w2020_mad3125_midterm.repo;

import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;

import java.util.ArrayList;

public class DataManager {

    private static DataManager INSTANCE = new DataManager();
    private ArrayList<CRACustomer> customers = new ArrayList<>();

    private DataManager() {}

    public static DataManager getInstance(){
        return INSTANCE;
    }

    public void addCustomer(CRACustomer customer){
        customers.add(customer);
    }


    public ArrayList<CRACustomer> getCustomers(){
        return customers;
    }
}
