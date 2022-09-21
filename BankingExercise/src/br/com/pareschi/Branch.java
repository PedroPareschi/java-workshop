package br.com.pareschi;

//2. Branch
//
//  - It has two fields, A String called name and an ArrayList that holds objects of type Customer called customers.
//
//  - A constructor that takes a String (name of the branch). It initialises name and instantiates customers.
//
//  - And five methods, they are (their functions are in their names):
//
//    - getName(), getter for name.
//
//    - getCustomers(), getter for customers.
//
//    - newCustomer(), has two parameters of type String (name of customer), double (initial transaction) and returns a boolean. Returns true if the customer was added successfully or false otherwise.
//
//    - addCustomerTransaction(), has two parameters of type String (name of customer), double (transaction) and returns a boolean. Returns true if the customers transaction was added successfully or false otherwise.
//
//    - findCustomer(), has one parameter of type String (name of customer) and returns a Customer. Return the Customer if they exist, null otherwise.

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction){
        if(findCustomer(name) != null){
            return false;
        }
        customers.add(new Customer(name, initialTransaction));
        return true;
    }

    public boolean addCustomerTransaction(String name, double transaction){
        Customer customer = findCustomer(name);
        if(customer == null){
            return false;
        }
        customer.addTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String name){
        for(Customer customer : customers){
            if(customer.getName() == name){
                return customer;
            }
        }
        return null;
    }
}
