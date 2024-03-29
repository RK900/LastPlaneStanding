package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


/**
 * SmartTank SmartTank aims projectiles at the Player instead of randomly
 *
 * @author rohankoodli
 * @version May 16, 2018
 * @author Period: 2
 * @author Assignment: APCS2
 *
 * @author Sources: Rohan, Ravi, David
 */
public class SuperTank extends Tank
{

    private int scoreKeep = new Random().nextInt( 75 );

    private HUD hud;

    private Handler handler;


    /**
     * @param x
     *            X location
     * @param y
     *            Y location
     * @param id
     *            ID
     * @param life health
     * @param hud heads up display
     * @param handler
     *            Handler
     */
    public SuperTank( int x, int y, ID id, float life, HUD hud, Handler handler )
    {
        super( x, y, id, life, hud, handler );
        this.hud = hud;
        this.handler = handler;

    }


    /**
     * Updates Tank
     */
    public void tick()
    {
        int r = new Random().nextInt( 1 );
        int m = new Random().nextInt( 20 ); 
        int n = new Random().nextInt( 3 );
        if ( r == 0 )
            x += velX;
        else
            x -= velX;
        // velY += accY;
        if ( x <= 0 || x >= Game.WIDTH - 16 || m == 1 )
        {
            velX *= -1;
        }
        if ( !Game.lose )
        {
            scoreKeep++;
        }
        if ( scoreKeep >= 100 )
        {
            scoreKeep = 0;
            handler.addObject( new SmartEnemyPlayer( x, y, ID.EnemyPlayer, handler ) );
        }
    }


    /**
     * Renders Tank
     */
    public void render( Graphics g )
    {
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setComposite( makeTransparent( alpha ) );
        g.setColor( Color.orange );
        g.fillRect( x, y, width, height );
        // g.drawImage( img, x, y, width, height, null );
        // g2d.setComposite( makeTransparent( 1 ));
    }

}