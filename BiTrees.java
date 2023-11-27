package com.mycompany.bitrees;

public class BiTrees {

    public static void main(String[] args) {

        BinarnoStablo bst1 = new BinarnoStablo();

        bst1.insert(2);
        bst1.delete(2);
        bst1.insert(3);
        bst1.insert(7);
        bst1.insert(1);
        bst1.insert(13);
        bst1.insert(11);
        bst1.insert(4);
        bst1.insert(6);
        bst1.insert(5);
        bst1.insert(8);
        System.out.println("BST je:");
        bst1.display(bst1.root);
    }
}
