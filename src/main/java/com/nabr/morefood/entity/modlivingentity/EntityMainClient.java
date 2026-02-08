package com.nabr.morefood.entity.modlivingentity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class EntityMainClient implements ClientModInitializer {

    // 1. 定义模型层 ID
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(
            Identifier.of("more_food", "qzc"), "main");

    @Override
    public void onInitializeClient() {
        // 2. 注册渲染器
        EntityRendererRegistry.register(EntityMain.QZC, QZCEntityRenderer::new);

        // 3. 注册模型层（把模型类里的“图纸”交给游戏）
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, QZCEntityModel::getTexturedModelData);
    }
}
