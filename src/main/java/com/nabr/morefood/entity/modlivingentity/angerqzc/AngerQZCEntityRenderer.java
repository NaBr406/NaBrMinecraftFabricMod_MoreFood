package com.nabr.morefood.entity.modlivingentity.angerqzc;

import com.nabr.morefood.entity.modlivingentity.EntityMainClient;
import com.nabr.morefood.entity.modlivingentity.qzc.QZCEntityModel;
import com.nabr.morefood.entity.modlivingentity.qzc.QZCRenderState;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class AngerQZCEntityRenderer extends BipedEntityRenderer<AngerQZCEntity , AngerQZCRenderState , AngerQZCEntityModel> {
    public AngerQZCEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AngerQZCEntityModel(context.getPart(EntityMainClient.MODEL_QZC_LAYER)), 0.5f);
    }
    @Override
    public AngerQZCRenderState createRenderState(){
        return new AngerQZCRenderState();
    }

    @Override
    public Identifier getTexture(AngerQZCRenderState state){
        return Identifier.of("more_food","textures/entity/anger_qzc.png");
    }
}
