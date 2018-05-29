package finalExam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class adem1 {
    public static void main(String [] args) throws
            FileNotFoundException, IOException
    {
        FileOutputStream kaan=new FileOutputStream("kaan.bin");
        kaan.write("Hello World I'm Kaan".getBytes());
        kaan.close();

        //read

        FileInputStream ali=new FileInputStream("kaan.bin");

        byte [] arr = new byte[100];

        int x,index=0;

        while((x=ali.read())!=-1)
            arr[index++] = (byte) x;
        System.out.println(new String(arr));
    }
}