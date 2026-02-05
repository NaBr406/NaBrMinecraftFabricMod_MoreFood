package com.nabr.morefood.item;

import com.nabr.morefood.MoreFood;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class FoodCharacteristic {
    public static final FoodComponent RAW_MEAT_COMPONENT = new FoodComponent.Builder()
            //饱食度
            .nutrition(2)
            //饱和度
            .saturationModifier(2)
            .alwaysEdible()
            .build();

    public static final FoodComponent COOKED_MEAT_COMPONENT = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(10)
            .build();

    //钻石苹果食用回复饱食度
    public static final FoodComponent DIAMOND_APPLE_COMPONENT = new FoodComponent.Builder()
            //恢复饱食度
            .nutrition(3)
            //饱和度
            .saturationModifier(10)
            .alwaysEdible()
            .build();
    //钻石苹果效果
    public static final ConsumableComponent DIAMOND_APPLE_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            //给予
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,
                    2 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,
                    60 * 20, 3), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,
                    90 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED,
                    90 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,
                    1, 1), 0.5f))
            .build();

    //下界合金苹果回复饱食度
    public static final FoodComponent NETHERITE_APPLE_COMPONENT = new FoodComponent.Builder()
            //恢复饱食度
            .nutrition(20)
            //饱和度
            .saturationModifier(20)
            .alwaysEdible()
            .build();
    //效果resistance fire_resistance
    public static final ConsumableComponent NETHERITE_APPLE_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,
                    60*20, 9), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,
                    120*20, 9), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH,
                    60*20, 4), 1.0f))
            .build();

    public static  final ConsumableComponent EMERALD_APPLE_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE,
                    60*20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN,
                    30*20, 0), 0.05f))
            .build();

    public static final ConsumableComponent REDSTONE_APPLE_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING,
                    30*20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(MoreFood.AMATERASU,
                    30*20 , 1) , 1.0F))
            .build();
}
