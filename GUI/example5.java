package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class example5 extends JFrame
{
    private JButton large,small;
    private DrawingPanel dp,dp2;
    private JPanel panel1;
    private int height,weight,x,y;
    private int r,g,b;
    public example5()
    {
        height=weight=x=y=50;
        setLayout(new GridLayout(2,2));
        dp=new DrawingPanel();
        dp.addMouseListener(new Kaan());
        dp.setBackground(Color.yellow);

        add(dp);

        panel1=new JPanel();
        panel1.setBackground(Color.yellow);
        add(panel1);


        large=new JButton("Click for large");
        large.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                height+=30;
                weight+=30;
              //  dp.setBackground(kaaninRengi());
                panel1.setBackground(kaaninRengi());
                dp.repaint();

            }
        });
        small=new JButton("Click for small");
        small.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                height-=30;
                weight-=30;
               // dp.setBackground(kaaninRengi());
                panel1.setBackground(kaaninRengi());
                dp.repaint();

            }
        });
        add(large);
        add(small);

    }
    public Color kaaninRengi ()
    {
        r=(int)(Math.random()*255);
        g=(int)(Math.random()*255);
        b=(int)(Math.random()*255);

        return (new Color(r,g,b));
    }
    public class Kaan implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            x=e.getX();
            y=e.getY();
            dp.repaint();
        }
        public void mouseEntered(MouseEvent e)
        {

        }
        public void mouseExited(MouseEvent e)
        {

        }
        public void mouseReleased(MouseEvent e)
        {

        }
        public void mousePressed(MouseEvent e)
        {

        }
    }
    public class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics brush)
        {
            super.paintComponent(brush);

            brush.drawOval((x-height/2),(y-weight/2),weight,height);
        }

    }
    public static void main(String args[])
    {
        example5 window=new example5();
        window.setSize(400,400);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Hello");
    }
}

