package Modules;

import javax.swing.JFrame;
import java.awt.*;

public class gameWindow {
        
    private JFrame frame;
    game panel;

    public gameWindow() {
        initialize();
    }

    public static Dimension getScreenDimensions(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (screenSize);
    }

    public void initialize(){
        frame = new JFrame();
        this.frame.setTitle("Game");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenDimensions = getScreenDimensions();
        int width = (int)screenDimensions.getWidth();
        int height = (int)screenDimensions.getHeight()/2;

        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        this.frame.setVisible(true);

        panel = new game(screenDimensions);
        this.frame.add(panel);
    }
}
