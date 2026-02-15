package com.nabr.morefood.entity.modlivingentity.qzc;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class QZCEntityModel extends BipedEntityModel<QZCRenderState> {

    public QZCEntityModel(ModelPart root) {
        super(root);
    }

    //  直接使用原版人型模型数据
    public static TexturedModelData getTexturedModelData() {
        // Dilation.NONE 表示模型不膨胀（标准大小）
        // 0F 是偏移量
        return TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE, 0F), 64, 64);
    }
}