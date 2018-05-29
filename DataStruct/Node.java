package DataStruct;

public class Node
{
    private Node leftNode;
    private Node rightNode;

    private String value;

    public Node getLeftNode()
    {
        return leftNode;
    }

    public void setLeftNode(Node leftNode)
    {
        this.leftNode = leftNode;
    }

    public Node getRightNode()
    {
        return rightNode;
    }

    public void setRightNode(Node rightNode)
    {
        this.rightNode = rightNode;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public Node(String value)
    {
        leftNode=null;
        rightNode=null;

        this.value=value;
    }

    @Override
    public String toString()
    {
        String result= value + "";
        if(leftNode != null)
        {
            result = leftNode.toString() + "/" + result;
        }
        if (rightNode != null)
        {
            result = result+"/"+rightNode.toString();
        }
        return result;

    }
}
