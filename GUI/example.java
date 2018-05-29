package GUI;


import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class example extends JFrame
{
    private DrawingPanel dp;
    private int x,y;
    private JButton button;
    public example()
    {
        setLayout(new GridLayout(1,2));
        dp=new DrawingPanel();
        this.add(dp);
        dp.addMouseListener(new MML());
        x=y=100;
        button=new JButton("Click ME!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("sa");

            }
        });
        add(button);
    }
    public class MML implements MouseListener
    {
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
    public class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics brush)
        {
            super.paintComponent(brush);
            setBackground(Color.yellow);
            brush.drawRect((x-50),(y-50),100,100);
        }
    }
    public static void main(String args[])
    {
        example window=new example();
        window.setVisible(true);
        window.setSize(700,700);
        window.setLocation(500,300);
        window.setTitle("Hello World");
        window.setResizable(false);
    }

}
