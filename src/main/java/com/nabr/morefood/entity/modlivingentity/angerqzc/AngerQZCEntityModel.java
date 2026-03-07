package com.nabr.morefood.entity.modlivingentity.angerqzc;

import com.nabr.morefood.entity.modlivingentity.qzc.QZCRenderState;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class AngerQZCEntityModel extends BipedEntityModel<AngerQZCRenderState> {
    public AngerQZCEntityModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE , 0F), 64 , 64);
    }
}
