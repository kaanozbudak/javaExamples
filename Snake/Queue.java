package Snake;

import java.awt.*;

public class Queue
{
    private int x;
    private int y;
    private int size;

    public Queue(int size)
    {
        this.size = size;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    public void setPosition(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public void move(int dx,int dy)
    {
        x += dx;
        y += dy;
    }
    public Rectangle getBound()
    {
        return new Rectangle(x,y,size,size);
    }
    public boolean isCollsion(Queue o)
    {
        if (o == this) return false;
        return getBound().intersects(o.getBound());
    }
    public void render(Graphics2D g2d)
    {
        g2d.fillRect(x+1,y+1,size-2,size-2);
    }
}
