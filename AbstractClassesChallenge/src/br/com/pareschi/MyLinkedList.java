package br.com.pareschi;


import java.util.List;

public class MyLinkedList implements NodeList{
//    3.  MyLinkedList (concrete class)
//
//    -  It implements NodeList .
//
//    -  It has one field of type ListItem called root.
//
//    -  A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.
//
//    -  And four methods:
//
//            -  getRoot(), getter for root.
//
//        -  addItem(), takes a ListItem and returns true if it was added successfully or false otherwise.
//        If the item is already present, it doesn't get added. Use compareTo() to place the item in its proper order.
//
//            -  removeItem(), takes a ListItem and returns true if it was removed successfully or false otherwise.
//
//        -  traverse(), takes the root as an argument and does not return anything. If the root is null it prints out:
//        The list is empty, otherwise print each value on a separate line.
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(item == null){
            return false;
        }
        if(root == null){
            root = item;
            return true;
        }
        if(root.compareTo(item) == 0){
            return false;
        }
        if(root.compareTo(item) > 0){
            ListItem previousRoot = root;
            item.setNext(previousRoot);
            previousRoot.setPrevious(item);
            root = item;
            return true;
        }
        ListItem listItem = root.next();
        ListItem previousItem = root;
        while(listItem != null){
            if(listItem.compareTo(item) == 0){
                return false;
            } if(listItem.compareTo(item) > 0){
                item.setNext(listItem);
                item.setPrevious(listItem.previous());
                listItem.previous().setNext(item);
                listItem.setPrevious(item);
                return true;
            }
            previousItem = listItem;
            listItem = listItem.next();
        }
        previousItem.setNext(item);
        item.setPrevious(previousItem);
        return true;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if((item == null) || (root == null)){
            return false;
        }
        if (item.compareTo(root) == 0){
            root.next().setPrevious(null);
            root.setNext(null);
            root = root.next();
            return true;
        }
        ListItem listItem = root.next();
        while(listItem.next() != null) {
            if (listItem.compareTo(item) == 0) {
                listItem.previous().setNext(listItem.next());
                listItem.next().setPrevious(listItem.previous());
                return true;
            }
            listItem = listItem.next();
        }
        if(listItem.compareTo(item) == 0) {
            listItem.previous().setNext(null);
            listItem.setPrevious(null);
            return true;
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root==null){
            System.out.println("The list is empty");
        } else {
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
