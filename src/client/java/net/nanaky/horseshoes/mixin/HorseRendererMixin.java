package net.nanaky.horseshoes.mixin;

import net.nanaky.horseshoes.client.HorseShoesLayer;
import net.nanaky.horseshoes.client.HorseShoesModel;
import net.nanaky.horseshoes.client.HorseShoesRenderStateAccess;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.HorseRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(HorseRenderer.class)
public abstract class HorseRendererMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void horseshoes$addLayer(EntityRendererProvider.Context context, CallbackInfo ci) {
        ((LivingEntityRendererAccessor) this).horseshoes$getLayers().add(
        new HorseShoesLayer<>((RenderLayerParent<HorseRenderState, ?>) (Object) this, new HorseShoesModel())
        );
    }
}