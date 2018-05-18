package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 *  SmartTank
 *  SmartTank aims projectiles at the Player instead of randomly
 *
 *  @author  rohankoodli
 *  @version May 16, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi, David
 */
public class EnemyPlane extends Projectile
{
    
    private int scoreKeep = new Random().nextInt(75);
    private HUD hud;
    private Handler handler;
    
    /**
     * @param x X location
     * @param y Y location
     * @param id ID
     * @param handler Handler
     */
    public EnemyPlane( int x, int y, ID id, float life, HUD hud, Handler handler )
    {
        super(x, y, id);
        this.hud = hud;
        this.handler = handler;
        
    }
    
    /** 
     * Updates Tank
     */
    public void tick() {
        int r = new Random().nextInt( 1 );
        if(r == 0)
            x += velX;
        else
            x += velX;
        // velY += accY;
        if ( y <= 0 || y >= Game.HEIGHT - 12) {
            handler.removeObject( this );
            }
            if ( x <= 0 || x >= Game.WIDTH - 16) {
                handler.removeObject( this );
            }
        scoreKeep++;
        if ( scoreKeep >= 100 )
        {
            scoreKeep = 0;
            hud.setLevel( hud.getLevel() + 1 );
            handler.addObject( new EnemyPlayer( x, y, ID.EnemyPlayer, handler ) );
        }
        
        collide();
    }
    
    /** 
     * Renders Tank
     */
    public void render( Graphics g )
    {
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setComposite( makeTransparent( alpha ) );
        g.setColor( Color.red );
        g.fillRect( x, y, width, height );
        // g.drawImage( img, x, y, width, height, null );
        // g2d.setComposite( makeTransparent( 1 ));
    }
    
    
    public void collide() {
        for ( int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get( i );
            if( temp.getID() == ID.Player)
            {
                if ( getBounds().intersects( temp.getBounds() ))
                {
                    //HUD.HEALTH -= 10;
                    handler.removeObject( temp );
                }
            }
        }
    }
    
    
}