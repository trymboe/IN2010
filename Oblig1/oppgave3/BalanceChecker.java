import java.io.*;

class BST{
    class Node{
        int element;
        Node left;
        Node right;

        public Node(int x){
            element = x;
        }
    }
    Node root;

    void insert(int x){
        root = insert(root, x);
    }

    int height(Node v){
        if(v == null){
            return -1;
        }
        return 1 + Math.max(height(v.left), height(v.right));
    }

    int minHeight(Node v){
        if(v == null){
            return -1;
        }
        return 1 + Math.min(minHeight(v.left), minHeight(v.right));
    }

    Boolean isBalanced(){
        return height(root) - minHeight(root) <= 1;
    }

    Node insert (Node v, int x){
        if(v == null){
            return new Node(x);
        }
        else if(x < v.element){
            v.left = insert(v.left, x);
        }
        else if (x > v.element){
            v.right = insert(v.right, x);
        }
        return v;
    }

}

class BalanceChecker{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BST t = new BST();

        for(String line = br.readLine(); line!= null; line = br.readLine()){
            int x = Integer.parseInt(line);
            t.insert(x);
        }

        if(t.isBalanced()){
            System.out.println("Dette ser balansert ut");
        }
        else{
            System.out.println("Dette ser ikke helt balansert ut");
        }

    }
}
