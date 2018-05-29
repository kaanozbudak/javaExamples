package DataStruct;

public class mainClass
{

    public static void main(String args[])
    {
        Tree myTree=new Tree();
        String arithExpr="3 14 + 8 * 2 -";
        arithClass(arithExpr,myTree);
        System.out.println(myTree.toString());
        System.out.println("");
        System.out.println("After parse node: "+"\n");
        function(myTree.toString());
    }
    public static void function(String word)
    {
        int sum=0;
        String array2[]=word.split("/");
        for (int i=0;i<array2.length;i++)
        {
            System.out.println(array2[i]);
            if (array2[i].equals("+"))
            {
                sum=Integer.parseInt(array2[i-2])+Integer.parseInt(array2[i-1]);
            }
            if (array2[i].equals("-"))
            {
                sum=sum-Integer.parseInt(array2[i-1]);
            }
            if (array2[i].equals("*"))
            {
                sum=sum*Integer.parseInt(array2[i-1]);
            }
            if (array2[i].equals("/"))
            {
                sum=sum/Integer.parseInt(array2[i-1]);
            }
        }
        System.out.println("Sum is equal to: "+sum);

    }
    public static void arithClass(String arithExpr, Tree myTree)
    {
        System.out.println("Before parse it: ");
        System.out.println(arithExpr+"\n");

        String[] array= arithExpr.split(" ");

        System.out.println("After parse it : ");
        for (int i=0;i<array.length;i++)
        {
            pushValues(myTree,array[i]);
        }

        for (int j=0;j<array.length;j++)
        {
            System.out.println(array[j]);
        }

        System.out.println("After Tree: ");
    }
    private static void pushValues(Tree myTree, String values)
    {
        myTree.insertValue(values);
    }
}
