package binaryTree;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
    this.data = data;
    left = null;
    right = null;
    }
}
public class BinaryTree
{
    Node root;
    BinaryTree()
    {
        root = null;
    }
    BinaryTree(int data)
    {
        root = new Node(data);
    }
    public static void main(String args[])
    {
       BinaryTree tree = new BinaryTree();
       tree.root= new Node(1);
       tree.root.right=new Node(2);
       tree.root.left= new Node(3);
       System.out.println(tree.root.left.data);
    }
}
