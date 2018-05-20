package LastPlaneStanding;

import java.awt.*;


public class Player extends GameObject
{
    public static int bombCount = 0;
    
    private int width, height;

    private Handler handler;

    public Player( int x, int y, ID id, Handler handler )
    {
        super( x, y, id );
        this.handler = handler;
        width = 30;
        height = 30;

    }


    public void tick()
    {
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


    public void render( Graphics g )
    {
        g.setColor( Color.white );
        g.fillRect( x, y, width, height );
        collideTank();
    }


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


    public void fire()
    {
        if ( bombCount < 2 )
        {
            handler.addObject( new Bomb( x, y, ID.Bomb, handler ) );
            bombCount++;
        }
    }


    @Override
    public Rectangle getBounds()
    {
        return new Rectangle( x, y, width, height );

    }
}
