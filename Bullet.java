package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bullet extends Projectile
{
    public int damage;

    public int x, y, width, height;

    public boolean intact;

    private Image img;


    public Bullet( int x, int y )
    {
        super( x, y );
        try
        {
            img = ImageIO.read( new File( "bullet.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }


    public void update( Graphics g, Tank t )
    {
        g.setColor( Color.BLACK );
        g.drawImage( img, t.cx, t.cy, width, height, null );
    }


    public void move()
    {
        x -= 10;
    }
}