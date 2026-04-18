package net.nanaky.horseshoes.client;

import net.nanaky.horseshoes.mixin.AbstractEquineModelAccessor;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EquineRenderState;

public class HorseShoesModel extends EntityModel<EquineRenderState> {
    private static final String LEFT_FRONT_SHOE  = "left_front_shoe";
    private static final String RIGHT_FRONT_SHOE = "right_front_shoe";
    private static final String LEFT_HIND_SHOE   = "left_hind_shoe";
    private static final String RIGHT_HIND_SHOE  = "right_hind_shoe";
    private static final float FRONT_Z = -0.875F;
    private static final float HIND_Z  =  0.8125F;

    protected final ModelPart leftFrontShoe;
    protected final ModelPart rightFrontShoe;
    protected final ModelPart leftHindShoe;
    protected final ModelPart rightHindShoe;

    public HorseShoesModel(ModelPart root) {
        super(root);
        this.leftFrontShoe  = root.getChild("left_front_shoe");
        this.rightFrontShoe = root.getChild("right_front_shoe");
        this.leftHindShoe   = root.getChild("left_hind_shoe");
        this.rightHindShoe  = root.getChild("right_hind_shoe");
    }

    public HorseShoesModel() {
        this(createLayer().bakeRoot());
    }

    public void syncToHorseLegs(AbstractEquineModelAccessor horseModel) {
        copyPose(horseModel.horseshoes$getLeftFrontLeg(),  this.leftFrontShoe);
        copyPose(horseModel.horseshoes$getRightFrontLeg(), this.rightFrontShoe);
        copyPose(horseModel.horseshoes$getLeftHindLeg(),   this.leftHindShoe);
        copyPose(horseModel.horseshoes$getRightHindLeg(),  this.rightHindShoe);
        this.leftFrontShoe.z  += FRONT_Z;
        this.rightFrontShoe.z += FRONT_Z;
        this.leftHindShoe.z   += HIND_Z;
        this.rightHindShoe.z  += HIND_Z;
    }

    @Override
    public void setupAnim(EquineRenderState state) {}

    private static void copyPose(ModelPart source, ModelPart target) {
        target.x      = source.x;
        target.y      = source.y;
        target.z      = source.z;
        target.xRot   = source.xRot;
        target.yRot   = source.yRot;
        target.zRot   = source.zRot;
        target.xScale = source.xScale;
        target.yScale = source.yScale;
        target.zScale = source.zScale;
        target.visible = source.visible;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        CubeDeformation deform = new CubeDeformation(0.57F);
        float shift = 0.25F;

        root.addOrReplaceChild(LEFT_FRONT_SHOE,
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F + shift, 8.0F, -1.9F, 4, 2, 4, deform),
                PartPose.offset(4.0F, 14.0F, -10.0F));
        root.addOrReplaceChild(RIGHT_FRONT_SHOE,
                CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F - shift, 8.0F, -1.9F, 4, 2, 4, deform),
                PartPose.offset(-4.0F, 14.0F, -10.0F));
        root.addOrReplaceChild(LEFT_HIND_SHOE,
                CubeListBuilder.create().texOffs(16, 0).addBox(-3.0F + shift, 8.0F, -1.0F, 4, 2, 4, deform),
                PartPose.offset(4.0F, 14.0F, 7.0F));
        root.addOrReplaceChild(RIGHT_HIND_SHOE,
                CubeListBuilder.create().texOffs(16, 6).addBox(-1.0F - shift, 8.0F, -1.0F, 4, 2, 4, deform),
                PartPose.offset(-4.0F, 14.0F, 7.0F));

        return LayerDefinition.create(mesh, 32, 16);
    }
}