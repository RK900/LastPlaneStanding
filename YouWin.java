package LastPlaneStanding;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class YouWin extends GameObject
{
    public YouWin(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render( Graphics g )
    {
        //g.drawImage("youwin.jpg", 0,0, new ImageObserver());
        
    }

    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
