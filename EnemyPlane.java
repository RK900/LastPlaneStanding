package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class EnemyPlane extends Shooter
{
    private int health;

    public int x, y, width, height;

    public Image img;


    public EnemyPlane( int health, int x, int y )
    {
        super( health, x, y );
        try
        {
            img = ImageIO.read( new File( "enemyplane.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }


    public void update( Graphics g )
    {
        g.setColor( Color.BLACK );
        g.drawImage( img, x, y, width, height, null );
    }


    public void move()
    {
        x -= 10;
    }

    public boolean isAlive()
    {
        return health > 0;
    }
}