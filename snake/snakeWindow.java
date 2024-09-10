package snake;

import javax.swing.JFrame;

public class snakeWindow {
        
    private JFrame frame;
    snakeGame panel;

    public snakeWindow() {
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        this.frame.setTitle("untitled Summer Project");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(1935, 1050);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        this.frame.setVisible(true);

        panel = new snakeGame(null);
        this.frame.add(panel);
    }
}
