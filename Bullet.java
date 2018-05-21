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
*  Derives Projectile.
*  Moves parallel to the direction of the plane/tank
*  and deals less damage than a Bomb.
*
*  @author  David Xu
*  @version May 20, 2018
*  @author  Period: 2
*  @author  Assignment: APCSFinal
*
*  @author  Sources: Ravi, Rohan, David
*/
public class Bullet extends Projectile
{
   private Image img;

   private int accY;
   private float alpha = 1;
   private float life;
   private Handler handler;
   
   /**
   * Bullet constructor
   * @param x
   * @param y
   * @param id
   * @param life
   * @param handler
   */
   public Bullet( int x, int y, ID id, float life, Handler handler )
   {
       super( x, y, id );
       width = 8;
       height = 8;
       this.life = life;
       this.handler = handler;
       accY = 1;
       try
       {
           img = ImageIO.read( new File( "bullet.png" ) );
       }
       catch ( IOException e )
       {
           e.printStackTrace();
       }
   }

   /**
   * Updates bullet
   */
   public void tick()
   {
       if( alpha > life)
       {
           alpha -= (life - 0.001f);
       }else handler.removeObject( this );
   }

   /**
   * Renders bullet
   */
   public void render( Graphics g )
   {
       Graphics2D g2d = (Graphics2D) g;
       g2d.setComposite( makeTransparent( alpha  ) );
       g.setColor( Color.red );
       g.fillRect( x, y, width, height );
       //g.drawImage( img, x, y, width, height, null );
       g2d.setComposite( makeTransparent( 1 ));
   }
   
   /**
   *
   * Makes the image background transparent.
   * @param alpha
   * @return object with no white background
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
