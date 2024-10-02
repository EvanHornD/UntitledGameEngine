package Modules.gameGraphics;

import java.awt.Graphics2D;
import javax.swing.*;

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

    public GraphicsRenderer(JPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g2d) {

    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(panel::repaint);
    }

}