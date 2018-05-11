package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Shooter extends GameObject
{
    public int health, width, height;
    private Handler handler;


    public Shooter( int health, int x, int y, ID id, Handler handler )
    {
        super(x, y, id);
        this.health = health;
        this.handler = handler;
    }


    public void tick()
    {
    }


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