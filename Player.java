package LastPlaneStanding;

import java.awt.*;

public class Player extends GameObject {

    private int width, height;
    public Player(int x, int y, ID id) {
        super(x, y, id);
        width = 30;
        height = 30;
        
    }

    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp( x, 0, Game.WIDTH - width );
        y = Game.clamp( y, 0, Game.HEIGHT - height * 2 );
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    @Override
    public Rectangle getBounds()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
