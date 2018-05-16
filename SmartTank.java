package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class SmartTank extends Tank
{
    
    private int scoreKeep = new Random().nextInt(75);
    private HUD hud;
    private Handler handler;
    
    public SmartTank( int x, int y, ID id, float life, HUD hud, Handler handler )
    {
        super(x, y, id, life, hud, handler);
        this.hud = hud;
        this.handler = handler;
        
    }
    
    public void tick() {
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
            handler.addObject( new SmartEnemyPlayer( x, y, ID.EnemyPlayer, handler ) );
        }
    }
    
    public void render( Graphics g )
    {
        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setComposite( makeTransparent( alpha ) );
        g.setColor( Color.red );
        g.fillRect( x, y, width, height );
        // g.drawImage( img, x, y, width, height, null );
        // g2d.setComposite( makeTransparent( 1 ));
    }
    
    
}