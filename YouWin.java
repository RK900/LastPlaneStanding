package LastPlaneStanding;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *  YouWin
 *  Prints YouWin if you win
 *
 *  @author  rohankoodli
 *  @version May 22, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan Ravi David
 */
public class YouWin extends GameObject
{
    private String s;
    private Font font;
    
    
    /**
     * @param x X location
     * @param y Y location
     * @param id ID
     * @param s String to show
     */
    public YouWin(int x, int y, ID id, String s) {
        super(x, y, id);
        font = new Font( "SansSerif", Font.PLAIN, 36 );
        this.s = s;
    }

    /**
     * Updates the YouWin object
     */
    @Override
    public void tick()
    {
        // TODO Auto-generated method stub
        
    }

    /**
     * Renders the YouWin object
     */
    @Override
    public void render( Graphics g )
    {
        g.setFont( font );
        g.setColor( Color.white );
        g.drawString( s, x, y );
        Game.lose = true;
        
    }

    /**
     * Gets bounds of YouWin
     * @return Rectangle bounds
     */
    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
