package BST;
// created by Kaan Ozbudak
import java.util.LinkedList;

public class bstClass
{
    public static void main(String args [])
    {
        BST bstInt = new BST();
        bstInt.add(12);
        bstInt.add(16);
        bstInt.add(8);
        bstInt.add(9);
        System.out.println("\nIn order");
        bstInt.inOrder();
        System.out.println("\nPre order");
        bstInt.preOrder();
        System.out.println("\nPost order");
        bstInt.postOrder();
    }
}
class Node
{
    int data;
    Node left;
    Node right;
    Node(int d)
    {
        this.data=d;
        left=null;
        right=null;
    }
}
class BST
{
    Node root;

    BST(){
        root=null;
    }
    void add(int d) {
		if(root == null)
			root = new Node(d);
		else {
			Node down = root;
			Node up = null;
			while(down != null) {
				up = down;
				if(d > down.data)
					down = down.right;
				else down = down.left;
			}
			if(up.data > d)
				up.left = new Node(d);
			else up.right = new Node(d);
		}
        add(root, root, d);
    }
    void add(Node down, Node up, int d) {
        if(down == null) {
            if(up.data > d)
                up.left = new Node(d);
            else up.right = new Node(d);
        }
        else if(down.data > d)
            add(down.left, down,d);
        else add(down.right, down, d);
    }
    private void preOrder(Node n)
    {
        if (n!=null)
        {
            System.out.println(n.data+" ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    void preOrder()
    {
        preOrder(root);
    }
    private void inOrder(Node n)
    {
        if (n!=null)
        {
            inOrder(n.left);
            System.out.println(n.data+" ");
            inOrder(n.right);
        }
    }
    void inOrder()
    {
        inOrder(root);
    }
    private void postOrder(Node n)
    {
        if (n!=null)
        {
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.data+" ");
        }
    }
    void postOrder()
    {
        postOrder(root);
    }
}
