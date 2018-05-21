package LastPlaneStanding;

import javax.swing.*;
import java.awt.*;

/**
 *  Window class
 *  Creates a GUI to play the game
 *
 *  @author  rohankoodli
 *  @version May 21, 2018
 *  @author  Period: 2
 *  @author  Assignment: APCS2
 *
 *  @author  Sources: Rohan, Ravi, David
 */
public class Window extends Canvas {

    /**
     * 
     */
    private static final long serialVersionUID = 5721577297886125931L;

    /**
     * @param width Width of screen
     * @param height Height of screen
     * @param title Title of game
     * @param game Game
     */
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable( true );
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
