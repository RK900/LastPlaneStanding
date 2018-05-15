package LastPlaneStanding;

import java.awt.*;
import java.util.Random;

public class EnemyPlayer extends GameObject {

    private Handler handler;
    private Random random;
    public EnemyPlayer(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.random = new Random();
        velX = random.nextInt(20) - 10;
        velY = -5;
    }

    public void tick() {
        x += velX;
        y += velY;
        if ( y <= 0 || y >= Game.HEIGHT - 12) {
            velY *= -1;
        }
        if ( x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }
//        handler.addObject( new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.1f, handler ) );
        handler.addObject( new Bullet(x, y, ID.Bullet, 0.1f, handler ) );
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 8, 8);
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
}
