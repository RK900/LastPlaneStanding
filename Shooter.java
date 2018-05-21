package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 *  The superclass for all of our moving shooters.
 *
 *  @author  David Xu
 *  @version May 20, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCSFinal
 *
 *  @author  Sources: Ravi, Rohan David
 */
public class Shooter extends GameObject
{
    public int width, height;
    private Handler handler;

    /**
     * Shooter constructor
     * @param x
     * @param y
     * @param id
     * @param handler
     */
    public Shooter( int x, int y, ID id, Handler handler )
    {
        super(x, y, id);
        this.handler = handler;

    }

    /**
     * Updates shooter
     */
    public void tick()
    {
    }

    /**
     * Renders shotoer
     */
    public void render( Graphics g )
    {
        
    }

    /**
     * gets bounds of screen
     * 
     * @return Rectangle with screen bounds
     */
    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}