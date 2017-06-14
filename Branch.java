package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name){
        this.name = name;
    }

    public boolean addCustomer(Customer newCustomer){
        if(!customers.contains(newCustomer)){
            customers.add(newCustomer);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(Customer customer, Double transaction){
        if(customer.addTransaction(transaction)){
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer queryCustomer(Customer customer){
        int index = customers.indexOf(customer);
        return customers.get(index);
    }
}
