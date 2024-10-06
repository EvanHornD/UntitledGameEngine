package Modules.gameGraphics;

import java.awt.Font;
import java.awt.Graphics2D;

public class TextEntity extends RenderableEntity {
    private String text;
    private Font font;
    private int[] coordinates;

    public TextEntity(String text, int layer) {
        super(layer,3);
        this.text = text;
        this.font = new Font("Arial", 0, 20);
        this.coordinates = new int[]{100, 100};
    }

    public TextEntity(String text,int[] coordinates, int layer) {
        super(layer,3);
        this.text = text;
        this.font = new Font("Arial", 0, 20);
        this.coordinates = coordinates;
    }

    public TextEntity(String text,int[] coordinates) {
        super(0,0);
        this.text = text;
        this.font = new Font("Arial", 0, 20);
        this.coordinates = coordinates;
    }


    public String getText() {
        return text;
    }

    public Font getFont() {
        return font;
    }

    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setFont(font);
        g2d.drawString(text, coordinates[0], coordinates[1]);
    }
}

