import java.util.*;
import java.io.*;

class Node{
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
    }
}

class BinarySearchTree{
    Node root;

    public void add(int key){
        root = addInOrder(root, key);
    }

    public Node addInOrder(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.key){
            root.left = addInOrder(root.left, key);
        }else if (key > root.key){
            root.right = addInOrder(root.right, key);
        }
        return root;
    }

    public void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.key);
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        BinarySearchTree tree = new BinarySearchTree();
        
        while((input=br.readLine())!=null && input !=""){
            tree.add(Integer.parseInt(input));
        }

        tree.printPostOrder(tree.root);
    }
}