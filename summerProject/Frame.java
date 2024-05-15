package summerProject;
import javax.swing.*;

public class Frame {
    
    private JFrame frame;
    summerProject panel;

    public Frame() {
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

        panel = new summerProject(null);
        this.frame.add(panel);
    }
}
