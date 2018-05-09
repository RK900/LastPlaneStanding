package LastPlaneStanding;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SmartTank extends Tank
{
    private static final int ACCURACY = 5;
    private static final int SPEED = 5;
    private int x, y, cx, cy = 0;
    public Image img;
    
    public SmartTank(int health, int x, int y) 
    {
        super(8, x, y, ACCURACY, SPEED);
        cx = x;
        cy = y;
        try
        {
            img = ImageIO.read( new File( "SmartTank.png" ) );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
    
    public void move()
    {
        
    }
    
    public int getX()
    {
        return cx;
    }
    
    public int getY()
    {
        return cy;
    }
}