package finalExam;

import java.io.*;

public class fileOpenWriteRead
{
    public static void main(String args[]) throws IOException {
        System.out.println("I will open and write a file");

        File file2=new File("java.txt");
        System.out.println("Does exist? "+file2.exists());

        String word=("Java is programming language");

        OutputStream outputStream2=new FileOutputStream(file2);

        outputStream2.write(word.getBytes());
        outputStream2.close();


        BufferedReader readerr=new BufferedReader(new InputStreamReader(new FileInputStream(file2)));

        String word2=readerr.readLine();

        readerr.close();

        System.out.println(word2);

    }
}
