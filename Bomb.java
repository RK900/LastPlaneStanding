package LastPlaneStanding;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
*
*  Derives Projectile and falls in a straight line.
*  It is more powerful than a Bullet.
*
*  @author  David Xu
*  @version May 20, 2018
*  @author  Period: 2
*  @author  Assignment: APCSFinal
*
*  @author  Sources: Ravi, Rohan, David
*/
public class Bomb extends Projectile
{
   private Image img;

   private int accY;
   private float alpha = 1;
   private Handler handler;
   
   /**
   * Bomb constructor
   * @param x X position
   * @param y Y position
   * @param id ID
   * @param handler Handler
   */
   public Bomb( int x, int y, ID id, Handler handler )
   {
       super( x, y, id );
       width = 10;
       height = 10;
       this.handler = handler;
       accY = 1;
       velX = 3;
       try
       {
           img = ImageIO.read( new File( "bomb.png" ) );
       }
       catch ( IOException e )
       {
           e.printStackTrace();
       }
   }

   /**
   * Update bomb
   */
   public void tick()
   {
       y += velY;
//     if( alpha > life)
//     {
//         alpha -= (life - 0.001f);
//     }else handler.removeObject( this );
       velY += accY;
//     if ( x <= 0 || x >= Game.WIDTH - 16) {
//         velX *= -1;
//     }    
       if (y >= Game.HEIGHT - 16)
       {
           handler.removeObject( this );
           Player.bombCount--;
       }
    
       collide();
    
   }

   /**
   * Renders bomb
   */
   public void render( Graphics g )
   {
       Graphics2D g2d = (Graphics2D) g;
       g2d.setComposite( makeTransparent( alpha  ) );
       g.setColor( Color.white );
       g.fillRect( x, y, width, height );
       //g.drawImage( img, x, y, width, height, null );
       g2d.setComposite( makeTransparent( 1 ));
   }
   
   /**
   *
   * Touches the enemies.
   */
   public void collide() {
       for ( int i = 0; i < handler.object.size(); i++)
       {
           GameObject temp = handler.object.get( i );
           if( temp.getID() == ID.Tank)
           {
               if ( getBounds().intersects( temp.getBounds() ))
               {
                   //HUD.HEALTH -= 10;
                   handler.removeObject( temp );
                   handler.removeObject( this );
                   Player.bombCount--;
               }
           }
           if( temp.getID() == ID.SmartTank)
           {
               if ( getBounds().intersects( temp.getBounds() ))
               {
                   //HUD.HEALTH -= 10;
                   handler.removeObject( temp );
                   handler.removeObject( this );
                   Player.bombCount--;
               }
           }
           if( temp.getID() == ID.SuperTank)
           {
               if ( getBounds().intersects( temp.getBounds() ))
               {
                   //HUD.HEALTH -= 10;
                   handler.removeObject( temp );
                   handler.removeObject( this );
                   Player.bombCount--;
               }
           }
       }
   }
   
   /**
   *
   * Makes the image background transparent
   * @param alpha
   * @return
   */
   private AlphaComposite makeTransparent( float alpha )
   {
       int type = AlphaComposite.SRC_OVER;
       return AlphaComposite.getInstance( type, alpha );
   }
   
   /**
   * gets bounds of screen
   *
   * @return Rectangle with screen bounds
   */
   public Rectangle getBounds()
   {
       return new Rectangle(x, y, width, height);
   }
}