package LastPlaneStanding;

import java.awt.*;
import java.util.Random;


public class EnemyPlayer extends GameObject
{

    private Handler handler;

    private Random random;


    public EnemyPlayer(int x, int y, ID id, Handler handler)
    {
        super( x, y, id );
        this.handler = handler;
        this.random = new Random();
        velX = random.nextInt( 20 ) - 10;
        velY = -(int)Math.sqrt( 10 * 10 - velX * velX );
    }


    public void tick()
    {
        x += velX;
        y += velY;
         if ( y <= 0 || y >= Game.HEIGHT - 12) {
         handler.removeObject( this );
         }
         if ( x <= 0 || x >= Game.WIDTH - 16) {
             handler.removeObject( this );
         }
        // handler.addObject( new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.1f,
        // handler ) );
        handler.addObject( new Bullet( x, y, ID.Bullet, 0.1f, handler ) );
        if ( y <= 0 )
        {
            handler.removeObject( this );
        }
        
    }


    public void render( Graphics g )
    {
        g.setColor( Color.gray );
        g.fillRect( x, y, 8, 8 );
    }


    @Override
    public Rectangle getBounds()
    {
        return new Rectangle( x, y, 32, 32 );
    }
}
