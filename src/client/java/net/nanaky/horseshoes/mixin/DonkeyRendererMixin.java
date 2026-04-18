package net.nanaky.horseshoes.mixin;

import net.nanaky.horseshoes.client.HorseShoesLayer;
import net.nanaky.horseshoes.client.HorseShoesDonkeyModel;
import net.nanaky.horseshoes.client.HorseShoesRenderStateAccess;
import net.minecraft.client.renderer.entity.DonkeyRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.DonkeyRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.AbstractChestedHorse;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DonkeyRenderer.class)
public abstract class DonkeyRendererMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void horseshoes$addLayer(
            EntityRendererProvider.Context context,
            net.minecraft.client.resources.model.EquipmentClientInfo.LayerType saddleLayer,
            net.minecraft.client.model.geom.ModelLayerLocation saddleModel,
            DonkeyRenderer.Type adult,
            DonkeyRenderer.Type baby,
            CallbackInfo ci) {
        ((LivingEntityRendererAccessor) this).horseshoes$getLayers().add(
                new HorseShoesLayer<>((RenderLayerParent<DonkeyRenderState, ?>) (Object) this, new HorseShoesDonkeyModel())
        );
    }
}