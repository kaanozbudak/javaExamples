package objectOriented;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PGMASCII extends JFrame
{
    private int width, height, maxVal;

    int array[];
    DrawingPanel dp;

    PGMASCII()
    {
        try {
            Scanner input=new Scanner(new File("ascii.pgm"));
            System.out.println(input.next());

            width=Integer.parseInt(input.next());
            height=Integer.parseInt(input.next());
            maxVal=Integer.parseInt(input.next());
            array = new int[height * width];
            for(int i=0; i < width*height;i++)
            {
                array[i]=Integer.parseInt(input.next());
            }
            dp=new DrawingPanel();
            add(dp);

        } catch (FileNotFoundException e) {
        }
    }
    public static void main(String args[])
    {
        PGMASCII window=new PGMASCII();

        window.setSize(650,650);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Feb09");
    }
    class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(int row=0;row<height;row++)
            {
                for(int col=0;col<width;col++)
                {
                    int intColor=array[row*width+col];
                    g.setColor(new Color(intColor,intColor,intColor));
                    g.fillRect(row,col,1,1);
                }
            }
        }
    }
}
