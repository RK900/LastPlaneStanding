package LastPlaneStanding;

import java.awt.*;


/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  rohankoodli
 *  @version May 18, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan Ravi David
 */
public class Player extends GameObject
{
    public static int bombCount = 0;
    
    private int width, height;

    private Handler handler;
    public boolean tickUpdate = false;

    /**
     * @param x X pos
     * @param y Y pos
     * @param id ID
     * @param handler Handler
     */
    public Player( int x, int y, ID id, Handler handler )
    {
        super( x, y, id );
        this.handler = handler;
        width = 30;
        height = 30;

    }


    /**
     * Updates player
     */
    public void tick()
    {
        tickUpdate = true;
        x += velX;
        y += velY;
        x = Game.clamp( x, 0, Game.WIDTH - width );
        y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
        collideTank();
        if ( HUD.HEALTH <= 0 )
        {
            handler.removeObject( this );
        }
        
    }


    /**
     * Renders player
     */
    public void render( Graphics g )
    {
        g.setColor( Color.white );
        g.fillRect( x, y, width, height );
        collideTank();
    }


    /**
     * Checks for collisions
     */
    public void collideTank()
    {
        for ( int i = 0; i < handler.object.size(); i++ )
        {
            GameObject temp = handler.object.get( i );
            if ( temp.getID() == ID.EnemyPlayer )
            {
                if ( getBounds().intersects( temp.getBounds() ) )
                {
                    HUD.HEALTH -= 10;
                    handler.removeObject( temp );
                }
            }
        }
    }


    /**
     * Fires Bomb
     */
    public void fire()
    {
        if ( bombCount < 2 )
        {
            handler.addObject( new Bomb( x, y, ID.Bomb, handler ) );
            bombCount++;
        }
    }


    /** 
     * Gets bounds of player
     * @return Rectangle of bounds
     */
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle( x, y, width, height );

    }
}
