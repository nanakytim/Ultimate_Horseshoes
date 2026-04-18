package net.nanaky.horseshoes.mixin;

import net.nanaky.horseshoes.client.HorseShoesRenderStateAccess;
import net.minecraft.client.renderer.entity.state.EquineRenderState;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EquineRenderState.class)
public class EquineRenderStateMixin implements HorseShoesRenderStateAccess {
    @Unique
    private ItemStack horseshoes$horseshoeItem = ItemStack.EMPTY;

    @Override
    public ItemStack horseshoes$getHorseshoeItem() { return this.horseshoes$horseshoeItem; }
    @Override
    public void horseshoes$setHorseshoeItem(ItemStack stack) { this.horseshoes$horseshoeItem = stack; }
}