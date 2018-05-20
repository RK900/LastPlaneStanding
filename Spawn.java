package LastPlaneStanding;

public class Spawn
{
    private Handler handler;

    private HUD hud;

    private Tank tank;

    private int scoreKeep = 0;


    public Spawn( Handler handler, HUD hud, Tank tank )
    {
        this.handler = handler;
        this.hud = hud;
        this.tank = tank;
    }


    public void tick()
    {
        
    }
}
