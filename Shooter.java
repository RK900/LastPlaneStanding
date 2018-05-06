package LastPlaneStanding;

public class Shooter
{
    public int health; // 0 to 100
    public int x, y;

    public Shooter() {
        health = 5;
        x = 5;
        y = 5;
    }

    public Shooter(int health, int x, int y)
    {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void shoot( Projectile p )
    {
        
    }
    public void collide( Projectile p)
    {
        
    }
}