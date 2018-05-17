package LastPlaneStanding;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp = object.get(i);
            temp.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    public GameObject getObject(ID object) {
        for(GameObject i : this.object) {
            if(i.getID() == object)
                return i;
        }
        return null;
    }
    
    public boolean containsObject(ID object) {
        for(GameObject i : this.object) {
            if(i.getID() == object)
                return true;
        }
        return false;
    }
}
