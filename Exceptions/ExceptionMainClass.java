package Exceptions;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ExceptionMainClass
{
    public static void main(String args[])
    {
        try
        {
            System.out.println(4/0);
            System.out.println("dead code if " +
                    "an exception occurs above");
        }
        catch(ArithmeticException e2) {}
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

        new Color(0, 244, 2);
        System.out.println("Dead code if "+
                "an exception occurs");
        int sum = 0;
        int [] ar = {1,2,3,4,5};
        for(int i = 0; i < 5; i++)
            sum += ar[i];
        System.out.println("Program continues");
        try {
            File f = new File("/home");
            FileOutputStream fos = new FileOutputStream(f);

            Scanner s = new Scanner(new File("in.txt"));
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("hello");
        return;

    }
}
