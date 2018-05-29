package SnakeGame;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.GridLayout;

public class Window extends JFrame
{
    public static int width = 20;
    public static int height = 20;
    public static ArrayList<ArrayList<DataOfSquare>> Grid;

    public Window()
    {
        Grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        for (int i=0;i<width;i++)
        {
            data = new ArrayList<DataOfSquare>();
            for (int j =0;j<height;j++)
            {
                DataOfSquare c = new DataOfSquare(2); // snake
                data.add(c);
            }
            Grid.add(data);
        }

        getContentPane().setLayout(new GridLayout(20,20,0,0));

        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        Tuple position = new Tuple(10,10);
        ThreadsController c = new ThreadsController(position);
        c.start();

        this.addKeyListener((KeyListener) new KeyboardListener());
    }
}
