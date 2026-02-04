package com.nabr.morefood.tags;

import com.mojang.datafixers.types.templates.Tag;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Tags {
    public static final TagKey<Item> MOD_MEAT = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.tryParse("mod_meat")
    );
    private static TagKey<Item> createTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of("my_mod", name));
    }
}
