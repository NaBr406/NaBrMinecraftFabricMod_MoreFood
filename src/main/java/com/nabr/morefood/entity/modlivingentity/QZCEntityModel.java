package com.nabr.morefood.entity.modlivingentity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;

// 1. 改为继承 BipedEntityModel
public class QZCEntityModel extends BipedEntityModel<QZCRenderState> {

    public QZCEntityModel(ModelPart root) {
        super(root);
    }

    // 2. 直接使用原版人型模型数据
    public static TexturedModelData getTexturedModelData() {
        // Dilation.NONE 表示模型不膨胀（标准大小）
        // 0F 是偏移量
        return TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE, 0F), 64, 64);
    }
}