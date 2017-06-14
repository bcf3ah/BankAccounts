package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(Branch newBranch){
        if(!branches.contains(newBranch)){
            branches.add((newBranch));
            System.out.println("Successfully created new branch "+ newBranch.getName());
        } else {
            System.out.println("That branch already exists");
        }
    }

    public void addBranchCustomer(Branch branch, Customer newCustomer){
        if(branch.addCustomer(newCustomer)){
            System.out.println("Successfully added "+newCustomer.getName()+" to branch "+branch.getName());
        } else {
            System.out.println("Error. Customer "+newCustomer.getName()+" already exists in branch "+branch.getName());
        }
    }

    public void addBranchCustomerTransaction(Branch branch, Customer customer, Double transaction){
        if(branch.getCustomers().contains(customer)){
            if(branch.addCustomerTransaction(customer, transaction)){
                System.out.println("Successfully added transaction for "+customer.getName()+" at branch "+branch.getName());
            } else {
                System.out.println("Error. Transactions must be between $-10000 and $10000");
            }
        } else {
            System.out.println("Error. That customer does not exist at branch "+branch.getName());
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public ArrayList<Double> getBranchCustomerTransactions(Branch branch, Customer customer){
        return branch.queryCustomer(customer).getTransactions();
    }

    public void listBranchCustomers(Branch branch, boolean showTransactions){
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            String name = branch.getCustomers().get(i).getName();
            if(showTransactions){
                System.out.println(name +" - "+this.getBranchCustomerTransactions(branch, branch.getCustomers().get(i)));
            } else {
                System.out.println(name);
            }
        }
    }
}
