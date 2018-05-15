package LastPlaneStanding;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bullet extends Projectile
{

    private Image img;

    private int accY;
    private float alpha = 1;
    private float life;
    private Handler handler;
    public Bullet( int x, int y, ID id, float life, Handler handler )
    {
        super( x, y, id );
        width = 8;
        height = 8;
        this.life = life;
        this.handler = handler;
        accY = 1;
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
        if( alpha > life)
        {
            alpha -= (life - 0.001f);
        }else handler.removeObject( this );
    }


    public void render( Graphics g )
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite( makeTransparent( alpha  ) );
        g.setColor( Color.red );
        g.fillRect( x, y, width, height );
        //g.drawImage( img, x, y, width, height, null );
        g2d.setComposite( makeTransparent( 1 ));
    }
    private AlphaComposite makeTransparent( float alpha )
    {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance( type, alpha );
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
}