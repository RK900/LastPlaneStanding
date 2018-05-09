package LastPlaneStanding;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Tank extends Shooter
{

    private int accuracy;
    private int speed;
    private boolean markedDead, isDead, toBeRemoved;
    private int x, y, cx, cy = 0;
    public Image img;

    public Tank( int health, int x, int y, int accuracy, int speed) 
    {
         super(health, x, y);
         this.accuracy = accuracy;
         this.speed = speed;
         this.x = x;
         this.y = y;
         try
         {
             img = ImageIO.read( new File( "Tank.png" ) );
         }
         catch ( IOException e )
         {
             e.printStackTrace();
         }
    }
    
        
    public void move()
    {
        if(isDead || markedDead){
            x -= speed;
            if(x > width) toBeRemoved = true;
        }
        else {
            x += cx;
            if(x>=shooter.getX()) isDead = true;
        }
    }
    
    public int getX()
    {
        return cx;
    }
    
    public int getY() 
    {
        return cy;
    }
        
    public boolean isHit(Bullet bullet)
    {
        int mx = bullet.getX();
        int my = bullet.getY();
        
        if( (mx>=x-width/2 && mx<=x+width/2 && my>=y && my<=y+height) ||
            (mx>=x-mx/2 && mx<=x+mx/2 && my>=y+height && my<=y+2*height) ||
            (mx>=x-width/2 && mx<=x+width/2 && my>=y+2*height && my<=y+3*height) ) return true;
        
        return false;
    }
        
    
}
