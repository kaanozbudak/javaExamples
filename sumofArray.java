package gitHub;

import java.util.Scanner;

public class sumofArray
{
    public static void main(String args[])
    {
        int[] array=new int[5];
        Scanner input=new Scanner(System.in);

        int sum=0;

        for(int i=0;i<array.length;i++)
        {
            System.out.println("Give me "+(i+1)+".number");
            array[i]=input.nextInt();
        }
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
            sum+=array[i];
        }
        System.out.println("Sum of the array: "+sum);
    }
}
