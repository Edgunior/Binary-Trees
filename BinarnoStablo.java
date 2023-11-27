package com.mycompany.bitrees;

public class BinarnoStablo {

    public Node root;

    public BinarnoStablo() {
        this.root = null;
    }

    public boolean search(int id) {

        Node current = root;

        while (current != null) {

            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;

            return;
        }

        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;

            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else{
                current = current.right;

                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } 
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.println(" " + root.data);
            display(root.right);
        }
    }

    public boolean delete(int id) {

        Node parent = root;
        Node current = root;

        boolean isLeftChild = true;

        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }

            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) { // brisemo cvor koji ima levo dete
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // brisemo cvor koji ima samo desno dete

            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }

        } else if (current.left != null && current.right != null) { // brisemo cvor koji ima oba deteta

            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode) {
        // Trazimo naslednika
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

}
