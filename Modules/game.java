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

        int width = (int)dimensions.getWidth();
        int height = (int)dimensions.getHeight();
        int tileSize = 40;
        int[] centerOffSet = new int[]{width/2-tileSize/2,height/2-tileSize/2};
        int[] tileDimensions = new int[]{tileSize,tileSize};
        int[] gridDimensions =  new int[]{17,15};
        int[] gridCenter = new int[]{gridDimensions[0]/2,gridDimensions[1]/2};

        //create snake player 
        renderer.currentScene.addEntityToScene(new SnakePlayer(4, 0, centerOffSet, tileSize, 20,gridDimensions));

        //create grid
        for(int i=0;i<gridDimensions[0];i++){
            for (int j=0;j<gridDimensions[1];j++) {
                if((i*gridDimensions[0]+j)%2==1){
                    renderer.currentScene.addEntityToScene(new ShapeEntity("Rectangle", getCoordinates(new int[]{i,j}, centerOffSet, gridCenter, tileSize), tileDimensions, new Color(45,60,45), -1));
                }else{
                    renderer.currentScene.addEntityToScene(new ShapeEntity("Rectangle", getCoordinates(new int[]{i,j}, centerOffSet, gridCenter, tileSize), tileDimensions, new Color(60,75,60), -1));
                }
            }
        }
        
        //create gray background
        renderer.currentScene.addEntityToScene(new ShapeEntity("Rectangle", new int[]{width, height}, -2));

        //Draw SNAKE at top
        LabeledShapeEntity labeledShape = new LabeledShapeEntity(new ShapeEntity("Rectangle",new int[]{width/6,height/32}, new int[]{2*width/3, height/8},Color.BLACK, 1), "SNAKE", 80, 1);
        renderer.currentScene.addEntityToScene(labeledShape);
        
        renderer.currentScene.updateLayerSorting();
    }

    public  static int[] getCoordinates(int[] gridCoords, int[] centerOfBoard, int[] centerOfGrid, int tileSize){
        int absoluteX = centerOfBoard[0]-(centerOfGrid[0]*tileSize)+(tileSize*gridCoords[0]);
        int absoluteY = centerOfBoard[1]-(centerOfGrid[1]*tileSize)+(tileSize*gridCoords[1]);
        return new int[]{absoluteX,absoluteY};
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
