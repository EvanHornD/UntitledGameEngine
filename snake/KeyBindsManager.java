package snake;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class KeyBindsManager {
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

    private final InputMap inputMap;
    private final ActionMap actionMap;

    public KeyBindsManager(JComponent component) {
        this.inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        this.actionMap = component.getActionMap();
        setDefaultKeyBindings();
    }

    public void setDefaultKeyBindings() {
        for (Map.Entry<String, Integer> entry : keyActions.entrySet()) {
            addNewAction(entry.getKey());
        }
        for (Map.Entry<String, String> entry : defaultKeyBindings.entrySet()) {
            addKeyBinding(entry.getKey(), entry.getValue());
        }
    }

    // Sets up actions for key press and key release
    public void addNewAction(String actionName) {
        AbstractAction keyPressed =
                new AbstractAction() {
                    String action = actionName;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (keyActions.get(action) == 0) {
                            keyActions.replace(action, 1);
                            System.out.println(action + " Pressed");
                        }
                    }
                };
        AbstractAction keyReleased =
                new AbstractAction() {
                    String action = actionName;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        keyActions.replace(action, 2);
                        System.out.println(action + " Released");
                        keyActions.replace(action, 0);
                    }
                };
        actionMap.put(actionName, keyPressed);
        actionMap.put(actionName + "Released", keyReleased);
    }

    public void addKeyBinding(String keyPressed, String action) {
        inputMap.put(KeyStroke.getKeyStroke(keyPressed), action);
        inputMap.put(KeyStroke.getKeyStroke("released " + keyPressed), action + "Released");
    }

    public void removeKeyBinding(String keyPressed) {
        inputMap.remove(KeyStroke.getKeyStroke(keyPressed));
    }

    public void changeKeyBinding(String oldKey, String newKey, String action) {
        removeKeyBinding(oldKey);
        addKeyBinding(newKey, action);
    }
}
