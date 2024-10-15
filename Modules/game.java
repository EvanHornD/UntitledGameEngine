package Modules;

import Modules.Components.*;
import Modules.gameGraphics.*;
import Modules.userInput.KeyBindsManager;
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
        renderer.currentScene.addEntityToScene(new SnakePlayer(4, 0, new int[]{(int)dimensions.getWidth()/2,(int)dimensions.getHeight()/2}, 25, 30, new int[]{15,17}));
        
        renderer.currentScene.addEntityToScene(new SpriteEntity(null, 1));
        renderer.currentScene.addEntityToScene(new ShapeEntity("Rectangle", new int[]{(int)dimensions.getWidth(), (int)dimensions.getHeight()}, 0));
        renderer.currentScene.addEntityToScene(new TextEntity("Hello World!",new int[]{300,100}, 2,"Left"));
        LabeledShapeEntity labeledShape = new LabeledShapeEntity(new ShapeEntity("Rectangle",new int[]{100,300}, new int[]{200, 100},Color.GRAY, 1), "SNAKE", 1);
        //renderer.currentScene.addEntityToScene(new Player(3, Color.GREEN, "Rectangle", new int[]{(int)dimensions.getWidth()/2, (int)dimensions.getHeight()/2}, new int[]{100,100}));
        renderer.currentScene.addEntityToScene(labeledShape);
        
        renderer.currentScene.updateLayerSorting();
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

        //updates all of the scenes entities making use of which keys are being pressed and for how long
        renderer.currentScene.updateEntities(keyBinds.getKeyActions(), keyBinds.getKeyFrames());

        Object[][] Actions = keyBinds.getInformation();
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
