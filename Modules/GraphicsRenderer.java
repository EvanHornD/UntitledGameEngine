package Modules;

import java.awt.Graphics2D;
import javax.swing.*;

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
