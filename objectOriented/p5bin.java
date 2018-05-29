package objectOriented;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class p5bin extends JFrame
{
    private DrawingPanel3 dp;
    private int ar[];
    private int width,height,maxVal;

    p5bin()
    {
        dp=new DrawingPanel3();
        try
        {
            FileInputStream fis=new FileInputStream("snap.pgm");
            byte [] magicNum=new byte[2];
            fis.read(magicNum);

            char chByte= (char) fis.read();
            while (Character.isWhitespace(chByte))
            {
                chByte=(char)fis.read();
            }
            byte fb=(byte) chByte;

            int count=1;
            byte [] w= new byte[3];
            w[0]=fb;

            byte aByte= (byte) fis.read();
            while (!Character.isWhitespace(aByte))
            {
                w[count++]=aByte;
                aByte=(byte)fis.read();
            }
            //if the file's head part has
            //P5
            //34 200
            //...
            //w[0] = 51;
            //w[1] = 52;

            System.out.println("count: "+count);
            int i=0;
            String strWidth=new String(w);

            System.out.println(new String(magicNum));
            System.out.println(strWidth);


        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
    }
    class DrawingPanel3 extends JPanel
    {

    }
    public static void main(String args[])
    {
        p5bin win=new p5bin();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.setTitle("p5 Bin");
        win.setSize(100,100);
    }
}
