package com.nabr.morefood.datagenertor.structures;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {

    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        // 2. 在 super 中指定这是关于 BIOME 的标签生成器
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // 3. 构建你的标签
        getTagBuilder(ModStructures.HAS_APPLE_TREE)
                .addOptionalTag(BiomeTags.IS_FOREST.id()); // 包含原版所有的森林群系

        getTagBuilder(ModStructures.QZC_HOME)
                .addOptionalTag(BiomeTags.IS_FOREST.id());
    }
}
