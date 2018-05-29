package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class buttonExamples extends JFrame
{
    private DrawingPanel dp;
    private int x,y;
    private int a,b;
    public buttonExamples()
    {
        x=y=100;
        a=b=100;
        dp=new DrawingPanel();
        this.add(dp);
        dp.addMouseListener(new MML());

    }
    class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics brush)
        {
            super.paintComponent(brush);
            setBackground(Color.cyan);
            brush.drawOval((x-50),(y-50),a,b);
        }
    }
    class MML implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            x=e.getX();
            y=e.getY();
            dp.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public static void main(String args[])
    {
        buttonExamples bex=new buttonExamples();
        bex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bex.setTitle("Example");
        bex.setSize(500,500);
        bex.setVisible(true);
        bex.setResizable(false);
        bex.setLocation(500,200);
    }
}
