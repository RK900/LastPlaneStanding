package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *  SmartEnemyPlayer
 *  Smart Launcher for Bullet - Aims bullets at Player
 *
 *  @author  rohankoodli
 *  @version May 16, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi, David
 */
public class SmartEnemyPlayer extends EnemyPlayer
{
    private GameObject p;
    
    private Handler handler;
    
    private int scoreKeep = new Random().nextInt(75);
    
    /**
     * @param x X location
     * @param y Y location
     * @param id ID
     * @param handler Handler
     */
    public SmartEnemyPlayer( int x, int y, ID id, Handler handler ) {
        super(x, y, id, handler);
        this.handler = handler;
        //GameObject player;
        for(GameObject g : handler.object) {
            if(g.getID() == ID.Player)
                p = g;
        }
    }
    
    /** 
     * Updates SmartEnemyPlayer
     */
    public void tick() {
        
        scoreKeep++;
        if(scoreKeep >= 1) {
            scoreKeep = 0;
        
            double dist_x = (p.getX() - this.getX());
            double dist_y = (p.getY() - this.getY());
            
            double theta = (Math.atan(dist_y / dist_x));
            System.out.println( "theta:" + theta );
            
            if(theta < 0)
                theta = theta + Math.PI;
            
            velX = (int) (5 * Math.cos( theta ));
            velY = (int) (5 * Math.sin( theta ));
                            
            x += (-velX);
            y += (-velY);
        }
         if ( y <= 0 || y >= Game.HEIGHT - 12) {
         handler.removeObject( this );
         }
         if ( x <= 0 || x >= Game.WIDTH - 16) {
             handler.removeObject( this );
         }
        // handler.addObject( new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.1f,
        // handler ) );
        System.out.println( "x:" + x + " y:" + y );
        handler.addObject( new Bullet( x, y, ID.Bullet, 0.1f, handler ) );
        if ( y <= 0 )
        {
            handler.removeObject( this );
        }
        
    }
    
    /** 
     * Renders SmartEnemyPlayer
     */
    public void render( Graphics g )
    {
        g.setColor( Color.red );
        g.fillRect( x, y, 8, 8 );
    }
}
