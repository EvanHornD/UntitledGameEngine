package Modules;

import Modules.Components.ControllableEntity;
import Modules.Components.ShapeEntity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class SnakePlayer extends ControllableEntity{
    
    static LinkedList<ShapeEntity> snake = new LinkedList<>();
    static LinkedList<int[]> snakeGridCoordinates = new LinkedList<>();
    static int[] headGridCoords;
    static String movementDirection = "";
    static String gameState = "Start";
    static ShapeEntity apple;
    static int[] appleCoordinates;
    static int[] centerOfBoard;
    static int[] centerOfGrid;
    static int[] boardDimensions;
    static int tileSize;
    static int framesPerMove;
    static int currentFrame = 0;

    public SnakePlayer(int layer, int layerPriority,int[] centerOfBoard, int tileSize, int framesPerMove, int[] boardDimensions) {
        super(layer, layerPriority);
        SnakePlayer.centerOfBoard = centerOfBoard;
        SnakePlayer.tileSize = tileSize;
        SnakePlayer.framesPerMove = framesPerMove;
        SnakePlayer.boardDimensions = boardDimensions;
        SnakePlayer.centerOfGrid = new int[]{boardDimensions[0]/2,boardDimensions[1]/2};
        snake.add(createShape(centerOfGrid, Color.GREEN));
        snakeGridCoordinates.add(centerOfGrid);
        headGridCoords = centerOfGrid;
        createApple();
    }

    private static void moveSnake(int[] coords){
        if(appleCoordinates[0]==coords[0]&&appleCoordinates[1]==coords[1]){
            snake.addLast(createShape(coords, Color.GREEN));
            snakeGridCoordinates.addLast(coords);
            headGridCoords = coords;
            createApple();
        } else {
            if(gameState!="Start"){
                snake.removeFirst();
                snakeGridCoordinates.removeFirst();
            }
            if (snakeCoordsContains(coords)||checkOutOfBounds(coords)) {
                gameState = "Lose";
                
            }else{
                snake.addLast(createShape(coords, Color.GREEN));
                headGridCoords = coords;
                snakeGridCoordinates.addLast(coords);
            }
        }

    }

    private static boolean checkOutOfBounds(int[] coords){
        boolean leftOfGrid = coords[0]<0;
        boolean aboveGrid = coords[1]<0;
        boolean rightOfGrid = coords[0]>=boardDimensions[0];
        boolean belowGrid = coords[1]>=boardDimensions[1];
        return leftOfGrid||aboveGrid||rightOfGrid||belowGrid;
    }

    private static void createApple(){
        if(snakeGridCoordinates.size()==(boardDimensions[0]*boardDimensions[1])){
            gameState = "Win";
        } else {
            Random appleGenerator = new Random();
            int[] newCoords = new int[]{appleGenerator.nextInt(boardDimensions[0]),appleGenerator.nextInt(boardDimensions[1])};
            while(snakeCoordsContains(newCoords)){

                newCoords = new int[]{appleGenerator.nextInt(boardDimensions[0]),appleGenerator.nextInt(boardDimensions[1])};
            }
            apple = createShape(newCoords, Color.RED);
            appleCoordinates = newCoords;
        }
    }

    private static boolean snakeCoordsContains(int[] coords){
        for (int[] segment : snakeGridCoordinates) {
            int X = segment[0];
            int Y = segment[1];
            if(X==coords[0]&&Y==coords[1]){
                return true;
            }
        }
        return false;
    }

    private static ShapeEntity createShape(int[] gridCoords, Color color){
        return new ShapeEntity("Rectangle", getAbsoluteCoordinates(gridCoords), new int[]{tileSize,tileSize},color);
    }

    private static int[] getAbsoluteCoordinates(int[] gridCoords){
        int absoluteX = centerOfBoard[0]-(centerOfGrid[0]*tileSize)+(tileSize*gridCoords[0]);
        int absoluteY = centerOfBoard[1]-(centerOfGrid[1]*tileSize)+(tileSize*gridCoords[1]);
        return new int[]{absoluteX,absoluteY};
    }

    private static void moveDirection(String dir){
        int x = headGridCoords[0];
        int y = headGridCoords[1];
        switch (dir) {
            case "Up": y--;break;
            case "Down": y++; break;
            case "Left": x--;break;
            case "Right": x++;break;
        }
        movementDirection = dir;
        moveSnake(new int[]{x,y});
        if(gameState.equals("Start")){
            gameState = "Playing";
        } else {
            currentFrame = 0;
        }
    } 

    @Override
    public void update(int Frame) {
        if(gameState.equals("Playing")){
            if(currentFrame == framesPerMove){
                moveDirection(movementDirection);
                currentFrame = 0;
            } else {
                currentFrame++;
            }
        }
    }

    @Override
    public void updateWithInput(int Frame, Map<String, Integer> keyActions, Map<String, Integer> keyFrames) {
        if(gameState.equals("End")){
            if (keyActions.get("Input") == 2) {
                gameState = "reset";
            }
        }else{
            if (!gameState.equals("Lose")&&!gameState.equals("Win")) {
                if (keyActions.get("Up") == 2) {
                    if(gameState.equals("Start")||movementDirection.equals("Left")||movementDirection.equals("Right")){
                        moveDirection("Up");
                    }
                }
                if (keyActions.get("Down") == 2) {
                    if(gameState.equals("Start")||movementDirection.equals("Left")||movementDirection.equals("Right")){
                        moveDirection("Down");
                    }
                }
                if (keyActions.get("Left") == 2) {
                    if(gameState.equals("Start")||movementDirection.equals("Up")||movementDirection.equals("Down")){
                        moveDirection("Left");
                    }
                }
                if (keyActions.get("Right") == 2) {
                    if(gameState.equals("Start")||movementDirection.equals("Up")||movementDirection.equals("Down")){
                        moveDirection("Right");
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        for (ShapeEntity shape : snake) {
            shape.render(g2d);   
        }
        apple.render(g2d);
    }
}
