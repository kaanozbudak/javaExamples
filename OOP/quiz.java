package OOP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

// Kaan Özbudak B1505.010016 Computer Engineer Second Grade İstanbul Aydın University

// My github for star: www.github.com/kaanozbudak

// My linkedin

// This program will show you pgm ppm pbm img files. It takes argument first after that it work on and draw this image again in my frame.

// You will fill your name first after you can choose your img file whatever you want.

// You will see new frame on window, it shows you whichever you choosed img file.

// Thanks for download my project.

// Have Fun


public class quiz extends JFrame
{
    private JLabel label1,label2,label3;
    private JTextField textField;
    private JButton button1,button2,button3,button4;
    private int width,height,maxVal=0;
    private int array[];
    private DrawingPanel dp;
    private DrawingPanel2 dp2;
    private int pixs[];
    private DrawingPanel3 dp3;
    private DrawingPanel4 dp4;
    private int r,g,b;
    private Color p3Color;
    private Color ce;
    private int[][] coloredPixels;

    quiz()
    {
        label1=new JLabel("Hi, please give me your name: ");
        add(label1);

        textField=new JTextField(10);
        add(textField);

        button1=new JButton("Please Click Me");
        add(button1);
        label2=new JLabel("");
        add(label2);
        button1.addActionListener(new clicker());


        dp=new DrawingPanel();
        dp2=new DrawingPanel2();
        dp3=new DrawingPanel3();
        dp4=new DrawingPanel4();


        setLayout(new FlowLayout());

    }
    public class clicker implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=textField.getText();
            label2.setText("Welcome to our application "+name+". How can I help you ? :)");
            button2=new JButton("Choose ------> P1-P2-P3 ");
            add(button2);
            button4=new JButton("Choose ------> P4-P5-P6 ");
            add(button4);


            button3=new JButton("Exit !");
            add(button3);
            button2.addActionListener(new filer1());
            button4.addActionListener(new filer2());
            button3.addActionListener(new exiter());
        }
    }
    public class filer1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser("./src/OOP/first");

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();

                String fileName=""+selectedFile;
                System.out.println(selectedFile);

                try
                {
                    Scanner input=new Scanner(new File(fileName));
                    String control=""+input.next();
                    if(control.equals("P1"))
                    {
                        String info=input.nextLine();
                        String info2=input.nextLine();


                        System.out.println(info);
                        System.out.println(info2);

                        width=Integer.parseInt(input.next());
                        height=Integer.parseInt(input.next());


                        System.out.println(width+"\n"+height+"\n");

                        array=new int[width*height];

                        for (int i=0;i<height*width;i++)
                        {

                            array[i]=Integer.parseInt(input.next());
                            if(array[i]==0)
                            {
                                array[i]=255;
                            }
                        }

                        JFrame frame=new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(width,height);
                        frame.setTitle("P1");
                        frame.setVisible(true);
                        frame.add(dp);
                    }
                    else if(control.equals("P2"))
                    {
                        width=Integer.parseInt(input.next());
                        height=Integer.parseInt(input.next());
                        maxVal=Integer.parseInt(input.next());

                        System.out.println(width+"\n"+height+"\n"+maxVal+"\n");

                        array=new int[width*height];

                        for (int i=0;i<height*width;i++)
                        {
                            array[i]=Integer.parseInt(input.next());
                        }
                        JFrame frame=new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(width,height);
                        frame.setTitle("P2");
                        frame.setVisible(true);
                        frame.add(dp);
                    }
                    else if(control.equals("P3"))
                    {
                        String info=input.nextLine();
                        //String info2=input.nextLine();


                        System.out.println(info);
                        //System.out.println(info2);

                        width=Integer.parseInt(input.next());
                        height=Integer.parseInt(input.next());
                        maxVal=Integer.parseInt(input.next());


                        System.out.println(width+"\n"+height+"\n"+maxVal+"\n");



                        coloredPixels = new int[width * height][3];
                        for (int i = 0; i < width * height; i++)
                        {
                            for(int j = 0 ; j < 3 ; j++)
                            {
                                coloredPixels[i][j] = Integer.parseInt(input.next());
                            }
                        }

                        JFrame frame=new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(width,height);
                        frame.setTitle("P3");
                        frame.setVisible(true);
                        frame.add(dp3);
                        System.out.println("p3Done");
                    }
                    else
                    {
                        System.out.println("Error");
                    }
                }
                catch(FileNotFoundException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
    public class filer2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser2 = new JFileChooser("./src/OOP/second");

            int returnValue = fileChooser2.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    File selectedFile2 = fileChooser2.getSelectedFile();

                    String fileName2=""+selectedFile2;

                    FileInputStream fis=new FileInputStream(fileName2);

                    byte [] magicNum = new byte[2];

                    fis.read(magicNum);
                    String control=new String(magicNum);
                    System.out.println(control);

                    if(control.equals("P4"))
                    {
                        // IT'S NOT WORKING, I'M SORRY :(
                    }
                    else if(control.equals("P5"))
                    {
                        char chByte = (char) fis.read();
                        while(Character.isWhitespace(chByte))
                        {
                            chByte = (char) fis.read();
                        }
                        byte fb = (byte) chByte;

                        int count = 1;
                        byte [] w = new byte[3];
                        w[0] = fb;

                        byte aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            w[count++] = aByte;
                            aByte = (byte) fis.read();
                        }
                        System.out.println("count: " + count);
                        int i = 0;

                        String strWidth = new String(w);

                        System.out.println(strWidth);

                        width = Integer.parseInt(strWidth);

                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }


                        count = 1;
                        byte [] h = new byte[3];
                        h[0] = aByte;


                        aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            h[count++] = aByte;
                            aByte = (byte) fis.read();
                        }

                        height = Integer.parseInt(new String(h));
                        System.out.println("height: " + height);


                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }


                        count = 1;
                        byte [] mv = new byte[3];
                        mv[0] = aByte;
                        aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            mv[count++] = aByte;
                            aByte = (byte) fis.read();
                        }
                        System.out.println("Max.Value: " + new String(mv));

                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }

                        pixs = new int[width*height];
                        pixs[0] = aByte;
                        for(int k = 1; k < width*height; k++)
                        {
                            pixs[k] =  fis.read();
                        }
                        JFrame frame=new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(width,height);
                        frame.setTitle("p5");
                        frame.setVisible(true);
                        frame.setLocation(100,100);
                        frame.add(dp2);
                    }
                    else if(control.equals("P6"))
                    {
                        char chByte = (char) fis.read();
                        while(Character.isWhitespace(chByte))
                        {
                            chByte = (char) fis.read();
                        }
                        byte fb = (byte) chByte;

                        int count = 1;
                        byte [] w = new byte[3];
                        w[0] = fb;

                        byte aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            w[count++] = aByte;
                            aByte = (byte) fis.read();
                        }
                        System.out.println("count: " + count);
                        int i = 0;

                        String strWidth = new String(w);

                        System.out.println(strWidth);

                        width = Integer.parseInt(strWidth);

                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }


                        count = 1;
                        byte [] h = new byte[3];
                        h[0] = aByte;


                        aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            h[count++] = aByte;
                            aByte = (byte) fis.read();
                        }

                        height = Integer.parseInt(new String(h));
                        System.out.println("height: " + height);


                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }


                        count = 1;
                        byte [] mv = new byte[3];
                        mv[0] = aByte;
                        aByte = (byte) fis.read();
                        while(!Character.isWhitespace(aByte))
                        {
                            mv[count++] = aByte;
                            aByte = (byte) fis.read();
                        }
                        System.out.println("Max.Value: " + new String(mv));

                        aByte = (byte) fis.read();
                        while(Character.isWhitespace(aByte))
                        {
                            aByte = (byte) fis.read();
                        }

                        //pixs = new int[width*height][3];
                        //pixs[0] = aByte;
                        coloredPixels = new int[width * height][3];
                        coloredPixels[0][0]=aByte;
                        for (int k = 0; k < width * height; k++)
                        {
                            for(int j = 0 ; j < 3 ; j++)
                            {
                                coloredPixels[k][j] = fis.read();
                            }
                        }
                        JFrame frame=new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(width,height);
                        frame.setTitle("p6");
                        frame.setVisible(true);
                        frame.setLocation(100,100);
                        frame.add(dp3);

                    }
                    else
                    {
                        System.out.println("Error");
                    }

                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
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
                    int newColor=array[width*row+col];
                    Color c=new Color(newColor,newColor,newColor);

                    g.setColor(c);
                    g.drawRect(row,col,1,1);

                }
            }
        }
    }
    class DrawingPanel2 extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(int row = 0; row < height; row++)
                for(int col = 0; col < width; col++)
                {

                    try
                    {
                        Color c = new Color(
                                pixs[row*width+col],
                                pixs[row*width+col],
                                pixs[row*width+col]);
                        g.setColor(c);
                        g.fillRect(col,row,1,1);
                    }
                    catch(IllegalArgumentException e)
                    {

                    }
                }
        }
    }
    class DrawingPanel3 extends JPanel
    {
        public void paintComponent(Graphics gr)
        {
            super.paintComponent(gr);
            for (int row = 0; row < height; row++)
            {
                for (int col = 0; col < width; col++)
                {
                    try
                    {
                        p3Color=new Color(coloredPixels[row * width + col][0] , coloredPixels[row * width + col][1] , coloredPixels[row * width + col][2]);

                        gr.setColor(p3Color);
                        gr.drawRect(col,row,1,1);
                    }
                    catch(IllegalArgumentException e)
                    {

                    }

                }
            }

        }
    }
    class DrawingPanel4 extends JPanel
    {
        public void paintComponent(Graphics gra)
        {
            super.paintComponent(gra);
            for(int row=0;row<height;row++)
            {
                for(int col=0;col<width;col++)
                {
                    int newColor2=pixs[width*row+col];
                    Color ce=new Color(newColor2,newColor2,newColor2);

                    gra.setColor(ce);
                    gra.drawRect(row,col,1,1);

                }
            }

        }
    }
    public class exiter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        quiz window=new quiz();
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setTitle("Front Desk");
    }
}
