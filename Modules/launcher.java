package Modules;

import javax.swing.SwingUtilities;

public class launcher {
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gameWindow game = new gameWindow();
            game.panel.startGameTimer();
        });
    }
}
