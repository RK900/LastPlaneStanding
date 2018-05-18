package LastPlaneStanding;

import java.awt.*;
import java.util.LinkedList;

/**
 *  Handler
 *  Handles all the actors in the game.
 *
 *  @author  rohankoodli
 *  @version May 18, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    /**
     * Updates all the objects
     */
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp = object.get(i);
            temp.tick();
        }
    }

    /**
     * Renders all GameObjects
     * @param g Graphics component
     */
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    /**
     * Adds GameObject
     * @param object Object to be added
     */
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    /**
     * Removes GameObject
     * @param object Object to be removed
     */
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    /**
     * Gets object 
     * @param object ID of Object to be retrieved
     * @return Object
     */
    public GameObject getObject(ID object) {
        for(GameObject i : this.object) {
            if(i.getID() == object)
                return i;
        }
        return null;
    }
    
    /**
     * Contains objects
     * @param object GameObject
     * @return true if contains, false if not
     */
    public boolean containsObject(ID object) {
        for(GameObject i : this.object) {
            if(i.getID() == object)
                return true;
        }
        return false;
    }
}
