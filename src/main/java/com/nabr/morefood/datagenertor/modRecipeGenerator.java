package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemGroup;
import com.nabr.morefood.item.ItemMain;
import com.nabr.morefood.item.ModBlocks;
import com.nabr.morefood.tags.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
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
                createShapeless(RecipeCategory.FOOD , ItemMain.GROUND_MEAT , 4)
                        .input(Tags.MOD_MEAT)
                        .group("more_food")
                        .criterion(hasItem(ItemMain.LITTLE_BEEF),conditionsFromItem(ItemMain.LITTLE_BEEF))
                        .offerTo(exporter);

                // 创建一个有序合成 (Shaped Recipe)
                // 输出：钻石苹果 * 1
                // 分类：FOOD（食物）
                createShaped(RecipeCategory.FOOD, ItemMain.DIAMOND_APPLE, 1)
                        .pattern(" d ")
                        .pattern("dad")
                        .pattern(" d ")
                        // 输入材料：把字符 'd' 映射到钻石物品
                        .input('d', Items.DIAMOND)
                        .input('a', Items.APPLE)
                        // 将该配方分到一个名为 "more_apple" 的配方组
                        // 配方书里同组的配方会合并成一个图标
                        .group("more_apple")
                        // 定义配方解锁条件（advancement 条件）
                        // 玩家必须至少拥有一个工作台，才能在合成书里解锁这个配方
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        // 把这个配方导出到数据生成器
                        .offerTo(exporter);
                // 无序合成：下界合金苹果
                // 输出：1 个下界合金苹果
                // 分类：FOOD
                createShapeless(RecipeCategory.FOOD, ItemMain.NETHERITE_APPLE, 1)
                        // 材料 1：苹果
                        .input(Items.APPLE)
                        // 材料 2：下界合金
                        .input(Items.NETHERITE_INGOT)
                        // 将配方分组，配方书里同组配方会合并成一个图标
                        .group("more_apple")
                        // 配方解锁条件：玩家必须拥有苹果
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        // 配方解锁条件：玩家必须拥有下界合金
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        // 导出配方到数据生成器
                        .offerTo(exporter);

                //绿宝石苹果
                createShaped((RecipeCategory.FOOD), ItemMain.EMERALD_APPLE , 1)
                        .pattern("EEE")
                        .pattern("EAE")
                        .pattern("EEE")
                        .input('E',Items.EMERALD)
                        .input('A',Items.APPLE)
                        .group("more_apple")
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);

                createShaped((RecipeCategory.FOOD), ItemMain.REDSTONE_APPLE , 1)
                        .pattern("EEE")
                        .pattern("EAE")
                        .pattern("EEE")
                        .input('E',Items.REDSTONE)
                        .input('A',Items.APPLE)
                        .group("more_apple")
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);

                createShaped((RecipeCategory.BUILDING_BLOCKS), ModBlocks.APPLE_BLOCK , 1)
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA" )
                        .input('A',Items.APPLE)
                        .group("more_apple")
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);

                createShaped((RecipeCategory.TOOLS), ItemMain.APPLE_SWORD , 1)
                        .pattern(" A ")
                        .pattern(" A ")
                        .pattern(" W " )
                        .input('A',ModBlocks.APPLE_BLOCK)
                        .input('W',Items.STICK)
                        .group("more_apple")
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(ModBlocks.APPLE_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD , ItemMain.INFINITE_APPLE , 1)
                        .input(ItemMain.DIAMOND_APPLE)
                        .input(ItemMain.EMERALD_APPLE)
                        .input(ItemMain.NETHERITE_APPLE)
                        .input(ItemMain.REDSTONE_APPLE)
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .group("more_apple")
                        .offerTo(exporter);
            }

        };
    }

    @Override
    public String getName() {
        return "";
    }
}
