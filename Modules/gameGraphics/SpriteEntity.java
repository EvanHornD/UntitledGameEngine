package Modules.gameGraphics;

import java.awt.Image;

public class SpriteEntity {
    private Image image;
    private int[] coordinates;

    public SpriteEntity(Image image) {
        this.image = image;
        this.coordinates = new int[]{0, 0};
    }

    public Image getImage() {
        return image;
    }

    public int[] getCoords() {
        return coordinates;
    }
}