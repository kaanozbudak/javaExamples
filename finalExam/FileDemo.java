package finalExam;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.URL;

public class FileDemo
{
    public static void main(String args[]) throws IOException {
        File path=new File("hello.txt");
        System.out.println("We got a file: "+path);

        System.out.println("Does it exist ? "+path.exists());
        System.out.println("Wat ? "+path.isDirectory());

        /*String sentence=("Hello KAAN");
        OutputStream outputStream=new FileOutputStream(path);

        outputStream.write(sentence.getBytes());
        outputStream.close();
        */

        /*BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String sentence2=reader.readLine();
        reader.close();
        System.out.println("2:"+sentence2);*/

        URL url=new URL("http://www.gutenberg.org/ebooks/2265?msg=welcome_stranger");
        InputStream stream = url.openStream();
        BufferedReader reader1=new BufferedReader(new InputStreamReader(stream));
        String line=reader1.readLine();
        File path1=new File("ebook.txt");

        OutputStream outputStream1=new FileOutputStream(path1);
        int sayac=0;
        while(line!=null)
        {
            outputStream1.write(line.getBytes());
            line=reader1.readLine();
            sayac++;
        }
        outputStream1.close();
        System.out.println("Done reading");
        System.out.println("sayac: "+sayac+" line");

        File path2=new File("sayac.txt");
        OutputStream outputStream2=new FileOutputStream(path2);
        String nameSurname="kaan özbudak kaan özbudak kaan özbudak kaan özbudak";
        outputStream2.write(nameSurname.getBytes());

        BufferedReader reader2=new BufferedReader(new InputStreamReader(new FileInputStream(path2)));
        System.out.println(reader2.readLine());
        int sayac2=0;
        if(reader2.readLine()=="kaan")
        {
            sayac2++;
        }
        System.out.println(sayac2);
    }
}
