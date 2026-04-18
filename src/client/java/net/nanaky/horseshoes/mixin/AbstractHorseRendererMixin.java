package net.nanaky.horseshoes.mixin;

import net.nanaky.horseshoes.client.HorseShoesRenderStateAccess;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.state.EquineRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractHorseRenderer.class)
public abstract class AbstractHorseRendererMixin {
    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/animal/equine/AbstractHorse;Lnet/minecraft/client/renderer/entity/state/EquineRenderState;F)V",
            at = @At("TAIL"))
    private void horseshoes$extractState(AbstractHorse horse, EquineRenderState state, float partialTick, CallbackInfo ci) {
        ItemStack shoes = horse.getItemBySlot(EquipmentSlot.FEET).copy();
        ((HorseShoesRenderStateAccess) state).horseshoes$setHorseshoeItem(shoes);
    }
}