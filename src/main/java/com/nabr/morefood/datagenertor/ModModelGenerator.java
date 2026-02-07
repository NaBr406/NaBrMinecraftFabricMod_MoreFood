package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemMain;
import com.nabr.morefood.item.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

//数据生成模型
public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output){
        super(output);
    }
    //方块模型
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.APPLE_BLOCK);
    }
    //物品模型
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_BEEF , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_MUTTON , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_CHICKEN_MEAT , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_PORK , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_MUTTON , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_CHICKEN_MEAT , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_PORK , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_BEEF , Models.GENERATED);
        itemModelGenerator.register(ItemMain.APPLE_SWORD , Models.HANDHELD);
        itemModelGenerator.register(ItemMain.DIAMOND_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.EMERALD_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.GREEN_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LIGHTNING_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.NETHERITE_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.REDSTONE_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.INFINITE_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.ENDER_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.OBSIDIAN_APPLE , Models.GENERATED);
        itemModelGenerator.register(ItemMain.BURGER , Models.GENERATED);
        itemModelGenerator.register(ItemMain.GROUND_MEAT , Models.GENERATED);
        itemModelGenerator.register(ItemMain.MEATBALL , Models.GENERATED);
    }
}
