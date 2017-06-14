package com.brian;

public class Main {

    public static void main(String[] args) {
	    Bank bank = new Bank("BNL");
	    Branch seattle = new Branch("Seattle");
	    Branch london = new Branch("London");
	    Branch nyc = new Branch("New York");
	    bank.addBranch(seattle);
        bank.addBranch(london);
        bank.addBranch(nyc);

        for (int i = 0; i < bank.getBranches().size(); i++) {
            System.out.println(bank.getBranches().get(i).getName());
        }


        Customer brian = new Customer("Brian", "Seattle", 5000.00);
        Customer pat = new Customer("Pat", "London", 2000.00);
        Customer andy = new Customer("Andy", "New York", 10000.00);
        bank.addBranchCustomer(seattle, brian);
        bank.addBranchCustomer(london, pat);
        bank.addBranchCustomer(nyc, andy);
        bank.addBranchCustomer(nyc, brian);
        bank.addBranchCustomer(seattle, brian);

        System.out.println(bank.getBranchCustomerTransactions(seattle, brian));
        bank.addBranchCustomerTransaction(seattle, brian, 3000.00d);
        System.out.println(bank.getBranchCustomerTransactions(seattle, brian));
        bank.addBranchCustomerTransaction(nyc, brian, 2000.00d);
        System.out.println("----------------------------------------------------");

        bank.listBranchCustomers(nyc, true);



    }
}
