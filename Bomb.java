package LastPlaneStanding;

public class Bomb extends Projectile
{
    private int damage = 100;
    private int x;
    private int y;
    private boolean intact;

    public Bomb( int x, int y )
    {
        super( x, y );
        this.x = x;
        this.y = y;
        super.damage = this.damage;
        intact = true;
        
    }
    public void move()
    {
        
    }
    public void collide() 
    {
        
    }

}