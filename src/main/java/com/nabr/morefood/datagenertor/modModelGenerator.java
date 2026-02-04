package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemMain;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class modModelGenerator extends FabricModelProvider {
    public modModelGenerator(FabricDataOutput output){
        super(output);
    }
    //方块模型
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){

    }
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_BEEF , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_MUTTON , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_CHICKEN_MEAT , Models.GENERATED);
        itemModelGenerator.register(ItemMain.COOKED_LITTLE_PORK , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_MUTTON , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_CHICKEN_MEAT , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_PORK , Models.GENERATED);
        itemModelGenerator.register(ItemMain.LITTLE_BEEF , Models.GENERATED);
    }
}
