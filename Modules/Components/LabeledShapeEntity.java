package Modules.Components;

import java.awt.Graphics2D;

import Modules.gameGraphics.*;

public class LabeledShapeEntity extends RenderableEntity {

    private ShapeEntity shape;
    private TextEntity text;

    public LabeledShapeEntity(ShapeEntity shape, String text, int layer){
        super(layer,4);
        this.shape = shape;
        int[] coords = shape.getCoords();
        int[] dimensions = shape.getDimensions();
        this.text = new TextEntity(text,new int[]{coords[0],coords[1]-dimensions[1]});
    }

    @Override
    public void render(Graphics2D g2d){
        shape.render(g2d);
        text.render(g2d);
    }
}
