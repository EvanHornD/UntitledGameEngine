package Modules;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Map;

import Modules.Components.ControllableEntity;
import Modules.Components.ShapeEntity;

public class Player extends ControllableEntity {

    private ShapeEntity shape;
    private int[] coordinates;

    public Player(int layer, Color color, String shape, int[] coordinates, int[] dimensions) {
        super(layer, 4);
        this.coordinates = coordinates;
        this.shape = new ShapeEntity(shape, coordinates, dimensions, color, layer);
    }

    @Override
    public void updateWithInput(int Frame, Map<String, Integer> keyActions, Map<String, Integer> keyFrames) {
            if (keyActions.get("Up") == 1) {
                coordinates[1] -= 5;  
            }
            if (keyActions.get("Down") == 1) {
                coordinates[1] += 5;  
            }
            if (keyActions.get("Left") == 1) {
                coordinates[0] -= 5;  
            }
            if (keyActions.get("Right") == 1) {
                coordinates[0] += 5;  
            }
    
            shape.setCoords(coordinates);
    }

    @Override // passive updates
    public void update(int Frame) {}

    @Override
    public void render(Graphics2D g2d) {
        shape.render(g2d);
    }

}
