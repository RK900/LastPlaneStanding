package LastPlaneStanding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
*
*  Prints out gameOver or youWin
*
*  @author  Rohan
*  @version May 20, 2018
*  @author  Period: 2
*  @author  Assignment: APCSFinal
*
*  @author  Sources: Ravi, Rohan, David
*/

public class YouWin extends GameObject
{
    private String s;
    
    /**
     * Constructor of YouWin
     * @param x
     * @param y
     * @param id
     * @param s
     */
    public YouWin(int x, int y, ID id, String s) {
        super(x, y, id);
        this.s = s;
    }

    /**
     * Updates win
     */
    @Override
    public void tick()
    {
        // TODO Auto-generated method stub
        
    }

    /**
     * Renders winning
     *
     */
    @Override
    public void render( Graphics g )
    {
        g.setColor( Color.white );
        g.drawString( s, x, y );
        Game.lose = true;
        
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
