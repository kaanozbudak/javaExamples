package finalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Lab3MouseMotionListener extends JFrame
{
   private int x,y;
   private ArrayList<Point> points;
   private JRadioButton r1,r2,r3;

   private DrawingPanel panel;

   public Lab3MouseMotionListener()
   {
       points=new ArrayList<Point>();
       panel=new DrawingPanel();
       panel.addMouseMotionListener(new MML());
       add(panel);
       r1=new JRadioButton("kaan");
       r2=new JRadioButton("umut");
       r3=new JRadioButton("ömer");
       panel.add(r1);
       panel.add(r2);
       panel.add(r3);

       r1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });
   }
   class MML implements MouseMotionListener
   {
       public void mouseDragged(MouseEvent e)
       {
           System.out.println(e.getX()+","+e.getY());
           x=e.getX();
           y=e.getY();
           points.add(new Point(x,y));
           panel.repaint();
       }
       public void mouseMoved(MouseEvent e)
       {

       }
   }
   class DrawingPanel extends JPanel
   {
       public void paintComponent(Graphics g)
       {
           super.paintComponent(g);
           for(Point point:points)
           {
               g.drawString("sa",point.x,point.y);
           }
       }
   }

   public static void main(String args[])
   {
       Lab3MouseMotionListener w= new Lab3MouseMotionListener();
       w.setSize(400,400);
       w.setVisible(true);
       w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
