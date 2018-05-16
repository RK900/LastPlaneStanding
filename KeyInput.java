package LastPlaneStanding;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter
{
    private Handler handler;


    public KeyInput( Handler handler )
    {
        this.handler = handler;
    }


    public void keyPressed( KeyEvent e )
    {
        int key = e.getKeyCode();
        for ( int i = 0; i < handler.object.size(); i++ )
        {
            GameObject temp = handler.object.get( i );
            if ( temp.id == ID.Player)
            {
                if ( key == KeyEvent.VK_W )
                {
                    temp.setVelY( -5 );
                }
                if ( key == KeyEvent.VK_S )
                {
                    temp.setVelY( 5 );
                }
                if ( key == KeyEvent.VK_D )
                {
                    temp.setVelX( 5 );
                }
                if ( key == KeyEvent.VK_A )
                {
                    temp.setVelX( -5 );
                }
                if ( key == KeyEvent.VK_SPACE)
                {
                    ( (Player)temp ).fire();
                }
            }
        }
        if ( key == KeyEvent.VK_ESCAPE)
        {
            System.exit( 1 );
        }
    }


    public void keyReleased( KeyEvent e )
    {
        int key = e.getKeyCode();
        for ( int i = 0; i < handler.object.size(); i++ )
        {
            GameObject temp = handler.object.get( i );
            if ( temp.id == ID.Player )
            {
                if ( key == KeyEvent.VK_W )
                {
                    temp.setVelY( 0 );
                }
                if ( key == KeyEvent.VK_S )
                {
                    temp.setVelY( 0 );
                }
                if ( key == KeyEvent.VK_D )
                {
                    temp.setVelX( 0 );
                }
                if ( key == KeyEvent.VK_A )
                {
                    temp.setVelX( 0 );
                }
                if ( key == KeyEvent.VK_SPACE)
                {
                    ( (Player)temp ).fire();
                }
            }
        }
    }
}
