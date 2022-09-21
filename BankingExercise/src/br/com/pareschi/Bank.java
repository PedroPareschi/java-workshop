package br.com.pareschi;

//        1. Bank
//
//                - It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
//
//        - A constructor that takes a String (name of the bank). It initialises name and instantiates branches.
//
//        - And five methods, they are (their functions are in their names):
//
//  - addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
//
//  - addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
//
//  - addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added successfully or false otherwise.
//
//  - findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
//
//  - listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
//→ OUTPUT
//
//        The list of customers should be printed out in the following format if boolean parameter is true:
//
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Transactions
//                [1]  Amount 50.05
//                [2]  Amount 44.22
//                [3]  Amount 12.44
//        Customer: Mike[2]
//        Transactions
//                [1]  Amount 175.34
//                [2]  Amount 1.65
//        Customer: Percy[3]
//        Transactions
//                [1]  Amount 220.12
//
//        and if false, only the customers - no transactions:
//
//        bank.listCustomers("Adelaide", false);
//
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Customer: Mike[2]
//        Customer: Percy[3]

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String name){
        if(findBranch(name) != null){
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        return branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String name){
        for(Branch branch: branches){
            if(branch.getName().equals(name)){
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        int i = 1;
        System.out.println("Customer details for branch " + branchName);
        if(printTransactions) {
            int j;
            for (Customer customer : branch.getCustomers()) {
                System.out.println("Customer: " + customer.getName() + "[" + i + "]\nTransactions");
                i++;
                j = 1;
                for (Double transaction : customer.getTransactions()) {
                    System.out.println("[" + j + "]  Amount " + transaction);
                    j++;
                }
            }
            return true;
        }
        for(Customer customer: branch.getCustomers()){
            System.out.println("Customer: "+ customer.getName() +"[" + i +"]");
            i++;
        }
        return true;
    }
}
