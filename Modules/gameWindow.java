package Modules;

import javax.swing.JFrame;

public class gameWindow {
        
    private JFrame frame;
    game panel;

    public gameWindow() {
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        this.frame.setTitle("Snake Game");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(1935/2, 1050/2);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        this.frame.setVisible(true);

        panel = new game(null);
        this.frame.add(panel);
    }
}
