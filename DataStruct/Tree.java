package DataStruct;

public class Tree
{
    private Node rootNode;
    public int length;
    public void insertValue(String value)
    {
        insertNode(new Node(value));
    }
    public void insertNode(Node newNode)
    {
        if(rootNode==null)
        {
            rootNode=new Node(newNode.getValue());
        }
        else
        {
            insertNode(rootNode,newNode);
        }
        length++;
    }
    private void insertNode(Node currentNode, Node newNode)
    {
       if (currentNode.getLeftNode()!=null)
       {
           currentNode.setLeftNode(newNode);
       }
       else if (currentNode.getLeftNode()!=null)
       {
           insertNode(currentNode.getLeftNode(),newNode);
       }
       else if (currentNode.getRightNode()==null)
       {
           currentNode.setRightNode(newNode);
       }
       else if(currentNode.getRightNode()!=null)
       {
           insertNode(currentNode.getRightNode(),newNode);
       }
    }

    @Override
    public String toString()
    {
        if (rootNode!=null)
        {
            //write them
            return rootNode.toString();
        }
        else
        {
            return "";
        }

    }
}
