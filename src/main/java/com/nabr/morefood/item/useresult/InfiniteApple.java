package com.nabr.morefood.item.useresult;

import com.nabr.morefood.item.ItemMain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
/*
public class InfiniteApple extends Item {
    public InfiniteApple(Settings settings) {
        super(settings);
    }
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user){
        ItemStack returnStack = super.finishUsing(stack, world, user);
        if(!world.isClient){
            if(user instanceof PlayerEntity player){
                ItemStack drop = new ItemStack(ItemMain.INFINITE_APPLE , 1);
                player.getInventory().insertStack(drop);
            }
        }
        return returnStack;
    }
}

 */
