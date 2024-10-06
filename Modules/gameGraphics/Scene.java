package Modules.gameGraphics;

import java.util.ArrayList;

public class Scene {
    private ArrayList<SpriteEntity> Sprites = new ArrayList<SpriteEntity>();
    private ArrayList<TextEntity> Text = new ArrayList<TextEntity>();
    private ArrayList<ShapeEntity> Shapes = new ArrayList<ShapeEntity>();

    public void addSpriteToScene(SpriteEntity sprite){
        Sprites.add(sprite);
    }

    public void addTextToScene(TextEntity text){
        Text.add(text);
    }

    public void addShapeToScene(ShapeEntity shape){
        Shapes.add(shape);
    }

    public ArrayList<ShapeEntity> getShapes(){
        return Shapes;
    }

    public ArrayList<SpriteEntity> getSprites(){
        return Sprites;
    }

    public ArrayList<TextEntity> getText(){
        return Text;
    }
}
