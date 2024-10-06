package Modules.gameGraphics;
import java.awt.Color;

public class ShapeEntity {
    public Color defaultColor = new Color(31,31,31);

    private String shape;
    private int[] coordinates;
    private int[] dimensions;
    private Color color;

    public ShapeEntity(String shape) {
        this.shape = shape;
        this.coordinates = new int[]{0, 0};
        this.dimensions = new int[]{100,100};
        this.color = defaultColor;
    }

    public ShapeEntity(String shape,int[] dimensions) {
        this.shape = shape;
        this.coordinates = new int[]{0, 0};
        this.dimensions = dimensions;
        this.color = defaultColor;
    }

    public ShapeEntity(String shape,int[] dimensions, int[] coordinates, Color color) {
        this.shape = shape;
        this.coordinates = coordinates;
        this.dimensions = dimensions;
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public int[] getCoords() {
        return coordinates;
    }

    public int[] getDimensions(){
        return dimensions;
    }

    public Color getColor(){
        return color;
    }
}

