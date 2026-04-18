package net.nanaky.horseshoes.client;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.nanaky.horseshoes.mixin.AbstractEquineModelAccessor;

public class HorseShoesDonkeyModel extends HorseShoesModel {

    public HorseShoesDonkeyModel() {
        super(createDonkeyLayer().bakeRoot());
    }

    @Override
    public void syncToHorseLegs(AbstractEquineModelAccessor horseModel) {
        super.syncToHorseLegs(horseModel);
        // Shift all 4 shoes down and recentre on Z axis
        adjustShoe(leftFrontShoe,  -1.6F, 1.75F);
        adjustShoe(rightFrontShoe, -1.6F, 1.75F);
        adjustShoe(leftHindShoe,   -1.6F,  -1.5F);
        adjustShoe(rightHindShoe,  -1.6F,  -1.5F);
    }

    private void adjustShoe(net.minecraft.client.model.geom.ModelPart shoe, float yOffset, float zOffset) {
        shoe.y += yOffset;
        shoe.z += zOffset;
    }

    public static LayerDefinition createDonkeyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        CubeDeformation deform = new CubeDeformation(0.57F);
        float shift = 0.25F;

        // Height reduced from 2 to 1 (the 4th dimension arg in addBox)
        root.addOrReplaceChild("left_front_shoe",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F + shift + 0.5F, 10F, -1.9F + 0.5F, 3, 1, 3, deform),
                PartPose.offset(5.0F, 14.0F, -10.0F));

        root.addOrReplaceChild("right_front_shoe",
                CubeListBuilder.create().texOffs(0, 6)
                        .addBox(-1.0F - shift + 0.5F, 10F, -1.9F + 0.5F, 3, 1, 3, deform),
                PartPose.offset(-5.0F, 14.0F, -10.0F));

        root.addOrReplaceChild("left_hind_shoe",
                CubeListBuilder.create().texOffs(16, 0)
                        .addBox(-3.0F + shift + 0.5F, 10F, -1.0F + 0.5F, 3, 1, 3, deform),
                PartPose.offset(5.0F, 14.0F, 7.0F));

        root.addOrReplaceChild("right_hind_shoe",
                CubeListBuilder.create().texOffs(16, 6)
                        .addBox(-1.0F - shift + 0.5F, 10F, -1.0F + 0.5F, 3, 1, 3, deform),
                PartPose.offset(-5.0F, 14.0F, 7.0F));

        return LayerDefinition.create(mesh, 32, 16);
    }
}