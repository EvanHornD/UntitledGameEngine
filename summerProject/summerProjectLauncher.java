package summerProject;

import javax.swing.*;

public class summerProjectLauncher{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                Frame game = new Frame();
                game.panel.runGameLoop();
            }
        });
    }
}