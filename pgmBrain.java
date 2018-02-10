package objectOriented;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pgmBrain extends JFrame
{
    private DrawingPanel2 dp;
    private int height,width,maxVal;
    private int array[];
    pgmBrain()
    {
        try {
            Scanner inp=new Scanner(new File("brain.pgm"));
            System.out.println(inp.next());

            width=Integer.parseInt(inp.next());
            height=Integer.parseInt(inp.next());
            maxVal=Integer.parseInt(inp.next());

            array=new int[height*width];

            for (int i=0;i<height*width;i++)
            {
                array[i]=Integer.parseInt(inp.next());
            }

            dp=new DrawingPanel2();
            add(dp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    class DrawingPanel2 extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for (int row=0;row<height;row++)
            {
                for (int col=0;col<width;col++)
                {
                    int color=array[row*width+col];
                    g.setColor(new Color(color,color,color));
                    g.drawRect(col,row,1,1);
                }
            }

        }
    }
    public static void main(String args[])
    {
        pgmBrain window=new pgmBrain();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Brain");
        window.setVisible(true);
        window.setSize(720 ,486);
    }
}