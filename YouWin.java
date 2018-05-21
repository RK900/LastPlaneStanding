package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class YouWin extends GameObject
{
    private String s;
    public YouWin(int x, int y, ID id, String s) {
        super(x, y, id);
        this.s = s;
    }

    @Override
    public void tick()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render( Graphics g )
    {
        g.setColor( Color.white );
        g.drawString( s, x, y );
        Game.lose = true;
        
    }

    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
