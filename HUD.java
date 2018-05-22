package LastPlaneStanding;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
*
*  Heads up Display
*  Shows how much health you have left
*
*  @author  Ravi
*  @version May 20, 2018
*  @author  Period: 2
*  @author  Assignment: APCSFinal
*
*  @author  Sources: Rohan, Ravi, David
*/
public class HUD
{
   public static int HEALTH = 100;

   private int greenValue = 255;

   private int score = 0;

   private int level = 1;
   
   private Font font = new Font( "SansSerif", Font.PLAIN, 14 );

   /**
   *
   * Updates health.
   */
   public void tick()
    {
        HEALTH = Game.clamp( HEALTH, 0, 100 );
        greenValue = Game.clamp( greenValue, 0, 255 );
        greenValue = HEALTH * 2;
    }

   /**
   * renders health
   * @param g Graphics component
   */
   public void render( Graphics g )
    {
        g.setFont( font );
        g.setColor( Color.gray );
        g.fillRect( 15, 15, 200, 32 );
        g.setColor( new Color( 75, greenValue, 0 ) );
        g.fillRect( 15, 15, HEALTH * 2, 32 );
        g.setColor( Color.white );
        g.drawRect( 15, 15, 200, 32 );
        g.drawString( "Level: " + level, 10, 80 );

    }

   /**
   *
   * Sets the score of the player.
   * @param score score of player
   */
   public void setScore( int score )
   {
       this.score = score;
   }

   /**
   *
   * Gets the Player's score.
   * @return score
   */
   public int getScore()
   {
       return score;
   }

   /**
   * Sets the game level.
   * @param level Level
   */
   public void setLevel( int level )
   {
       this.level = level;
   }

   /**
   * Gets the game level
   * @return level
   */
   public int getLevel()
   {
       return level;
   }

}
