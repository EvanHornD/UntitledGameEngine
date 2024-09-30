package snake;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class snakeGame extends JPanel {

    //#region   Class attributes
    int[] keyCodes = {};
    String lastKeyPressed = "";
    Timer gameTimer;
    private KeyBindsManager keyBinds;
    //#endregion

    snakeGame(Dimension dimensions){
        this.setPreferredSize(dimensions);
        this.setFocusable(true);
        this.requestFocus();
        keyBinds = new KeyBindsManager(this);
        runGameLoop();
    }

    public void runGameLoop(){
        int delay = 16; // roughly 60 FPS -> 1000ms / 60 = ~16ms
        gameTimer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Redraw the screen
                triggerRepaint();
            }
        });

        // Start the timer, effectively starting the game loop
        gameTimer.start();
    }

    public void paint(Graphics g){

    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(() -> repaint());
    }
    //#region   key Binding
    
    //endregion
}
