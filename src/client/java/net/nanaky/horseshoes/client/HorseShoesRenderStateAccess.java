package net.nanaky.horseshoes.client;

import net.minecraft.world.item.ItemStack;

public interface HorseShoesRenderStateAccess {
    ItemStack horseshoes$getHorseshoeItem();
    void horseshoes$setHorseshoeItem(ItemStack itemStack);
}