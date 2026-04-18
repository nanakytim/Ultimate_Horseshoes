package net.nanaky.horseshoes.mixin;

import net.nanaky.horseshoes.Horseshoes;
import net.nanaky.horseshoes.IHorseshoesContainer;
import net.nanaky.horseshoes.config.ModConfigs;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.AbstractMountInventoryScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMountInventoryScreen.class)
public abstract class AbstractHorseScreenMixin<M extends AbstractContainerMenu>
        extends AbstractContainerScreen<M> {

    private static final Identifier HORSESHOES_TEXTURE =
            Identifier.fromNamespaceAndPath("horseshoes", "textures/gui/container/horse.png");
        
    private static final Identifier SHEARS_HINT_TEXTURE =
        Identifier.fromNamespaceAndPath("horseshoes", "textures/gui/slot_lock.png");

    protected AbstractHorseScreenMixin(M menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Shadow protected net.minecraft.world.entity.LivingEntity mount;

    @Inject(method = "extractBackground", at = @At("TAIL"))
    private void horseshoes$renderHorseshoeSlot(GuiGraphicsExtractor graphics,
                                                int mouseX, int mouseY, float partialTick,
                                                CallbackInfo ci) {
        if (!(this.mount instanceof AbstractHorse horse)) return;
        if (!horse.getType().builtInRegistryHolder().is(Horseshoes.ALLOWED)) return;
        if (!horse.canUseSlot(EquipmentSlot.FEET)) return;

        int xo = this.leftPos + 7;
        int yo = this.topPos + 53;

        graphics.blit(
            RenderPipelines.GUI_TEXTURED,
            HORSESHOES_TEXTURE,
            xo, yo,
            54, 220,
            18, 18,
            256, 256
            );

        ItemStack equipped = ((IHorseshoesContainer) horse).horseshoes$getContainer().getItem(0);
        if (!equipped.isEmpty() & (ModConfigs.SLOT_LOCK)) {
            graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                SHEARS_HINT_TEXTURE,
                xo+1, yo+1,
                0, 0,
                16, 16,
                16, 16
            );
        }
    }    
}