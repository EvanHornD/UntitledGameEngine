package Modules.Components;

import java.awt.Graphics2D;
import java.awt.Image;

import Modules.gameGraphics.RenderableEntity;

public class SpriteEntity extends RenderableEntity {
    private Image image;
    private int[] coordinates;

    public SpriteEntity(Image image, int layer) {
        super(layer,2);
        this.image = image;
        this.coordinates = new int[]{0, 0};
    }

    public Image getImage() {
        return image;
    }

    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public void render(Graphics2D g2d){
    }
}