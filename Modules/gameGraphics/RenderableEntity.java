package Modules.gameGraphics;
import java.awt.Graphics2D;

public abstract class RenderableEntity implements Renderable {
    private int layer;
    private int layerPriority;

    public RenderableEntity(int layer, int layerPriority) {
        this.layer = layer;
        this.layerPriority = layerPriority;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public int getLayerPriority(){
        return layerPriority;
    }

    @Override
    public abstract void render(Graphics2D g2d);
}
