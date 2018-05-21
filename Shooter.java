package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *  Shooter Class for Tanks and Planes
 *
 *  @author  rohankoodli
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan Ravi David
 */
public class Shooter extends GameObject
{
    public int width, height;
    private Handler handler;


    /**
     * @param x X position
     * @param y Y position
     * @param id ID
     * @param handler Handler
     */
    public Shooter( int x, int y, ID id, Handler handler )
    {
        super(x, y, id);
        this.handler = handler;

    }


    /** 
     * Updates all shooters
     */
    public void tick()
    {
    }


    /** 
     * Renders all shooters
     */
    public void render( Graphics g )
    {
        
    }


    /** 
     * Updates all shooters
     * @return Rectangle Bounds of screen
     */
    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }

}