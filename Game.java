package LastPlaneStanding;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;


public class Game extends Canvas implements Runnable
{

    
    private static final long serialVersionUID = -8843410072345543792L;

    public static final int WIDTH = 640;

    public static final int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;

    private boolean running = false;

    private Handler handler;

    private HUD hud;

    private Spawn spawn;
    
    private Tank tank;
    
    private int a = 500;

    
    /**
     * Game Constructor
     */
    public Game()
    {
        handler = new Handler();
        this.addKeyListener( new KeyInput( handler ) );
        new Window( WIDTH, HEIGHT, "Last Plane Standing", this );
        hud = new HUD();
        tank = new Tank(WIDTH / 2 - 64, HEIGHT - 64, ID.Tank, 12.5f, hud, handler); //Tank
        
        handler.addObject( new Player( WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler ) ); //Plane

        //handler.addObject( new EnemyPlayer( WIDTH / 2 - 32, HEIGHT - 32, ID.EnemyPlayer, handler ) ); //Bullet
        //handler.addObject(tank);
        
        handler.addObject(new Tank((new Random().nextInt(WIDTH) + 400) / 2 - 200, HEIGHT - 64, ID.Tank, 12.5f, hud, handler));
        handler.addObject(new SmartTank((new Random().nextInt(WIDTH) + 400) / 2 - 200, HEIGHT - 64, ID.Tank, 12.5f, hud, handler));
        //handler.addObject(new EnemyPlane(WIDTH - 32, HEIGHT/2 - 32, ID.EnemyPlane, 12.5f, hud, handler));
//        handler.addObject(new Tank((new Random().nextInt(WIDTH) + 400) / 2 - 200, HEIGHT - 64, ID.Tank, 12.5f, hud, handler));
//        handler.addObject(new Tank((new Random().nextInt(WIDTH) + 400) / 2 - 200, HEIGHT - 64, ID.Tank, 12.5f, hud, handler));
//        handler.addObject(new Tank((new Random().nextInt(WIDTH) + 400) / 2 - 200, HEIGHT - 64, ID.Tank, 12.5f, hud, handler));



        
    }


    /**
     * Starts game thread
     */
    public synchronized void start()
    {
        thread = new Thread( this );
        thread.start();
        running = true;
    }


    /**
     * Stops game thread
     */
    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


    /** 
     * Runs game
     */
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while ( running )
        {
            long now = System.nanoTime();
            delta += ( now - lastTime ) / ns;
            lastTime = now;
            while ( delta >= 1 )
            {
                tick();
                delta--;
            }
            if ( running )
            {
                render();
            }
            frames++;
            if ( System.currentTimeMillis() - timer > 1000 )
            {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }


    /**
     * Updates all objects in handler and HUD
     */
    private void tick()
    {
        try
        {
            Thread.sleep( a );
        }
        catch ( InterruptedException e1 )
        {
            e1.printStackTrace();
        }
        a = 0;
        handler.tick();
        hud.tick();
        if(HUD.HEALTH <= 0) {
            
            System.out.println( "Game Over" );
            handler.removeObject( handler.getObject( ID.Player ) );
            stop();
        }
        else if(!handler.containsObject( ID.Tank ) && !handler.containsObject( ID.SmartTank ) && handler.containsObject( ID.Player ) && HUD.HEALTH > 0) {
            System.out.println( "You win" );
            handler.addObject(new YouWin(WIDTH/2, HEIGHT/2, ID.YouWin));
            try {
                TimeUnit.SECONDS.sleep( 1 );
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            stop();
        }
    }
    public boolean waitOneSec()
    {
        try
        {
            Thread.sleep( 1000 );
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * Renders all objects
     */
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if ( bs == null )
        {
            this.createBufferStrategy( 3 );
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor( Color.black );
        g.fillRect( 0, 0, WIDTH, HEIGHT );
        handler.render( g );
        hud.render( g );
        g.dispose();
        bs.show();
    }


    /**
     * All objects bounce off edges
     * @param var Location
     * @param min Minimum location
     * @param max Maximum location
     * @return Location
     */
    public static int clamp( int var, int min, int max )
    {
        if ( var >= max )
        {
            return var = max;
        }
        else if ( var <= min )
        {
            return var = min;
        }
        else
        {
            return var;
        }
    }


    /**
     * Main
     * @param args not used
     */
    public static void main( String[] args )
    {
        new Game();
    }
}
