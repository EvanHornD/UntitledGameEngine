package Modules.gameGraphics;

import java.awt.Graphics2D;

public interface Renderable {
    void render(Graphics2D g2d);
    int getLayer();
    int getLayerPriority();
}
