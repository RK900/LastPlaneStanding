package LastPlaneStanding;

import static org.junit.Assert.*;

import java.awt.Graphics;

import org.junit.Test;

public class JULastPlaneStandingTest
{
    private Handler handler = new Handler();
    int x = 5;
    int y = 10;
    Graphics g;
    private HUD hud;
    
    Player p = new Player(x, y, ID.Player, handler);
    Tank t = new Tank(x, y, ID.Tank, 10f, hud, handler);
    

    public void init() {
        handler.addObject( p );
        handler.addObject( t );
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
    


}
