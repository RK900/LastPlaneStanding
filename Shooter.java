package LastPlaneStanding;

public class Shooter
{
    public int health; // 0 to 10

    public int x, y, cx, cy, width, height;


    public Shooter( int health, int x, int y )
    {
        this.health = health;
        this.x = x;
        this.y = y;
        cx = x;
        cy = y;
        width = 20;
        height = 20;
    }


    public void collide( Projectile p )
    {
        if ( Math.abs( p.cx - cx ) < width / 2 && Math.abs( p.cy - cy ) < height / 2 )
        {
            health -= p.damage;
        }
    }
}