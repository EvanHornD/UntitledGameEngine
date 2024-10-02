package Modules;

import java.awt.*;
import javax.swing.*;

public class game extends JPanel {

    //#region   Class attributes
    gameTimer gameTimer;
    KeyBindsManager keyBinds;
    GraphicsRenderer renderer;
    //#endregion

    game(Dimension dimensions){
        this.setPreferredSize(dimensions);
        this.setFocusable(true);
        this.requestFocus();
        keyBinds = new KeyBindsManager(this);
        gameTimer = new gameTimer();
        renderer = new GraphicsRenderer(this);
    }

    public void startGameTimer() {
        gameTimer.start(deltaTime -> {
            // Update game state
            runGameLoop(deltaTime);

            // Trigger the repaint
            renderer.triggerRepaint();
        });
    }

    public void runGameLoop(double delta){
        Object[][] Actions = keyBinds.getActionInformation();
        for (Object[] Action : Actions) {
            Integer state = (Integer)Action[1];
            if(state>0){
                String action = (String)Action[0];
                Integer framesPressed = (Integer)Action[2];
                switch (state) {
                    case 1 -> {
                        if (framesPressed==0) {
                            System.out.println(action+" Pressed");
                        } else {
                            System.out.println(framesPressed);
                        }
                    }
                    case 2 -> System.out.println(action+" Released");
                }
            }
        }
        keyBinds.updateFrameInformation();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        renderer.draw(g2d);
    }
}
