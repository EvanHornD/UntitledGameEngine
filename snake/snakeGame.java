package snake;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

public class snakeGame extends JPanel {

    //#region   Class attributes
    String lastKeyPressed = "";
    gameTimer gameTimer;
    private KeyBindsManager keyBinds;
    //#endregion

    snakeGame(Dimension dimensions){
        this.setPreferredSize(dimensions);
        this.setFocusable(true);
        this.requestFocus();
        keyBinds = new KeyBindsManager(this);
        gameTimer = new gameTimer();
    }

    public void startGameTimer() {
        gameTimer.start(deltaTime -> {
            // Update game state
            runGameLoop(deltaTime);

            // Trigger the repaint
            triggerRepaint();
        });
    }

    public void runGameLoop(double delta){
        for (Map.Entry<String,Integer> keyBind : keyBinds.keyActions.entrySet()) {
            Integer state = keyBind.getValue();
            if(state>0){
                String action = keyBind.getKey();
                Integer framesPressed = keyBinds.keyFrames.get(action);
                switch (state) {
                    case 1:
                    if (framesPressed==0) {
                        System.out.println(action+" Pressed");
                    } else {
                        System.out.println(framesPressed);
                    }
                    break;
                    case 2:
                    System.out.println(action+" Released");
                    break;
                    default:
                        break;
                }
            }
        }
        keyBinds.updateFrameInformation();
    }

    public void paint(Graphics g){

    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(() -> repaint());
    }
}
