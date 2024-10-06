package Modules.gameGraphics;

import java.awt.Graphics2D;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;

/* types of rendering opperations
1. Background Elements
    Static Background (sky, distant mountains, grid)
    Parallax Background (layers of depth)

2. Terrain
    Tiles (with collision/animation)
    Platforms (non-tile-based, potentially sloped ground)
    Interactive Terrain (destructible, animated, etc.)

3. Environmental Objects
    Foliage (static or dynamic)
    Foreground Obstructions (trees, fences, etc.)
    Dynamic Background Objects (moving clouds, distant enemies, etc.)

4. Entities
    Player Entities (playable characters)
    NPC Entities (AI-driven)
    Item Entities (coins, keys, levers)
    Projectiles (arrows, bullets, spells)

5. Particles & Effects
    Particle Systems (dust, explosions)
    Weather Effects (rain, snow, fog)

6. User Interface
    HUD (health bars, ammo count, minimaps)
    UI Elements (menus, text boxes)
    Overlays (crosshairs, notifications)

7. Lighting & Shadows
    Dynamic Lights (torches, lamps)
    Shadows (dynamic or static)

8. Camera & Rendering Effects
    Camera Panning/Zoom
    Filters/Screen Effects (blur, color grading)
    Special Effects (screen shake, flashes)
 */

public class GraphicsRenderer {

    private JPanel panel;
    public Scene currentScene;

    public GraphicsRenderer(JPanel panel) {
        this.panel = panel;
        this.currentScene = new Scene();
    }

    public void changeScene(Scene scene){
        this.currentScene = scene;
    }

    public void draw(Graphics2D g2d) {
        drawText(currentScene.getText(),g2d);
        drawShapes(currentScene.getShapes(),g2d);
    }

    public void drawText(ArrayList<TextEntity> textEntities, Graphics2D g2d){
        for (TextEntity text : textEntities) {
            g2d.setFont(text.getFont());
            int[] coords = text.getCoords();
            String textString = text.getText();
            System.out.println(textString);
            g2d.drawString(textString, coords[0], coords[1]);
        }
    }

    public void drawShapes(ArrayList<ShapeEntity> shapeEntities, Graphics2D g2d){
        for (ShapeEntity shape : shapeEntities) {
            String shapeType = shape.getShape();
            Color color = shape.getColor();
            int[] coords = shape.getCoords();
            int[] dimensions = shape.getDimensions();
            g2d.setColor(color);
            switch (shapeType) {
                case "Rectangle":
                g2d.fillRect(coords[0],coords[1],dimensions[0],dimensions[1]);
                break;

                default:
                break;
            }
        }
    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(panel::repaint);
    }

}