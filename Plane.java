package LastPlaneStanding;

public class Plane extends Shooter
{
    private int health;
    private int x;
    private int y;
    private int cx;
    private int cy;
    public Plane( int health, int x, int y )
    {
        super(health, x, y);
        health = 10;
        cx = x;
        cy = y;
        
    }
    public void move()
    {
       
    }
    public int getX()
    {
        return cx;
    }
    public int getY()
    {
        return cy;
    }
    

}