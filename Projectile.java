package LastPlaneStanding;

public class Projectile
{
    public int damage;
    public int x, y, cx, cy, width, height;

    public boolean intact;


    public Projectile( int x, int y )
    {
        this.x = x;
        this.y = y;
        damage = 10;
        width = 10;
        height = 10;
        intact = true;
    }

}