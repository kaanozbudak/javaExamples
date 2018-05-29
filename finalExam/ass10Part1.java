package finalExam;

import java.io.*;

public class ass10Part1
{
    public static void main(String args[]) throws IOException
    {
        FileOutputStream file=new FileOutputStream("message.bin");
        file.write("How are you guys".getBytes());
        file.close();
        System.out.println("We did.");

        FileInputStream reader=new FileInputStream("message.bin");

        int x, index=0;
        byte [] ar=new byte[100];
        while((x=reader.read())!=-1)
        {
            ar[index++]=(byte)x;
        }
        System.out.println(new String(ar));
        System.out.println("thats all");

        int number=0x65666768;
        FileOutputStream file2=new FileOutputStream("integer.bin");
        file2.write(number);
        file2.write(number>>8);
        file2.write(number>>16);
        file2.write(number>>24);
        file2.close();

        int y;
        FileInputStream reader2=new FileInputStream("integer.bin");
        while((y=reader2.read())!=-1)
        {
            System.out.println(y);
        }

        DataOutputStream file3=new DataOutputStream(new FileOutputStream("kaan.txt"));
        file3.write("How are you guys".getBytes());
        file3.close();
        System.out.println("We did");

        DataInputStream reader3=new DataInputStream(new FileInputStream("kaan.txt"));
        int z,index1=0;
        byte [] arr=new byte[100];
        while((z=reader3.read())!=-1)
        {
            arr[index1++]=(byte)z;
        }
        System.out.println(new String(arr));
        System.out.println("we did!");


    }
}
