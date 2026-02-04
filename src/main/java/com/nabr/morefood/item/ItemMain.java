package com.nabr.morefood.item;

//import com.nabr.morefood.item.useresult.InfiniteApple;
//import com.nabr.morefood.item.useresult.LightningApple;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ItemMain {
    public ItemMain(){}
    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        // 创建注册表键 (RegistryKey): 指定物品注册表和具体ID
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("more_food", path));
        // registerKey 物品的注册键  factory 物品创建工厂 settings 物品配置
        return Items.register(registryKey, factory, settings);
    }
    public static void initialize() {
        System.out.println("物品已加载!");
    }
    //注册diamond apple
    public static final Item DIAMOND_APPLE = register("diamond_apple",Item::new, new Item.Settings().maxCount(64).
            food(FoodCharacteristic.DIAMOND_APPLE_COMPONENT,
                    FoodCharacteristic.DIAMOND_APPLE_CONSUMABLE_COMPONENT));

    //netherite apple 下界合金苹果
    public static final Item NETHERITE_APPLE = register("netherite_apple",Item::new, new Item.Settings().maxCount(1).
            food(FoodCharacteristic.NETHERITE_APPLE_COMPONENT,
                    FoodCharacteristic.NETHERITE_APPLE_CONSUMABLE_COMPONENT));

    //emerald apple 绿宝石苹果
    public static final Item EMERALD_APPLE = register("emerald_apple",Item::new, new Item.Settings().maxCount(64).
            food(FoodCharacteristic.DIAMOND_APPLE_COMPONENT,
                    FoodCharacteristic.EMERALD_APPLE_CONSUMABLE_COMPONENT));

    //Redstone_apple 红石苹果
    public static final Item REDSTONE_APPLE = register("redstone_apple",Item::new, new Item.Settings().maxCount(64).
            food(FoodCharacteristic.DIAMOND_APPLE_COMPONENT,
                    FoodCharacteristic.REDSTONE_APPLE_CONSUMABLE_COMPONENT));

    //青苹果
    public static final Item GREEN_APPLE = register("green_apple",Item::new, new Item.Settings().maxCount(64).
            food(FoodComponents.APPLE));

    //雷击苹果
    public static final Item LIGHTNING_APPLE = register("lightning_apple",
            Item::new,new Item.Settings().
                    maxCount(64).
                    food(FoodCharacteristic.RAW_MEAT_COMPONENT));

    //无限苹果
    public static final Item INFINITE_APPLE = register("infinite_apple",
            Item::new , new Item.Settings().
                    maxCount(1).
                    food(FoodCharacteristic.RAW_MEAT_COMPONENT));

    //apple_sword 苹果剑
    public static final Item APPLE_SWORD = register(
            "apple_sword",
            Item::new,
            new Item.Settings().
                    sword(ModToolMaterial.APPLE_SWORD_MATERIAL, 1f, 1f)
    );
    //小猪肉
    public static final Item LITTLE_PORK = register("little_pork", Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.RAW_MEAT_COMPONENT));
    public static final Item COOKED_LITTLE_PORK = register("cooked_little_pork", Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.COOKED_MEAT_COMPONENT));

    //小羊肉
    public static final Item LITTLE_MUTTON = register("little_mutton",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.RAW_MEAT_COMPONENT));
    public static final Item COOKED_LITTLE_MUTTON = register("cooked_little_mutton",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.COOKED_MEAT_COMPONENT));

    //小牛肉
    public static final Item LITTLE_BEEF = register("little_beef",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.RAW_MEAT_COMPONENT));
    public static final Item COOKED_LITTLE_BEEF = register("cooked_little_beef",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.COOKED_MEAT_COMPONENT));

    //小鸡肉
    public static final Item LITTLE_CHICKEN_MEAT = register("little_chicken_meat",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.RAW_MEAT_COMPONENT));
    public static final Item COOKED_LITTLE_CHICKEN_MEAT = register("cooked_little_chicken_meat",Item::new , new Item.Settings()
            .maxCount(64).food(FoodCharacteristic.COOKED_MEAT_COMPONENT));

    //肉沫
    public static final Item GROUND_MEAT = register("ground_meat",Item::new , new Item.Settings()
            .maxCount(64));
}
