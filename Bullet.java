package LastPlaneStanding;

public class Bullet extends Projectile
{
    public int damage = 25;
    private int x;
    private int y;
    private boolean intact;

    public Bullet( int x, int y )
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