package com.nabr.morefood.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModToolMaterial {
    public static final ToolMaterial APPLE_SWORD_MATERIAL = new ToolMaterial(
            BlockTags.PICKAXE_MINEABLE,   // ✅ 可用于开采的方块标签（比如镐）
            1,                          // 耐久度
            5.0f,                         // 挖掘速度
            1.5f,                         // 攻击伤害
            22,                           // 附魔能力
            TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("empty"))
    );
}
