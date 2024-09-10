package snake;

import javax.swing.SwingUtilities;

public class snakeLauncher {
        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                snakeWindow game = new snakeWindow();
                game.panel.runGameLoop();
            }
        });
    }
}
