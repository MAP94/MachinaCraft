package me.lyneira.MachinaFactoryCore;

import java.util.ArrayList;
import java.util.List;

import me.lyneira.MachinaCore.BlockLocation;

import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * A potential target node in a pipeline.
 * @author Lyneira
 *
 */
class TargetNode extends PipelineNode {
    /**
     * Constructs a new TargetNode for the given location, with the given previous node.
     * @param previous
     * @param location
     * @param type
     */
    TargetNode(PipelineNode previous, BlockLocation location, Material type) {
        super(previous, location, type);
    }

    @Override
    PipelineEndpoint target(Player player) {
        switch (type) {
        case AIR:
            return null;
        case CHEST:
        case DISPENSER:
            return new ContainerEndpoint(location);
        }
        return MachinaFactoryCore.plugin.detectEndpoint(player, location);
    }

    /**
     * A targetnode has no potential neighbors.
     */
    @Override
    List<PipelineNode> neighbors(Material material) {
        return new ArrayList<PipelineNode>(0);
    }
}