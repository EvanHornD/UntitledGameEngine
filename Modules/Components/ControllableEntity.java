package Modules.Components;

import java.util.Map;

public abstract class ControllableEntity extends UpdatableEntity {

    public ControllableEntity(int layer, int layerPriority) {
        super(layer, layerPriority);
    }

    // Update method that also takes in user input data (keyActions and keyFrames)
    public abstract void updateWithInput(int Frame, Map<String, Integer> keyActions, Map<String, Integer> keyFrames);
}
