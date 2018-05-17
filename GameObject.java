package LastPlaneStanding;

import java.awt.*;

/**
 *  GameObject
 *  GameObject superclass from which all actors in the game are derived
 *
 *  @author  rohankoodli
 *  @version May 16, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi, David
 */
public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;
    protected boolean shoot = false;

    /**
     * @param x X position
     * @param y Y position
     * @param id actor ID
     */
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * Updates the GameObject
     */
    public abstract void tick();
    
    
    /**
     * Renders the object
     * @param g Graphics
     */
    public abstract void render(Graphics g);
    
    
    /**
     * Filler to draw actor
     * @return Rectangle object
     */
    public abstract Rectangle getBounds(); 

    /**
     * Set X location
     * @param x X location
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y location
     * @param y Y location
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get x location
     * @param y Y location
     */
    public int getX() {
        return x;
    }

    /**
     * Get y location
     * @param y Y location
     */
    public int getY() {
        return  y;
    }

    
    /**
     * Set ID of GameObject
     * @param id
     */
    public void setID(ID id) {
        this.id = id;
    }

    /**
     * Get ID of GameObject
     * @param id
     */
    public ID getID() {
        return this.id;
    }

    /**
     * Set x velocity
     * @param x X velocity
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * Set y velocity
     * @param y Y velocity
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * Get x velocity
     * @param x X velocity
     */
    public int getVelX() {
        return velX;
    }

    /**
     * Get y velocity
     * @param y Y velocity
     */
    public int getVelY() {
        return velY;
    }

}
