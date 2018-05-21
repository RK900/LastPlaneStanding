package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
*
*  Defines how a Bomb or Bullet touches a Shooter.
*
*  @author  Rohan
*  @version May 20, 2018
*  @author  Period: 2
*  @author  Assignment: APCSFinal
*
*  @author  Sources: Ravi, Rohan, David
*/

public class Projectile extends GameObject
{
    public int damage, width, height;

    public boolean intact;


    /**
     * Projectile constructor
     * @param x
     * @param y
     * @param id
     */
    public Projectile( int x, int y, ID id )
    {
        super( x , y, id);
        damage = 10;
        intact = true;
    }


    /**
     * Updates all projectiles
     */
    @Override
    public void tick()
    {
        
    }


    /**
     * Renders projectiles
     * @param g graphics
     */
    @Override
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