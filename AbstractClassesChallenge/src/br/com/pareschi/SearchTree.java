package br.com.pareschi;

public class SearchTree implements NodeList {
//    5.  SearchTree (concrete class)
//
//    -  It implements NodeList.
//
//    -  It has one field of type ListItem called root.
//
//    -  A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.
//
//    -  And five methods:
//
//            -  getRoot(), getter for root.
//
//        -  addItem(), same as MyLinkedList.
//
//            -  removeItem(), same as MyLinkedList.
//
//            -  performRemoval(), takes two ListItems, the item to be removed and its parent. It doesn't return anything and is declared as private. Call this method from removeItem() when the item is found.
//
//            -  traverse(), takes the root as an argument and does not return anything. It uses recursion to visit all the branches in the tree (Inorder). Print each value on a seperate line.

//    TIP:  When adding items to a Binary Search Tree, if the item to be added is less than the current item - then move to the left.
//
//    If it is greater than the current item - then move to the right.
//
//            The new item is added when an attempt to move in the required direction would involve following a null reference.
//
//    Once again, duplicates are not allowed.

    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (newItem == null) {
            return false;
        }
        if (root == null) {
            root = newItem;
            return true;
        }
        ListItem currentItem = root;
        while (currentItem != null) {
            if (currentItem.compareTo(newItem) == 0) {
                return false;
            }
            if (currentItem.compareTo(newItem) < 0) {
                if (currentItem.next() == null) {
                    currentItem.setNext(newItem);
                    return true;
                }
                currentItem = currentItem.next();
            } else if (currentItem.compareTo(newItem) > 0) {
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(newItem);
                    return true;
                }
                currentItem = currentItem.previous();
            }

        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if ((item == null) || (root == null)) {
            return false;
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            if (currentItem.compareTo(item) == 0) {
                performRemoval(currentItem, parentItem);
                return true;

            } else if (currentItem.compareTo(item) < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.value);
            traverse(root.next());
        }
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == null) {
                // item is left child of its parent
                parent.setPrevious(item.next());
                // again, we are deleting the root
            } else {
                root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem leftmost = item.next();
            ListItem leftmostParent = item;
            while (leftmost.previous() != null) {
                leftmostParent = leftmost;
                leftmost = leftmost.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(leftmost.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                item.setNext(leftmost.next());
            } else {
                leftmostParent.setPrevious(leftmost.next());
            }
            // set the smallest node's parent to point to
            // the smallest node's right child (which may be null).
        }
    }
}