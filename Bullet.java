package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bullet extends Projectile
{
    private Image img;


    public Bullet( int x, int y, ID id )
    {
        super( x, y, id );
        width = 30;
        height = 30;
        try
        {
            img = ImageIO.read( new File( "bullet.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public void tick()
    {
        x += velX;
        y += velY;
        x = Game.clamp( x, 0, Game.WIDTH - width );
        y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
    }
    public void render( Graphics g )
    {
        g.setColor( Color.BLACK );
        g.drawImage( img, x, y, width, height, null );
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }


}