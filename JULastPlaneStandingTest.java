package LastPlaneStanding;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

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
    private HUD hud = new HUD();
    
    Player p = new Player(x, y, ID.Player, handler);
    Tank t = new Tank(x, y, ID.Tank, 10f, hud, handler);
    SmartTank st = new SmartTank(x, y, ID.Tank, 10f, hud, handler);
    SuperTank su = new SuperTank(x, y, ID.Tank, 10f, hud, handler);
    EnemyPlayer ep = new EnemyPlayer(x, y, ID.EnemyPlayer, handler);
    SmartEnemyPlayer sep = new SmartEnemyPlayer(x, y, ID.EnemyPlayer, handler);
    Trail tr = new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0f, handler);
    Bomb b = new Bomb(x, y, ID.Bomb, handler);
    Bullet bt = new Bullet(x, y, ID.Bullet, 0f, handler);
    Projectile pr = new Projectile(x, y, ID.Projectile);
    Shooter s = new Shooter(x, y, ID.Shooter, handler);
    YouWin yw = new YouWin(x, y, ID.YouWin, "Win");
    
    

    /**
     * Initializes handler
     */
    public void init() {
        handler.addObject( p );
        handler.addObject( t );
        handler.addObject( st );
        handler.addObject( ep );
        handler.addObject( sep );
        handler.addObject( tr );
        handler.addObject( b );
        handler.addObject( bt );
        handler.addObject( pr );
        handler.addObject( s );
        
    }
    
    
    /**
     * Tests player constructor
     */
    @Test
    public void playerConstructor()
    {
        
        assertEquals(p.getID(), ID.Player);
    }
    
    /**
     * Tests player tick/update method
     */
    @Test
    public void playerTick() {
        init();
        p.tick();
        //p.tick();
        //System.out.println( p.tickUpdate );
        assertTrue(handler.containsObject( ID.Player ));
        assertEquals(p.getX(), x);
    }
    
    /**
     * Tests player fire
     */
    @Test
    public void playerFire() {
        init();
        p.fire();
        assertTrue(handler.containsObject( ID.Bomb ));
    }
    
    /**
     * Tests player get bounds
     */
    @Test
    public void playerGetBounds() {
        assertNotNull(p.getBounds());
    }
    
  
    /**
     * Tests tank constructor
     */
    @Test
    public void tankConstructor()
    {
        
        assertEquals(t.getID(), ID.Tank);
    }
    
    /**
     * Tests tank tick/update method
     */
    @Test
    public void tankTick() {
        init();
        t.tick();
        //p.tick();
        //System.out.println( p.tickUpdate );
        assertTrue(handler.containsObject( ID.Tank ));
        assertEquals(p.getX(), x);
    }
    
    /**
     * Tests tank get bounds
     */
    @Test
    public void tankGetBounds() {
        assertNotNull(t.getBounds());
    }
    
    /**
     * Tests smarttank constructor
     */
    @Test
    public void smartTankConstructor() {
        assertEquals(st.getID(), ID.Tank);
    }
    
    /**
     * Tests smarttank tick/update method
     */
    @Test
    public void smartTankTick() {
        //init();
        handler.addObject( st );
        st.tick();
        assertTrue(handler.containsObject( ID.Tank ));
        assertEquals(st.getX(), 10);
    }
    
    /**
     * Tests smarttank get bounds
     */
    @Test
    public void smartTankGetBounds() {
        assertNotNull(st.getBounds());
    }
    
    /**
     * Tests supertank constructor
     */
    @Test
    public void superTankConstructor() {
        assertEquals(su.getID(), ID.Tank);
    }
    
    /**
     * Tests Supertank tick/update method
     */
    @Test
    public void superTankTick() {
        //init();
        handler.addObject( su );
        su.tick();
        assertTrue(handler.containsObject( ID.Tank ));
        assertEquals(su.getX(), 10);
    }
    
    /**
     * Tests supertank get bounds
     */
    @Test
    public void superTankGetBounds() {
        assertNotNull(su.getBounds());
    }
    
    
    /**
     * Tests GameObject set
     */
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
    
    /**
     * Tests GameObject get
     */
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
    
    /**
     * Tests EnemyPlayer constructor
     */
    @Test
    public void enemyPlayerConstructor() {
        assertEquals(ep.getID(), ID.EnemyPlayer);
    }
    
    /**
     * Tests EnemyPlayer tick/update method
     */
    @Test
    public void enemyPlayerTick() {
        init();
        ep.tick();
        assertTrue(handler.containsObject( ID.EnemyPlayer ));
        // can't do getX() b/c velX & velY are random ints
    }
    
    /**
     * Tests enemyplayer get bounds
     */
    @Test
    public void enemyPlayerGetBounds() {
        assertNotNull(ep.getBounds());
    }
    
    /**
     * Tests SmartEnemyPlayer constructor
     */
    @Test
    public void smartEnemyPlayerConstructor() {
        assertEquals(sep.getID(), ID.EnemyPlayer);
    }
    
    /**
     * Tests SmartEnemyPlayer tick/update method
     */
    @Test
    public void smartEnemyPlayerTick() {
        init();
        ep.tick();
        assertTrue(handler.containsObject( ID.EnemyPlayer ));
        //assertEquals(sep.getX(), 10);
    }
    
    /**
     * Tests smartenemyplayer get bounds
     */
    @Test
    public void smartEnemyPlayerGetBounds() {
        assertNotNull(sep.getBounds());
    }
    
    /**
     * Tests hud tick/update method
     */
    @Test
    public void hudTick() {
        assertNotNull(hud.HEALTH);
    }

    /**
     * Tests HUD update level
     */
    @Test
    public void hudLevel() {
        hud.setLevel( 10 );
        assertEquals(hud.getLevel(),10);
    }
    
    /**
     * Tests HUD update score
     */
    @Test
    public void hudScore() {
        hud.setScore( 10 );
        assertEquals(hud.getScore(),10);
    }
    
    /**
     * Tests trail constructor
     */
    @Test
    public void trailConstructor() {
        assertEquals(tr.getID(), ID.Trail);
    }
    
    /**
     * Tests trail tick/update method
     */
    @Test
    public void trailTick() {
        init();
        tr.tick();
        assertTrue(handler.containsObject( ID.Trail ));
        //assertEquals(sep.getX(), 10);
    }
    
    /**
     * Tests trail get bounds
     */
    @Test
    public void trailGetBounds() {
        assertNotNull(tr.getBounds());
    }
    
    /**
     * Tests bomb constructor
     */
    @Test
    public void bombConstructor() {
        assertEquals(b.getID(), ID.Bomb);
    }
    
    /**
     * Tests bomb tick/update method
     */
    @Test
    public void bombTick() {
        init();
        b.setVelY( -20 );
        b.tick();
        assertTrue(handler.containsObject( ID.Bomb ));
        assertEquals(b.getX(), x);
    }
    
    /**
     * Tests bomb get bounds
     */
    @Test
    public void bombGetBounds() {
        assertNotNull(b.getBounds());
    }

    /**
     * Tests bullet constructor
     */
    @Test
    public void bulletConstructor() {
        assertEquals(bt.getID(), ID.Bullet);
    }
    
    /**
     * Tests bullet tick/update method
     */
    @Test
    public void bulletTick() {
        init();
        bt.tick();
        assertTrue(handler.containsObject( ID.Bullet ));
        assertEquals(bt.getX(), x);
    }
    
    /**
     * Tests bullet get bounds
     */
    @Test
    public void bulletGetBounds() {
        assertNotNull(bt.getBounds());
    }
    
    /**
     * Tests Projectile constructor
     */
    @Test
    public void projectileConstructor() {
        assertEquals(pr.getID(), ID.Projectile);
    }
    
    /**
     * Tests shooter constructor
     */
    @Test
    public void shooterConstructor() {
        assertEquals(s.getID(), ID.Shooter);
    }
    
    /**
     * Tests spawn constructor
     */
    @Test
    public void spawnConstructor() {
        assertNotNull(new Spawn(this.handler, this.hud, t));
    }
    
    /**
     * Tests handler tick/update method
     */
    @Test
    public void handlerTick() {
        //init();
        handler.addObject( bt );
        handler.tick();
        assertTrue(handler.containsObject( ID.Bullet ));
    }
    
    /**
     * Tests handler addObject
     */
    @Test
    public void handlerAddObject() {
        //init();
        handler.addObject( bt );
        assertTrue(handler.containsObject( ID.Bullet ));
    }
    
    /**
     * Tests handler removeObject
     */
    @Test
    public void handlerRemoveObject() {
        //init();
        handler.addObject( bt );
        handler.removeObject( bt );
        assertTrue(!handler.containsObject( ID.Bullet ));
    }
    
    /**
     * Tests handler getObject
     */
    @Test
    public void handlerGetObject() {
        //init();
        handler.addObject( bt );
        GameObject x = handler.getObject( ID.Bullet );
        assertEquals(x.getID(), ID.Bullet);
    }
    
    /**
     * Tests handler containsObject
     */
    @Test
    public void handlerContainsObject() {
        //init();
        handler.addObject( bt );
        assertTrue(handler.containsObject( ID.Bullet ));
    }
    
    /**
     * Tests YouWin constructor
     */
    @Test
    public void youWinConstructor() {
        //init();
        handler.addObject( yw );
        assertTrue(handler.containsObject( ID.YouWin ));
    }
    
    /**
     * Tests youWin get bounds
     */
    @Test
    public void youWinGetBounds() {
        //init();
        handler.addObject( yw );
        assertNull(yw.getBounds());
    }
    
    

}
