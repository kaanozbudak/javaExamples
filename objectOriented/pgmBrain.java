package objectOriented;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pgmBrain extends JFrame
{
    private int width,heigth,maxVal;
    private int array[];

    private efe dp;

    public pgmBrain()
    {
        try
        {
            Scanner inputt=new Scanner(new File("ascii.pgm"));

            System.out.println(inputt.next());
            width=Integer.parseInt(inputt.next());
            heigth=Integer.parseInt(inputt.next());
            maxVal= Integer.parseInt(inputt.next());

            array=new int[600*600];

            for (int i=0;i<heigth*width;i++)
            {
                array[i]=Integer.parseInt(inputt.next());
            }
        dp= new efe();
        add(dp);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    class efe extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for (int row=0;row<heigth;row++)
            {
                for (int col=0;col<width;col++)
                {
                    int yeniRenk=array[width*row+col];

                    Color c=new Color(yeniRenk,yeniRenk,yeniRenk);

                    g.setColor(c);
                    g.drawRect(row,col,1,1);

                }
            }
        }
    }
    public static void main(String args[])
    {
        pgmBrain window= new pgmBrain();
        window.setSize(650,650);
        window.setTitle("Window");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
