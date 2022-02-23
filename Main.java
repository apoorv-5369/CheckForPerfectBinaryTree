public class perfectBinaryTree{
    static class Node{
        int key;
        Node left, right;
    }
    static Node newNode(int k){
        Node node=new Node();
        node.key=k;
        node.right=null;
        node.left=null;
        return node;
    }
    static int depth(Node node){
        int d=0;
        while(node!=null){
            d++;
            node=node.left;
        }
        return d;
    }
    // Check if the tree is perfect binary tree.
    static boolean isPerfect(Node root, int d, int level){
        // Check if the tree is empty.
        if(root==null) return true;
        // Check for the children.
        if(root.left==null&&root.right==null) return d==level+1;
        if(root.left==null||root.right==null) return false;
        return isPerfect(root.left, d, level+1)&&isPerfect(root.right, d, level+1);
    }
    static boolean isperfect(Node root){
        int d=depth(root);
        return isPerfect(root, d, 0);
    }
    public static void main(String[] args){
        Node root=null;
        root=newNode(1);
        root.left=newNode(2);
        root.right=newNode(3);
        root.left.left=newNode(4);
        root.left.right=newNode(5);
        root.right.left=newNode(6);
        root.right.right=newNode(7);
        if(isperfect(root)==true) System.out.println("The tree is Perfect Binary Tree.");
        else System.out.println("The tree is not a Perfect Binary Tree.");
    }
}
