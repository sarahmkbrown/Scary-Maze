package scarymaze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ScaryMaze extends JComponent
{

    private Color WALL = Color.BLACK;
    private Color MAZE = Color.GREEN;
    private Color FINISH = Color.BLUE;
    private int LEVEL = 2;
    private Image screamImage;

    public static void main(String[] args)
    {
        JFrame scaryMazeWindow = new JFrame("Maze");
        scaryMazeWindow.setVisible(true);
        scaryMazeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scaryMazeWindow.add(new ScaryMaze());
        scaryMazeWindow.pack();
        scaryMazeWindow.setLocationRelativeTo(null);
    }

    public ScaryMaze()
    {
        try
        {
            URL screamImageUrl = getClass().getResource("scream.jpg");
            screamImage = ImageIO.read(screamImageUrl);
        } catch (IOException ex)
        {
            Logger.getLogger(ScaryMaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(400, 600);
    }

    @Override
    protected void paintComponent(Graphics grphcs)
    {
        super.paintComponent(grphcs);

        grphcs.setColor(WALL);
        grphcs.fillRect(0, 0, 400, 600);

        if (LEVEL == 1)
        {
            // Maze #1
            grphcs.setColor(MAZE);
            grphcs.fillRect(25, 400, 75, 100);
            grphcs.fillRect(100, 50, 100, 450);
            grphcs.fillRect(200, 50, 150, 100);
            grphcs.setColor(FINISH);
            grphcs.fillRect(350, 50, 25, 100);
        } else
        {

            // Maze #2
            grphcs.setColor(MAZE);
            grphcs.fillOval(25, 100, 800, 800);
            grphcs.setColor(WALL);
            grphcs.fillOval(100, 200, 275 * 2, 275 * 2);
            grphcs.fillRect(25, 500, 800, 100);
            grphcs.fillRect(375, 102, 25, 101);
            grphcs.setColor(FINISH);
            grphcs.fillRect(350, 103, 25, 100);
        }


        // Losing image
        // grphcs.drawImage(screamImage, 0, 0, 400, 600, null);
    }
}
