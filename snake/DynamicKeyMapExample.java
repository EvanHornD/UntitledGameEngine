package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class DynamicKeyMapExample extends JPanel {


    Map<String, String> defaultKeyBindings = new HashMap<>(Map.of(
        "UP", "Up",
        "W", "Up",
        "DOWN", "Down",
        "S", "Down",
        "LEFT", "Left",
        "A", "Left",
        "RIGHT", "Right",
        "D", "Right"
    ));
    Map<String, Integer> keyActions = new HashMap<>(Map.of(
        "Up", 0,
        "Down", 0,
        "Left", 0,
        "Right", 0
    ));
    InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = this.getActionMap();

    public DynamicKeyMapExample() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(400, 400));
        setDefaultKeyBindings();
    }

    public void setDefaultKeyBindings(){
        for (Map.Entry<String, Integer> entry : keyActions.entrySet()) {
            addNewAction(entry.getKey());
        }
        for (Map.Entry<String, String> entry : defaultKeyBindings.entrySet()) {
            addKeyBinding(entry.getKey(),entry.getValue());
        }

    }

    // sets up an action and its 
    public void addNewAction(String actionName){
        AbstractAction keyPressed = 
        new AbstractAction() {
            String action = actionName;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(keyActions.get(action)==0){
                    keyActions.replace(action,1);
                    System.out.println(action+" Pressed");
                } 
            }
        };
        AbstractAction keyReleased = 
        new AbstractAction() {
            String action = actionName;
            @Override
            public void actionPerformed(ActionEvent e) {
                keyActions.replace(action,2);
                System.out.println(action+" Released");
                keyActions.replace(action,0);
            }
        };
        actionMap.put(actionName, keyPressed);
        actionMap.put(actionName+"Released", keyReleased);
    }

    public void addKeyBinding(String keyPressed,String action){
        inputMap.put(KeyStroke.getKeyStroke(keyPressed), action);
        inputMap.put(KeyStroke.getKeyStroke("released " + keyPressed),action+"Released");
    }

    public void removeKeyBinding(String keyPressed){
        inputMap.remove(KeyStroke.getKeyStroke(keyPressed));
    }

    public void changeKeyBinding(String oldKey,String newKey,String action){
        removeKeyBinding(oldKey);
        addKeyBinding(newKey, action);
    }

    // Main method to create the JFrame and run the example
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic Key Binding Example");
        DynamicKeyMapExample panel = new DynamicKeyMapExample();

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
