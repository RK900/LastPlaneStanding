package LastPlaneStanding;
import java.awt.*;

public class Game extends Canvas implements Runnable{

    /**
     * 
     */
    private static final long serialVersionUID = -8843410072345543792L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "Last Plane Standing", this);
    }

    public synchronized void start() {

    }

    public void run() {

    }

    public static void main (String[] args)
    {
        new Game();
    }
}
