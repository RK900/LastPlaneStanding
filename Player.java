package LastPlaneStanding;

import java.awt.*;


/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  rohankoodli
 *  @version May 18, 2018
 *  @author  Period: TODO
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: TODO
 */
public class Player extends GameObject
{

    private int width, height;
    private Handler handler;
    public boolean tickUpdate = false;

    /**
     * @param x
     * @param y
     * @param id
     * @param handler
     */
    public Player( int x, int y, ID id, Handler handler )
    {
        super( x, y, id );
        this.handler = handler;
        width = 30;
        height = 30;

    }


    public void tick()
    {
        tickUpdate = true;
        x += velX;
        y += velY;
        x = Game.clamp( x, 0, Game.WIDTH - width );
        y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
        collideTank();
        if(HUD.HEALTH <= 0) {
            handler.removeObject( this );
        }
        
    }


    public void render( Graphics g )
    {
        g.setColor( Color.white );
        g.fillRect( x, y, width, height );
        collideTank();
    }
    public void collideTank()
    {
        for ( int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get( i );
            if( temp.getID() == ID.EnemyPlayer)
            {
                if ( getBounds().intersects( temp.getBounds() ))
                {
                    HUD.HEALTH -= 10;
                    handler.removeObject( temp );
                }
            }
        }
    }

    public void fire()
    {
        handler.addObject( new Bomb(x, y, ID.Bomb, handler ));
    }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle( x, y, width, height );

    }
}
