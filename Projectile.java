package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject
{
    public int damage, width, height;

    public boolean intact;


    public Projectile( int x, int y, ID id )
    {
        super( x , y, id);
        damage = 10;
        intact = true;
    }


    @Override
    public void tick()
    {
        
    }


    @Override
    public void render( Graphics g )
    {
        
    }


    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }

}