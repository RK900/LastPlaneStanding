package LastPlaneStanding;

public class Tank extends Shooter
{

    private int accuracy; // 0 to 10
    private int speed; // 0 to 10

    public Tank(int health, int accuracy, int speed)
    {
        super(health);
        this.accuracy = accuracy;
        this.speed = speed;
    }
    
    public void fire()
    {
        
    }
}
