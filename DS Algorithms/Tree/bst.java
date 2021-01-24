import java.util.LinkedList;
import java.util.Queue;

// BINARY SEARCH TREE IMPLEMENTATION

class Node {
    int value;
    Node left;
    Node right;

    Node (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    Node root;

    // insert a node
    public void insert(int value) {

        Node z = new Node(value);

        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (value <= x.value) {
                x = x.left;
            }
            else {
                x = x.right;
            }
        }

        if (y == null) {
            this.root = z;
        }
        else if (value <= y.value) {
            y.left = z;
        }
        else {
            y.right = z;
        }
    }

    // search for a node
    public Node search(int value) {

        return search_node(this.root, value);
    }
    private Node search_node(Node x, int k) {

        if (x == null || k == x.value) {
            return x;
        }
        else if (k <= x.value) {
            return search_node(x.left, k);
        }
        else {
            return search_node(x.right, k);
        }
    }

    // display nodes inorder
    public void display_inorder() {
        inorder(root);
    }
    // inorder tree traversal
    private void inorder(Node x) {
        if (x != null) {
            inorder(x.left);
            System.out.print(x.value);
            System.out.print(" ");
            inorder(x.right);
        }
    }

    // display nodes levelorder
    public void display_levelorder() {
        levelorder(root);
    }
    // levelorder tree traversal
    private void levelorder(Node x) {
        if (x != null) {
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(x);

            while (nodes.size() > 0) {

                Node temp = nodes.remove();
                System.out.print(temp.value);
                System.out.print(" ");

                if (temp.left != null) {
                    nodes.add(temp.left);
                }

                if (temp.right != null) {
                    nodes.add(temp.right);
                }
            }
        }
    }

    // return minimum value
    public int min_val() {
        Node x = this.root;

        while (x.left != null) {
            x = x.left;
        }

        return x.value;
    }

    // return maximum value
    public int max_val() {
        Node x = this.root;

        while (x.right != null) {
            x = x.right;
        }

        return x.value;
    }
}

public class bst {

    public static void main(String[] args) {

        BST tree = new BST();

        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);

        //tree.display_inorder();
        //tree.display_levelorder();
        //System.out.println(tree.min_val());
        //System.out.println(tree.max_val());

        //System.out.println(tree.search(9));
        //System.out.println(tree.search(4));
    }
}