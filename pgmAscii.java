package objectOriented;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pgmAscii extends JFrame
{
    private int width,height,maxVal;
    private int pixels[];
    private DrawingPanel dp;
    pgmAscii()
    {
        try {
            Scanner input=new Scanner( new File("agascii.pgm"));
            System.out.println(input.next());

            width=Integer.parseInt(input.next());
            height=Integer.parseInt(input.next());
            maxVal=Integer.parseInt(input.next());

            pixels=new int[width*height];

            for (int i=0;i<width*height;i++)
            {
                pixels[i]=Integer.parseInt(input.next());
            }
            dp=new DrawingPanel();
            add(dp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        pgmAscii window=new pgmAscii();
        window.setTitle("Ascii");
        window.setSize(650,650);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for (int row=0;row<height;row++)
            {
                for (int col=0;col<width;col++)
                {
                    int intColor=pixels[row*width+col];
                    g.setColor(new Color(intColor,intColor,intColor));
                    g.drawRect(row,col,1,1);
                }
            }
        }
    }

}
