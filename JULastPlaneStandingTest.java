package LastPlaneStanding;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;

/**
 *  Unit testing
 *  
 *
 *  @author  rohankoodli
 *  @version May 18, 2018
 *  @author  Period: TODO
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan
 */
public class JULastPlaneStandingTest
{
    private Handler handler = new Handler();
    int x = 5;
    int y = 10;
    Graphics g;
    private HUD hud;
    
    Player p = new Player(x, y, ID.Player, handler);
    Tank t = new Tank(x, y, ID.Tank, 10f, hud, handler);
    SmartTank st = new SmartTank(x, y, ID.Tank, 10f, hud, handler);
    EnemyPlayer ep = new EnemyPlayer(x, y, ID.EnemyPlayer, handler);
    SmartEnemyPlayer sep = new SmartEnemyPlayer(x, y, ID.EnemyPlayer, handler);
    
    

    public void init() {
        handler.addObject( p );
        handler.addObject( t );
        handler.addObject( st );
        handler.addObject( ep );
        handler.addObject( sep );
        
    }
    
    @Test
    public void playerConstructor()
    {
        
        assertEquals(p.getID(), ID.Player);
    }
    
    @Test
    public void playerTick() {
        init();
        p.tick();
        //p.tick();
        //System.out.println( p.tickUpdate );
        assertTrue(handler.containsObject( ID.Player ));
        assertEquals(p.getX(), x);
    }
    
    @Test
    public void playerFire() {
        init();
        p.fire();
        assertTrue(handler.containsObject( ID.Bomb ));
    }
    
    @Test
    public void playerGetBounds() {
        assertNotNull(p.getBounds());
    }
    
    
    @Test
    public void tankConstructor()
    {
        
        assertEquals(t.getID(), ID.Tank);
    }
    
    @Test
    public void tankTick() {
        init();
        t.tick();
        //p.tick();
        //System.out.println( p.tickUpdate );
        assertTrue(handler.containsObject( ID.Tank ));
        assertEquals(p.getX(), x);
    }
    
    @Test
    public void tankGetBounds() {
        assertNotNull(t.getBounds());
    }
    
    @Test
    public void superTankConstructor() {
        assertEquals(st.getID(), ID.Tank);
    }
    
    @Test
    public void superTankTick() {
        init();
        st.tick();
        assertTrue(handler.containsObject( ID.Tank ));
        assertEquals(st.getX(), 10);
    }
    
    @Test
    public void superTankGetBounds() {
        assertNotNull(st.getBounds());
    }
    
    
    @Test
    public void gameObjectSet() {
        p.setX( 10 );
        t.setX( 10 );
        p.setY( 5 );
        t.setY( 5 );
        p.setVelX( 20 );
        t.setVelX( 20 );
        p.setVelY( 40 );
        t.setVelY( 40 );
        
        assertEquals(p.getX(), 10);
        assertEquals(t.getX(), 10);
        assertEquals(p.getY(), 5);
        assertEquals(t.getY(), 5);
        assertEquals(p.getVelX(), 20);
        assertEquals(t.getVelX(), 20);
        assertEquals(p.getVelY(), 40);
        assertEquals(t.getVelY(), 40);
    }
    
    @Test
    public void gameObjectGet() {
        init();
        p.setVelX( 20 );
        p.setVelY( 20 );
        assertEquals(p.getX(), 5);
        assertEquals(p.getY(), 10);
        assertEquals(p.getVelX(), 20);
        assertEquals(p.getVelY(), 20);
    }
    
    @Test
    public void enemyPlayerConstructor() {
        assertEquals(ep.getID(), ID.EnemyPlayer);
    }
    
    @Test
    public void enemyPlayerTick() {
        init();
        ep.tick();
        assertTrue(handler.containsObject( ID.EnemyPlayer ));
        // can't do getX() b/c velX & velY are random ints
    }
    
    @Test
    public void enemyPlayerGetBounds() {
        assertNotNull(ep.getBounds());
    }
    
    @Test
    public void smartEnemyPlayerConstructor() {
        assertEquals(sep.getID(), ID.EnemyPlayer);
    }
    
    @Test
    public void smartEnemyPlayerTick() {
        init();
        ep.tick();
        assertTrue(handler.containsObject( ID.EnemyPlayer ));
        //assertEquals(sep.getX(), 10);
    }
    
    @Test
    public void smartEnemyPlayerGetBounds() {
        assertNotNull(sep.getBounds());
    }
    


}
