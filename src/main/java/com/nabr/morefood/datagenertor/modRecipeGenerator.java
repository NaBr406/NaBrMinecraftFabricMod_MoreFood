package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class modRecipeGenerator extends FabricRecipeProvider {
    public modRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesLookup) {
        super(output, registriesLookup);
    }

    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            public void generate() {
                //熔炼配方
                offerSmelting(
                        List.of(ItemMain.LITTLE_PORK),
                        RecipeCategory.MISC,
                        ItemMain.COOKED_LITTLE_PORK,
                        0.5f,
                        200,
                        "newFood"
                );
                offerSmelting(
                        List.of(ItemMain.LITTLE_BEEF),
                        RecipeCategory.MISC,
                        ItemMain.COOKED_LITTLE_BEEF,
                        0.5f,
                        200,
                        "newFood"
                );
                offerSmelting(
                        List.of(ItemMain.LITTLE_MUTTON),
                        RecipeCategory.MISC,
                        ItemMain.COOKED_LITTLE_MUTTON,
                        0.5f,
                        200,
                        "newFood"
                );
                offerSmelting(
                        List.of(ItemMain.LITTLE_CHICKEN_MEAT),
                        RecipeCategory.MISC,
                        ItemMain.COOKED_LITTLE_CHICKEN_MEAT,
                        0.5f,
                        200,
                        "newFood"
                );
                //合成配方
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
