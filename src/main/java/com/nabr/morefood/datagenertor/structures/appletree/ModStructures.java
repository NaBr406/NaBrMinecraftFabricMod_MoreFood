package com.nabr.morefood.datagenertor.structures.appletree;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.StructureSet;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.Structure;

public class ModStructures {
    // 定义群系标签 Key (用于生成 has_apple_tree.json)
    public static final TagKey<Biome> HAS_APPLE_TREE = TagKey.of(RegistryKeys.BIOME, Identifier.of("more_food", "has_apple_tree"));

    // 定义结构相关的 Key
    public static final RegistryKey<StructurePool> APPLE_TREE_POOL = RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of("more_food", "apple_tree_pool"));
    public static final RegistryKey<Structure> APPLE_TREE = RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of("more_food", "apple_tree"));
    public static final RegistryKey<StructureSet> APPLE_TREE_SET = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Identifier.of("more_food", "apple_tree_set"));
}
