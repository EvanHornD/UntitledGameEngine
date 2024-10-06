package Modules.gameGraphics;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Scene {
    private TreeMap<Integer, List<Renderable>> layerMap = new TreeMap<>();

    public void addEntityToScene(Renderable entity) {
        int layer = entity.getLayer();
        layerMap.putIfAbsent(layer, new ArrayList<>());
        layerMap.get(layer).add(entity);
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
