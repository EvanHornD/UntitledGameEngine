package Modules.Components;
import java.awt.Color;
import java.awt.Graphics2D;

import Modules.gameGraphics.RenderableEntity;

public class ShapeEntity extends RenderableEntity {
    public Color defaultColor = new Color(31,31,31);
    private String shape;
    private int[] coordinates;
    private int[] dimensions;
    private Color color;

    public ShapeEntity(String shape, int[] dimensions, int layer) {
        super(layer,1);
        this.shape = shape;
        this.coordinates = new int[]{0, 0};
        this.dimensions = dimensions;
        this.color = defaultColor;
    }

    public ShapeEntity(String shape, int[] coordinates, int[] dimensions, int layer) {
        super(layer,1);
        this.shape = shape;
        this.coordinates = coordinates;
        this.dimensions = dimensions;
        this.color = defaultColor;
    }

    public ShapeEntity(String shape, int[] coordinates, int[] dimensions) {
        super(0,0);
        this.shape = shape;
        this.coordinates = coordinates;
        this.dimensions = dimensions;
        this.color = defaultColor;
    }

    public String getShape() {
        return shape;
    }

    public int[] getCoords() {
        return coordinates;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(color);
        switch (shape) {
            case "Rectangle":
                g2d.fillRect(coordinates[0], coordinates[1], dimensions[0], dimensions[1]);
                break;
            default:
                break;
        }
    }
}

