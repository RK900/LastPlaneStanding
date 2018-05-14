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


public class Trail extends Projectile
{

    private Image img;
    private Color color;
    private float life;
    private float alpha = 1;
    private Handler handler;
    private int width, height;
    public Trail( int x, int y, ID id, Color color, int width, int height, float life, Handler handler )
    {
        super( x, y, id );
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }


    public void tick()
    {
        if( alpha > life)
        {
            alpha -= (life - 0.000000001f);
        }else handler.removeObject( this );
        //y += velY;
        //velY += accY;
        //y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
    }


    public void render( Graphics g )
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite( makeTransparent( alpha  ) );
        g.setColor( color );
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