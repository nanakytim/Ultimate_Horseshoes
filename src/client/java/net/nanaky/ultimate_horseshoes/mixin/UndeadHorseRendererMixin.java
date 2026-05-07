package net.nanaky.ultimate_horseshoes.mixin;

import net.nanaky.ultimate_horseshoes.client.HorseShoesLayer;
import net.nanaky.ultimate_horseshoes.client.HorseShoesModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.UndeadHorseRenderer;
import net.minecraft.client.renderer.entity.state.EquineRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(UndeadHorseRenderer.class)
public abstract class UndeadHorseRendererMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void horseshoes$addLayer(
            EntityRendererProvider.Context context,
            net.minecraft.client.resources.model.EquipmentClientInfo.LayerType saddleLayer,
            net.minecraft.client.model.geom.ModelLayerLocation saddleModel,
            UndeadHorseRenderer.Type adult,
            UndeadHorseRenderer.Type baby,
            CallbackInfo ci) {
        ((LivingEntityRendererAccessor) this).horseshoes$getLayers().add(
                new HorseShoesLayer<>((RenderLayerParent<EquineRenderState, ?>) (Object) this, new HorseShoesModel())
        );
    }
}