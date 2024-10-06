package Modules.gameGraphics;

import java.awt.Font;

public class TextEntity {
    private String text;
    private Font font;
    private int[] coordinates;

    public TextEntity(String text) {
        this.text = text;
        this.font = new Font("Arial", 0, 20);
        this.coordinates = new int[]{100, 100};
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
}

