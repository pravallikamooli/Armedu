class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTree {
    Node root;
    StringBuilder orderOfInsertion;

    public BSTree() {
        root = null;
        orderOfInsertion = new StringBuilder();
    }

    void insert(int data) {
        root = insertRec(root, data);
        orderOfInsertion.append(data).append(" ");
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    void printOrderOfInsertion() {
        System.out.println(orderOfInsertion.toString().trim());
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        BSTree bst = new BSTree();

        int[] dataArray = {5, 3, 8, 2, 4, 11};

        for (int data : dataArray) {
            bst.insert(data);
        }

        bst.printOrderOfInsertion();
    }
}
