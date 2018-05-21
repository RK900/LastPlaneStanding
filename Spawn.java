package LastPlaneStanding;

/**
 *  Spawn class
 *  Spawns objects for new levels
 *
 *  @author  Ravi
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi, David
 */
public class Spawn
{
    private Handler handler;

    private HUD hud;

    private Tank tank;

    private int scoreKeep = 0;


    /**
     * @param handler Handler
     * @param hud HUD
     * @param tank Tank to spawn
     */
    public Spawn( Handler handler, HUD hud, Tank tank )
    {
        this.handler = handler;
        this.hud = hud;
        this.tank = tank;
    }


    /**
     * Updates all new tanks
     */
    public void tick()
    {
        
    }
}
