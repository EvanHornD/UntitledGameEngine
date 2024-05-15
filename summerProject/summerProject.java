package summerProject;

import java.awt.*;
import javax.swing.*;

public class summerProject extends JPanel {
    
    summerProject(Dimension dimensions){
        this.setPreferredSize(dimensions);
        this.setFocusable(true);
        this.requestFocus();
    }

    public void runGameLoop(){

    }

    public void paint(Graphics g){

    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(() -> repaint());
    }
}
