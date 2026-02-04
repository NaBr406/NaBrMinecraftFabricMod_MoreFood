package com.nabr.morefood.datagenertor;

import com.nabr.morefood.item.ItemMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class modLootTableGenerator extends SimpleFabricLootTableProvider {
    public modLootTableGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(output, registryLookup, LootContextTypes.ENTITY);
    }

    public static final RegistryKey<LootTable> MOD_PIG_LOOTPOOL = RegistryKey.of(RegistryKeys.LOOT_TABLE , Identifier.of("minecraft" , "entities/pig"));
    public static final RegistryKey<LootTable> MOD_COW_LOOTPOOL = RegistryKey.of(RegistryKeys.LOOT_TABLE , Identifier.of("minecraft" , "entities/cow"));
    public static final RegistryKey<LootTable> MOD_SHEEP_LOOTPOOL = RegistryKey.of(RegistryKeys.LOOT_TABLE , Identifier.of("minecraft" , "entities/sheep"));
    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        //babyPig掉落池
        lootTableBiConsumer.accept(MOD_PIG_LOOTPOOL, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .with(ItemEntry.builder(ItemMain.COOKED_LITTLE_PORK)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                .conditionally(EntityPropertiesLootCondition.builder(
                                                LootContext.EntityTarget.THIS,
                                                EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).isBaby(true))
                                ))
                        )
                )
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .with(ItemEntry.builder(ItemMain.LITTLE_PORK)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                //isBaby 掉生的
                                //.conditionally(RandomChanceLootCondition.builder(0.5F))
                                .conditionally(EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().isBaby(true))
                                ))
                        )
                )
                //成年猪正常掉落
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .with(ItemEntry.builder(Items.PORKCHOP)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                //限制条件
                                .conditionally(RandomChanceLootCondition.builder(0.5F))
                                .conditionally(EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(false).isBaby(false))
                                ))
                        )
                )
                //成年猪着火掉落
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .with(ItemEntry.builder(Items.COOKED_PORKCHOP)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                //限制条件 isBaby onFire 掉熟的
                                .conditionally(RandomChanceLootCondition.builder(0.5F))
                                .conditionally(EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).isBaby(false))
                                ))
                        )
                         )
        );
        //牛的
        lootTableBiConsumer.accept(MOD_COW_LOOTPOOL, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.LEATHER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F , 2.0F))))
                )
                .pool(minecraftMeatPoolBuild(Items.BEEF , Items.COOKED_BEEF , 0.0F , 3.0F , 1.0F))
                .pool(modBabyMeatPoolBuild(ItemMain.LITTLE_BEEF,ItemMain.COOKED_LITTLE_BEEF , 0.0F , 3.0F , 1.0F))
        );
        //羊的
        lootTableBiConsumer.accept(MOD_SHEEP_LOOTPOOL , LootTable.builder()
                .pool(minecraftMeatPoolBuild(Items.MUTTON , Items.COOKED_MUTTON , 0.0F , 3.0F , 1.0F))
                .pool(modBabyMeatPoolBuild(ItemMain.LITTLE_MUTTON , ItemMain.COOKED_LITTLE_MUTTON  , 0.0F , 3.0F , 1.0F))
        );
    }


    //一键创建原版肉类掉落
    public LootPool.Builder minecraftMeatPoolBuild(Item meat , Item cookedMeat , float min , float max , float count){
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(count))
                .with(ItemEntry.builder(meat)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min,max)))
                        .conditionally(EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.THIS ,
                                EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().isBaby(false).onFire(false))
                        ))
                )
                .with(ItemEntry.builder(cookedMeat)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min,max)))
                        .conditionally(EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.THIS ,
                                EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().isBaby(false).onFire(true))
                        )));
    }

    private LootPool.Builder modBabyMeatPoolBuild(Item meat , Item cookedMeat , float min , float max , float count) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(count))
                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().isBaby(true))))
                .with(ItemEntry.builder(meat)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min,max)))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(false)))))
                .with(ItemEntry.builder(cookedMeat)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min,max)))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true)))));
    }

}
