package net.nanaky.ultimate_horseshoes.client;

import net.minecraft.world.item.ItemStack;

public interface HorseShoesRenderStateAccess {
    ItemStack horseshoes$getHorseshoeItem();
    void horseshoes$setHorseshoeItem(ItemStack itemStack);
}