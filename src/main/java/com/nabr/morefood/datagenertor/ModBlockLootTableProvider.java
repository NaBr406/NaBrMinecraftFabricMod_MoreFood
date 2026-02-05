package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput Output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(Output, registryLookup);
    }

    @Override
    public void generate() {
        addDropWithSilkTouch(ModBlocks.APPLE_BLOCK);
        addDrop(ModBlocks.APPLE_BLOCK , Items.APPLE);

        /*
        // addDrop 是 LootTableProvider 内的快捷方法，会自动为方块生成掉落其自身的表
        // addSurvivesExplosionCondition(...) 用于确保方块在爆炸摧毁时仍有掉落几率
        LootPool.Builder normalDropPool = LootPool.builder()
                .rolls(new UniformLootNumberProvider(
                        new ConstantLootNumberProvider(7),
                        new ConstantLootNumberProvider(9)))
                .with(ItemEntry.builder(Items.APPLE))
                .conditionally(SurvivesExplosionLootCondition.builder()); // 爆炸保护
        //欠一个精准采集掉落原物
        LootPool.Builder silkTouchDropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModBlocks.APPLE_BLOCK));

        addDrop(ModBlocks.APPLE_BLOCK, LootTable.builder()
                        .pool(normalDropPool)
                //欠一个精准采集掉落原物
                //.pool(silkTouchDropPool)
        );

         */

    }

}
