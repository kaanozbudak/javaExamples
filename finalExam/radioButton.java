package finalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioButton extends JFrame
{
    JPanel changePanel;
    DrawingPanel dp;

    JRadioButton radioLine,radioRectangle,radioOval;
    JCheckBox chckFilled;

    radioButton()
    {
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dp = new DrawingPanel();
        changePanel = new JPanel();
        radioLine = new JRadioButton("Line");
        radioRectangle = new JRadioButton("Rectangle");
        radioOval = new JRadioButton("Oval");
        chckFilled = new JCheckBox("Filled");

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioLine);
        radioGroup.add(radioRectangle);
        radioGroup.add(radioOval);

        radioLine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dp.setType(DrawingPanel.LINE);
            }

        });
        radioRectangle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dp.setType(DrawingPanel.RECTANGLE);
            }

        });
        radioOval.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dp.setType(DrawingPanel.OVAL);
            }

        });

        chckFilled.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(chckFilled.isSelected()) dp.setFilled(true);
                else dp.setFilled(false);

            }
        });

        changePanel.add(radioLine);
        changePanel.add(radioRectangle);
        changePanel.add(radioOval);
        changePanel.add(chckFilled);

        add(changePanel, BorderLayout.SOUTH);
        add(dp,BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        radioButton q1 = new radioButton();
    }

}

@SuppressWarnings("all")
class DrawingPanel extends JPanel
{
    public static final int LINE = 1;
    public static final int RECTANGLE = 2;
    public static final int OVAL = 3;

    private int type;
    private boolean isFilled;
    DrawingPanel(){
        isFilled = false;
        type = 1;
    }

    public void setType(int type)
    {
        this.type = type;
        repaint();
    }

    public void setFilled(boolean isFilled)
    {
        this.isFilled = isFilled;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(!isFilled)
        {
            switch(type)
            {
                case LINE : g.drawLine((int)(getWidth() * 0.2), (int) (getHeight()/2), (int)(getWidth() - (getWidth() * 0.2)), (int)getHeight()/2); break;
                case RECTANGLE : g.drawRect((int)(getWidth() * 0.2), (int)(getHeight()*0.1),(int) (getWidth() - getWidth() * 0.4), (int) (getHeight() - getHeight() * 0.2)); break;
                case OVAL : g.drawOval((int)(getWidth() * 0.2), (int)(getHeight()*0.1),(int) (getWidth() - getWidth() * 0.4), (int) (getHeight() - getHeight() * 0.2)); break;
            }
        }
        else
        {
            switch(type)
            {
                case LINE : g.drawLine((int)(getWidth() * 0.2), (int) (getHeight()/2), (int)(getWidth() - (getWidth() * 0.2)), (int)getHeight()/2); break;
                case RECTANGLE : g.fillRect((int)(getWidth() * 0.2), (int)(getHeight()*0.1),(int) (getWidth() - getWidth() * 0.4), (int) (getHeight() - getHeight() * 0.2)); break;
                case OVAL : g.fillOval((int)(getWidth() * 0.2), (int)(getHeight()*0.1),(int) (getWidth() - getWidth() * 0.4), (int) (getHeight() - getHeight() * 0.2)); break;
            }
        }

    }
}
