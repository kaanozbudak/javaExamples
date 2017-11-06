package gitHub;

import java.util.Arrays;
import java.util.Scanner;

public class arraySort
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
        System.out.println("Your normal array: ");
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
        int temp;
        System.out.println("After sorting");
        Arrays.sort(array);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
}
