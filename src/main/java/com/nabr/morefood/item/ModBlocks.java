package com.nabr.morefood.item;

import com.nabr.morefood.MoreFood;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    /**
     * 注册一个方块，并根据需要决定是否注册对应的方块物品
     *
     * @param blockFactory     用于生成方块实例的工厂方法（通常是 Block::new 或自定义方块构造器）
     * @param settings         方块的设置（硬度、抗爆性、音效等）
     * @param shouldRegisterItem 是否需要为该方块注册对应的物品
     * @return 注册好的方块实例
     */
    private static Block register(String name,
                                  Function<AbstractBlock.Settings, Block> blockFactory,
                                  AbstractBlock.Settings settings,
                                  boolean shouldRegisterItem) {
        // 创建一个方块的注册键 (RegistryKey)，标识唯一方块 ID
        RegistryKey<Block> blockKey = keyOfBlock(name);

        // 使用 blockFactory 和 settings 创建方块实例
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // 如果需要注册方块物品（通常是大多数方块，少数技术方块如 moving_piston 不需要）
        if (shouldRegisterItem) {
            // 为方块物品创建一个对应的注册键
            RegistryKey<Item> itemKey = keyOfItem(name);

            // 创建方块物品并绑定到该方块
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));

            // 将方块物品注册到物品注册表
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        // 将方块注册到方块注册表，并返回方块实例
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    /**
     * 生成方块的 RegistryKey
     * @return 方块的 RegistryKey
     */
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreFood.MOD_ID, name));
    }


    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreFood.MOD_ID, name));
    }

    public static final Block APPLE_BLOCK = register(
            "apple_block",
            Block::new,
            AbstractBlock.Settings.create()
                    //硬度 抗爆
                    .strength(2.0f,1.0f)
                    //使用工具掉落
                    .requiresTool()
                    //放置破坏声音
                    .sounds(BlockSoundGroup.WOOD),
            //注册对应方块物品
            true
    );

    public static void initialize() {

    }
}
