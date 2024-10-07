package Modules.gameGraphics;

import Modules.Components.UpdatableEntity;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Scene {
    private final TreeMap<Integer, List<Renderable>> layerMap = new TreeMap<>();
    private final ArrayList<UpdatableEntity> updatables = new ArrayList<>();
    private int CurrentFrame = 0;

    public void addEntityToScene(Renderable entity) {
        int layer = entity.getLayer();
        layerMap.putIfAbsent(layer, new ArrayList<>());
        layerMap.get(layer).add(entity);
    }

    public void updateEntities(){
        CurrentFrame++;
        for (UpdatableEntity updatable : updatables) {
            updatable.update(CurrentFrame);
        }
;
    }

    // Sort entities by layer 
    private void sortEntitiesInLayer(List<Renderable> entities) {
        entities.sort(Comparator.comparingInt(Renderable::getLayerPriority));
    }

    public void updateLayerSorting(){
        for (List<Renderable> layerEntities : layerMap.values()) {
            sortEntitiesInLayer(layerEntities);
        }
    }

    public void renderScene(Graphics2D g2d) {
        for (List<Renderable> layerEntities : layerMap.values()) {
            for (Renderable entity : layerEntities) {
                entity.render(g2d);
            }
        }
    }
}
