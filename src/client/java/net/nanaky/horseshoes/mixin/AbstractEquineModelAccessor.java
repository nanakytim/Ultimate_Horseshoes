package net.nanaky.horseshoes.mixin;

import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "net.minecraft.client.model.animal.equine.AbstractEquineModel")
public interface AbstractEquineModelAccessor {
    @Accessor("rightHindLeg")
    ModelPart horseshoes$getRightHindLeg();
    @Accessor("leftHindLeg")
    ModelPart horseshoes$getLeftHindLeg();
    @Accessor("rightFrontLeg")
    ModelPart horseshoes$getRightFrontLeg();
    @Accessor("leftFrontLeg")
    ModelPart horseshoes$getLeftFrontLeg();
}