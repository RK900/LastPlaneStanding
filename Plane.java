package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plane extends Shooter
{
    private int health;
    public int x, y, cx, cy, width, height;
    public Image img;
    public Plane( int health, int x, int y )
    {
        super(health, x, y);
        health = 10;
        cx = x;
        cy = y;
        width = 10;
        height = 10;
        try {
            img = ImageIO.read(new File("plane.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(img, x, y, width, height, null);
    }
    public void move()
    {
       
    }
    public void reset()
    {
        
    }
    public int getX()
    {
        return cx;
    }
    public int getY()
    {
        return cy;
    }
    

}