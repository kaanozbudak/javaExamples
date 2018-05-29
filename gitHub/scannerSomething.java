package gitHub;

import java.util.Scanner;

public class scannerSomething
{
    public static void main(String args[])
    {

        int a,b;
        Scanner input=new Scanner(System.in);
        System.out.println("Give me two number");
        a=input.nextInt();
        b=input.nextInt();

        System.out.println("You gave me first number: "+a+" second number: "+b);
    }
}
