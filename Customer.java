package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Customer {
    private String name;
    private String memberBranch;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name, String memberBranch, Double initialTransaction) {
        this.name = name;
        this.memberBranch = memberBranch;
        if(initialTransaction.doubleValue() > 10000.00d){
            transactions.add(10000d);
            System.out.println("Customer added, but we only allow transactions up to $10000. Keep your other "+(initialTransaction.doubleValue()-10000d));
        } else {
            transactions.add(initialTransaction);
        }

    }

    public boolean addTransaction(Double transaction){
        if(transaction.doubleValue() < 10000 && transaction.doubleValue() > -10000){
            transactions.add(transaction);
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getMemberBranch() {
        return memberBranch;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
