package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bomb extends Projectile
{
    public int damage;

    public int x, y, cy, width, height;

    public boolean intact;

    private Image img;


    public Bomb( int x, int y )
    {
        super( x, y );
        try
        {
            img = ImageIO.read( new File( "bomb.jpg" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }


    public void update( Graphics g, Plane p )
    {
        g.setColor( Color.BLACK );
        g.drawImage( img, p.cx, p.cy, width, height, null );
    }


    public void move()
    {
        y += cy;
        cy += 0.5f;
    }
}