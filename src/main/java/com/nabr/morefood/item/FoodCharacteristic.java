package com.nabr.morefood.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;

public class FoodCharacteristic {
    public static final FoodComponent RAW_MEAT_COMPONENT = new FoodComponent.Builder()
            //饱食度
            .nutrition(2)
            //饱和度
            .saturationModifier(2)
            .build();

    public static final FoodComponent COOKED_MEAT_COMPONENT = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(10)
            .build();
}
