package com.nabr.morefood.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroup {
    public static final RegistryKey<net.minecraft.item.ItemGroup> MORE_FOOD_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of("more_food", "item_group")
    );
    public static final net.minecraft.item.ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.foodAndDrink"))
            .entries((displayContext, entries) ->
            {
                entries.add(ItemMain.LITTLE_BEEF);
                entries.add(ItemMain.LITTLE_MUTTON);
                entries.add(ItemMain.LITTLE_CHICKEN_MEAT);
                entries.add(ItemMain.LITTLE_PORK);
                entries.add(ItemMain.COOKED_LITTLE_BEEF);
                entries.add(ItemMain.COOKED_LITTLE_MUTTON);
                entries.add(ItemMain.COOKED_LITTLE_PORK);
                entries.add(ItemMain.COOKED_LITTLE_CHICKEN_MEAT);
                entries.add(ItemMain.DIAMOND_APPLE);
                entries.add(ItemMain.NETHERITE_APPLE);
                entries.add(ItemMain.EMERALD_APPLE);
                entries.add(ItemMain.REDSTONE_APPLE);
                entries.add(ModBlocks.APPLE_BLOCK);
                entries.add(ItemMain.APPLE_SWORD);
                entries.add(ItemMain.GREEN_APPLE);
                entries.add(ItemMain.LIGHTNING_APPLE);
                entries.add(ItemMain.INFINITE_APPLE);
                entries.add(ItemMain.ENDER_APPLE);
                entries.add(ItemMain.OBSIDIAN_APPLE);
                entries.add(ItemMain.BURGER);
                entries.add(ItemMain.MEATBALL);
                entries.add(ItemMain.GROUND_MEAT);
                entries.add(ItemMain.TSUKUYOMI_APPLE);
                entries.add(ItemMain.QZC_EYE);
            })
            .build();
    public static void initialize(){
        System.out.println("Group已加载");
        Registry.register(Registries.ITEM_GROUP, Identifier.of("more_food", "food"), ITEM_GROUP);
    }
}
