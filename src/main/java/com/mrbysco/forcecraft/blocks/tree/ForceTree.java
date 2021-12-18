package com.mrbysco.forcecraft.blocks.tree;

import com.mrbysco.forcecraft.world.feature.ForceFeatureConfigs;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class ForceTree extends AbstractTreeGrower {
	/**
	 * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
	 */
	@Nullable
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
		return largeHive ? ForceFeatureConfigs.FORCE_TREE_WITH_MORE_BEEHIVES_CONFIG : ForceFeatureConfigs.FORCE_TREE_CONFIG;
	}
}