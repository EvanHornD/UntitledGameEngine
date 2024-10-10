package Modules.Components;

import Modules.gameGraphics.RenderableEntity;

public abstract class UpdatableEntity extends RenderableEntity implements Updatable {
    public UpdatableEntity(int layer, int layerPriority) {
        super(layer, layerPriority);
    }

    @Override
    public abstract void update(int Frame);
}
