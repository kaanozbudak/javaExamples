package gitHub;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
public class array
{
    public static void main(String args[])
    {
        int[] array=new int[5];
        Scanner input=new Scanner(System.in);
        for(int i=0;i<array.length;i++)
        {
            System.out.println("Give me "+(i+1)+".number");
            array[i]=input.nextInt();
        }

        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
}
