package com.nabr.morefood.entity.modlivingentity;

import com.nabr.morefood.entity.modlivingentity.qzc.QZCEntityModel;
import com.nabr.morefood.entity.modlivingentity.qzc.QZCEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class EntityMainClient implements ClientModInitializer {

    // 定义模型层 ID
    public static final EntityModelLayer MODEL_QZC_LAYER = new EntityModelLayer(
            Identifier.of("more_food", "qzc"), "main");

    @Override
    public void onInitializeClient() {
        // 注册渲染器
        EntityRendererRegistry.register(EntityMain.QZC, QZCEntityRenderer::new);

        // 注册模型层
        EntityModelLayerRegistry.registerModelLayer(MODEL_QZC_LAYER, QZCEntityModel::getTexturedModelData);
    }
}
