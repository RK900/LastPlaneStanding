package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Plane extends Shooter 
{

    public Image img;
    private Handler handler;

    public Plane( int health, int x, int y, ID id, Handler handler )
    {
        super( health, x, y, id, handler );
        width = 32;
        height = 32;
        try
        {
            img = ImageIO.read( new File( "plane.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }


    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp( x, 0, Game.WIDTH - width );
        y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
        handler.addObject( new Bomb( getX(), getY(), ID.Bomb) );
    }
    public void collideBullet()
    {
        for ( int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get( i );
            if( temp.getID() == ID.Bullet)
            {
                if ( getBounds().intersects( temp.getBounds() ))
                {
                    health = 0;
                }
            }
        }
    }
    
    public void collideTank()
    {
        for ( int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get( i );
            if( temp.getID() == ID.Tank)
            {
                if ( getBounds().intersects( temp.getBounds() ))
                {
                    health = 0;
                }
            }
        }
    }
    public void collideEnemyPlane()
    {
        for ( int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get( i );
            if( temp.getID() == ID.EnemyPlane)
            {
                if ( getBounds().intersects( temp.getBounds() ))
                {
                    health = 0;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(img, x, y, width, height, null);
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

    public boolean isAlive()
    {
        return health > 0;
    }
}