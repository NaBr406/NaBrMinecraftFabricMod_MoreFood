package com.nabr.morefood.entity.modlivingentity;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

// 1. 改为继承 BipedEntityRenderer
// 泛型参数顺序：<实体类, 状态类, 模型类>
public class QZCEntityRenderer extends BipedEntityRenderer<QZCEntity, QZCRenderState, QZCEntityModel> {

    public QZCEntityRenderer(EntityRendererFactory.Context context) {
        // 0.5f 是影子大小
        super(context, new QZCEntityModel(context.getPart(EntityMainClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public QZCRenderState createRenderState() {
        return new QZCRenderState();
    }

    // 2. 贴图路径
    @Override
    public Identifier getTexture(QZCRenderState state) {
        return Identifier.of("more_food", "textures/entity/qzc/qzc.png");
    }
}