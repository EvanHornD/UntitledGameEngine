package snake;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class snakeGame extends JPanel implements KeyListener {

    //#region   Class attributes
    int[] keyCodes = {};
    String lastKeyPressed = "";
    //#endregion

    snakeGame(Dimension dimensions){
        this.setPreferredSize(dimensions);
        this.setFocusable(true);
        this.requestFocus();

        this.addKeyListener(this);
        keyCodes = createKeyCodesArray();
        System.out.println(Arrays.toString(keyCodes));
    }

    public void runGameLoop(){

    }

    public void paint(Graphics g){

    }

    public void triggerRepaint() {
        SwingUtilities.invokeLater(() -> repaint());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped = Invoked when a key is typed. Uses KeyChar, char output
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //keyReleased = called whenever a button is released
        if(lastKeyPressed.equals("")){
            for (int i : keyCodes) {
                if(i==e.getKeyCode()){
                    lastKeyPressed = java.awt.event.KeyEvent.getKeyText(e.getKeyCode());
                }
            }
        }
    }

    public int[] createKeyCodesArray(){
        int[] keyCodes = new int[29];
        for (int i = 0; i < keyCodes.length; i++) {
            if(i==0){keyCodes[i]=10;}
            else if(i==1){keyCodes[i]=27;}
            else if(i==2){keyCodes[i]=8;}
            else{keyCodes[i] = 62+i;}
        }
        return keyCodes;
    }
}
