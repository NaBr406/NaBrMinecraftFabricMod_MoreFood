package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemMain;
import com.nabr.morefood.tags.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class modItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
    public modItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(Tags.MOD_MEAT)
                .add(Registries.ITEM.getId(ItemMain.LITTLE_BEEF));

    }
}
