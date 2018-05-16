package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Shooter extends GameObject
{
    public int width, height;
    private Handler handler;


    public Shooter( int x, int y, ID id, Handler handler )
    {
        super(x, y, id);
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