package LastPlaneStanding;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Tank extends Projectile
{

    private Image img;

    private int accY;

    private float alpha = 1;

    private float life;

    private Handler handler;

    private HUD hud;

    private int scoreKeep = new Random().nextInt(75);


    public Tank( int x, int y, ID id, float life, HUD hud, Handler handler )
    {
        super( x, y, id );
        width = 30;
        height = 30;
        this.life = life;
        this.handler = handler;
        this.hud = hud;
        accY = 1;
        velX = 5;
        try
        {
            img = ImageIO.read( new File( "bomb.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }


    public void tick()
    {
        // if( alpha > life)
        // {
        // alpha -= (life - 0.001f);
        // }else handler.removeObject( this );
        int r = new Random().nextInt( 1 );
        if(r == 0)
            x += velX;
        else
            x -= velX;
        // velY += accY;
        if ( x <= 0 || x >= Game.WIDTH - 16 )
        {
            velX *= -1;
        }
        scoreKeep++;
        if ( scoreKeep >= 100 )
        {
            scoreKeep = 0;
            hud.setLevel( hud.getLevel() + 1 );
            handler.addObject( new EnemyPlayer( x, y, ID.EnemyPlayer, handler ) );
        }
    }


    public void render( Graphics g )
    {
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setComposite( makeTransparent( alpha ) );
        g.setColor( Color.white );
        g.fillRect( x, y, width, height );
        // g.drawImage( img, x, y, width, height, null );
        // g2d.setComposite( makeTransparent( 1 ));
    }


    public Rectangle getBounds()
    {
        return new Rectangle( x, y, width, height );
    }
}