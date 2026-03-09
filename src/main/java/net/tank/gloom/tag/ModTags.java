package net.tank.gloom.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Block> WISH_CAN_DESTROY = BlockTags.create(new ResourceLocation("gloom", "wish_can_destroy"));
    public static final TagKey<Item> PICKAXETAG = ItemTags.create(new ResourceLocation("minecraft", "pickaxes"));
    public static final TagKey<Item> STONE_REPLACEABLES=ItemTags.create(new ResourceLocation("gloom", "stone_replaceables"));
}
