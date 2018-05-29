package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable, KeyListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private Graphics2D g2d;
    private BufferedImage image;

    private Thread thread;
    private boolean running;
    private long targetTime;

    private final int SIZE = 10;
    private Queue head,apple;
    private ArrayList<Queue>   snake;
    private int score;
    private int level;
    private int length;
    private boolean gameOver;

    private int dx,dy;
    private boolean up,down,right,left,start;


    public GamePanel()
    {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void addNotify()
    {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }
    private void setFPS(int fps)
    {
        targetTime = 1000 / fps;
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        int k=e.getKeyCode();

        if (k == KeyEvent.VK_UP) up = true;
        if (k == KeyEvent.VK_DOWN) down = true;
        if (k == KeyEvent.VK_LEFT) left = true;
        if (k == KeyEvent.VK_RIGHT) right = true;
        if (k == KeyEvent.VK_ENTER) start = true;
    }

    public void keyReleased(KeyEvent e)
    {
        int k=e.getKeyCode();

        if (k == KeyEvent.VK_UP) up = false;
        if (k == KeyEvent.VK_DOWN) down = false;
        if (k == KeyEvent.VK_LEFT) left = false;
        if (k == KeyEvent.VK_RIGHT) right = false;
        if (k == KeyEvent.VK_ENTER) start = false;
    }

    public void run()
    {
        if (running) return;
        init();
        long startTime;
        long elapsed;
        long wait;

        while (running)
        {
            startTime = System.nanoTime();

            update();
            requestRender();

            elapsed = System.nanoTime() - startTime;
            wait = targetTime - elapsed / 1000000;
            if (wait>0)
            {
                try
                {
                    Thread.sleep(wait);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    private void init()
    {
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        running = true;
        setUpLevel();
        gameOver=false;
        level = 1;
        setFPS(level * 10);
    }
    private void setUpLevel()
    {
        snake = new ArrayList<Queue>();
        head = new Queue(SIZE);
        head.setPosition(WIDTH/2,HEIGHT/2);
        snake.add(head);

        for (int i = 1; i<3;i++)
        {
            Queue e = new Queue(SIZE);
            e.setPosition(head.getX()+(i*SIZE),head.getY());
            snake.add(e);
        }
        apple = new Queue(SIZE);
        setApple();
        score = 0;
        length = 3;
        level = 1;
        dx = dy = 0;
        gameOver = false;
    }
    public void setApple()
    {
        int x = (int) (Math.random()*(WIDTH-SIZE));
        int y = (int) (Math.random()*(HEIGHT-SIZE));
        x = x-(x % SIZE);
        y = y-(y % SIZE);
        apple.setPosition(x,y);
    }
    private void requestRender()
    {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();
    }
    private void update()
    {
        if (gameOver)
        {
            if (start)
            {
                setUpLevel();
            }
            return;
        }
        if (up && dy == 0)
        {
            dy = -SIZE;
            dx = 0;
        }
        if(down && dy == 0)
        {
            dy = SIZE;
            dx = 0;
        }
        if (left && dx == 0)
        {
            dy = 0;
            dx = -SIZE;
        }
        if(right && dx == 0 && dy!=0 )
        {
            dy = 0;
            dx = SIZE;
        }
        if (dx != 0 || dy!=0)
        {
            for(int i= snake.size()-1;i>0;i--)
            {
                snake.get(i).setPosition(snake.get(i-1).getX(),snake.get(i-1).getY());
            }
            head.move(dx,dy);
        }

        for (Queue e : snake)
        {
            if(e.isCollsion(head))
            {
                gameOver = true;
                break;
            }
        }
        if(apple.isCollsion(head))
        {
            score++;
            length++;
            setApple();

            Queue e = new Queue(SIZE);
            e.setPosition(-100,-100);
            snake.add(e);
            if (score % 5 == 0)
            {
                level++;
                if (level>10) level = 10;
                setFPS(level*5);
            }
        }

        if (head.getX()<0) head.setX(WIDTH);
        if (head.getY()<0) head.setY(HEIGHT);
        if (head.getX()>WIDTH) head.setX(0);
        if (head.getY()>HEIGHT) head.setY(0);
    }
    public void render(Graphics2D g2d)
    {
        g2d.clearRect(0,0,WIDTH,HEIGHT);

        g2d.setColor(Color.green);
        for(Queue e: snake)
        {
            e.render(g2d);
        }
        g2d.setColor(Color.red);
        apple.render(g2d);

        if (gameOver)
        {
            g2d.drawString("GAME OVEEEER !",150,200);
        }

        g2d.setColor(Color.white);
        g2d.drawString("Score: "+score+"  Level: "+level+"   Length: "+length,10,20);
    }

    public static void main(String args[])
    {
        JFrame jframe = new JFrame("Snake Game");
        jframe.setContentPane(new GamePanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setPreferredSize(new Dimension(GamePanel.WIDTH,GamePanel.HEIGHT));
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}

