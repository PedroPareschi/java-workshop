package br.com.pareschi;

import java.util.ArrayList;

//   - addNewContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact doesn't exists, or false if the contact already exists.
//
//   - updateContact(), has two parameters of type Contact (the old contact that will be updated with the new contact) and returns a boolean. Returns true if the contact exists and was updated successfully, or false if the contact doesn't exists.
//
//   - removeContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact exists and was removed successfully, or false if the contact doesn't exists.
//
//   - findContact(), has one parameter of type Contact and returns an int. The returned value is it's position in the ArrayList, it will either be -1 (doesn't exists) or a value greater than or equal to 0 (does exists).
//
//   - findContact(), same as above, only it has one parameter of type String.
//
//   - queryContact(), has one parameter of type String and returns a Contact. Use the String to search for the name and then return the Contact. Return null otherwise.
//
//   - printContacts(), has no parameters and doesn't return anything. Print the contacts in the following format:
//
//        Contact List:
//        1. Bob -> 31415926
//        2. Alice -> 16180339
//        3. Tom -> 11235813
//        4. Jane -> 23571113

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int index = findContact(oldContact.getName());
        if(index < 0){
            return false;
        }
        myContacts.set(index, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int index = findContact(contact.getName());
        if(index < 0){
            return false;
        }
        myContacts.remove(index);
        return true;
    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    private int findContact(String name){
        for(Contact contact: myContacts){
            if(contact.getName().equals(name)){
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        return myContacts.get(findContact(name));
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(Contact contact: myContacts){
            System.out.println((findContact(contact) + 1) +". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
