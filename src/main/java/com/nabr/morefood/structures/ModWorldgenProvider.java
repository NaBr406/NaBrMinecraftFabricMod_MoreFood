package com.nabr.morefood.structures;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModWorldgenProvider extends FabricDynamicRegistryProvider {

    public ModWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        // 将三个部分的动态注册表内容全部导出为 JSON
        entries.addAll(registries.getOrThrow(RegistryKeys.TEMPLATE_POOL));
        entries.addAll(registries.getOrThrow(RegistryKeys.STRUCTURE));
        entries.addAll(registries.getOrThrow(RegistryKeys.STRUCTURE_SET));
    }

    @Override
    public String getName() {
        return "MoreFood Worldgen";
    }
}