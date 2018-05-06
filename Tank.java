package LastPlaneStanding;

class Tank extends Shooter
{

    private int accuracy;
    private int speed;
    private boolean markedDead, isDead, toBeRemoved;
    private double width, height;
    private double x, y, vx, vy = 0;

    public Tank( int health, int x, int y, int accuracy, int speed) 
    {
         super(health);
         this.accuracy = accuracy;
         this.speed = speed;
         this.x = x;
         this.y = y;
    }
    
    public boolean fire()
    {
        
    }
    
    public void move()
    {
        if(isDead || markedDead){
            x -= Coordinator.SCREEN_SPEED;
            if(x<-width) toBeRemoved = true;
        }
        else {
            x += vx;
            if(x>=shooter.getX()) isDead = true;
        }
    }
    
    public int getX(){
        return x;
    }
        
    public boolean isHit(Bullet bullet)
    {
        int mx = bullet.getX();
        int my = bullet.getY();
        
        if( (mx>=x-width/2 && mx<=x+width/2 && my>=y && my<=y+height) ||
            (mx>=x-mx/2 && mx<=x+mx/2 && my>=y+height && my<=y+2*height) ||
            (mx>=x-width/2 && mx<=x+width/2 && my>=y+2*height && my<=y+3*height) ) return true;
        
        return false;
    }
        
    
}
