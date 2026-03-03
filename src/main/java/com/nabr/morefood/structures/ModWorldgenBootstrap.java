package com.nabr.morefood.structures;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.heightprovider.ConstantHeightProvider;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.structure.StructureSet;
import net.minecraft.world.gen.StructureTerrainAdaptation;

import java.util.List;

public class ModWorldgenBootstrap {

    // 1. 构建模板池 (定义 NBT 引用)
    public static void bootstrapPools(Registerable<StructurePool> context) {
        RegistryEntryLookup<StructurePool> poolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        context.register(ModStructures.APPLE_TREE_POOL, new StructurePool(
                // 注意这里也有改动：getOrThrow 在新版本需要传入 RegistryKey 而不是 Identifier
                poolLookup.getOrThrow(RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of("minecraft", "empty"))),
                List.of(
                        // 删掉了后面的 .apply(StructurePool.Projection.RIGID)
                        Pair.of(StructurePoolElement.ofSingle(Identifier.of("more_food", "apple_tree").toString()), 1)
                ),
                StructurePool.Projection.RIGID
        ));
    }

    // 2. 构建结构 (定义生成环境和地形适配)
    public static void bootstrapStructures(Registerable<Structure> context) {
        var poolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        var biomeLookup = context.getRegistryLookup(RegistryKeys.BIOME);

        context.register(ModStructures.APPLE_TREE, new JigsawStructure(
                new Structure.Config(
                        biomeLookup.getOrThrow(ModStructures.HAS_APPLE_TREE), // 1. 允许生成的群系标签
                        java.util.Map.of(),                                   // 2. [新增] 覆盖刷怪配置 (空Map代表没有专属刷怪)
                        GenerationStep.Feature.SURFACE_STRUCTURES,            // 3. 生成阶段
                        StructureTerrainAdaptation.BEARD_THIN                 // 4. 地形适配
                ),
                poolLookup.getOrThrow(ModStructures.APPLE_TREE_POOL),
                1,
                ConstantHeightProvider.create(YOffset.fixed(0)),
                false,
                Heightmap.Type.WORLD_SURFACE_WG
        ));
    }

    // 3. 构建结构集 (定义生成频率和间距)
    public static void bootstrapStructureSets(Registerable<StructureSet> context) {
        var structureLookup = context.getRegistryLookup(RegistryKeys.STRUCTURE);

        context.register(ModStructures.APPLE_TREE_SET, new StructureSet(
                structureLookup.getOrThrow(ModStructures.APPLE_TREE),
                new RandomSpreadStructurePlacement(
                        20, // 最大区块间距
                        0,  // 最小区块间距
                        SpreadType.LINEAR,
                        87654321 // 随机盐值，必须确保其他结构不共用此数值
                )
        ));
    }
}