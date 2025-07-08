// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.tank.gloom.entity.client;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.tank.gloom.entity.animation.GlowToadDefinition;
import static net.tank.gloom.entity.animation.GlowToadDefinition.toad_walk;
import net.tank.gloom.entity.custom.GlowToadEntity;
public class GlowToadModel<T extends Entity> extends  HierarchicalModel<T> {
	private final ModelPart frog;
	private final ModelPart back;
	private final ModelPart head;
	private final ModelPart left_eye;
	private final ModelPart right_eye;
	private final ModelPart body;
	private final ModelPart right_hind;
	private final ModelPart right_leg;
	private final ModelPart left_hind;
	private final ModelPart left_leg;

	public GlowToadModel(ModelPart root) {
		this.frog = root.getChild("frog");
		this.back = this.frog.getChild("back");
		this.head = this.frog.getChild("head");
		this.left_eye = this.head.getChild("left_eye");
		this.right_eye = this.head.getChild("right_eye");
		this.body = this.frog.getChild("body");
		this.right_hind = this.frog.getChild("right_hind");
		this.right_leg = this.frog.getChild("right_leg");
		this.left_hind = this.frog.getChild("left_hind");
		this.left_leg = this.frog.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frog = partdefinition.addOrReplaceChild("frog", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 33.0F, 10.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition back = frog.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 44).addBox(-8.0F, -11.0F, -9.0F, 14.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -9.0F, 11.0F));

		PartDefinition head = frog.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -15.0F, -1.0F, 13.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -9.0F, 11.0F));

		PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(12, 55).addBox(1.0F, -15.0F, 3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, 7.0F));

		PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 55).addBox(-6.0F, -15.0F, 3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.0F, 7.0F));

		PartDefinition body = frog.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -11.0F, -8.0F, 16.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -10.0F, 13.0F));

		PartDefinition right_hind = frog.addOrReplaceChild("right_hind", CubeListBuilder.create().texOffs(55, 55).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(53, 28).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -14.0F, 8.0F));

		PartDefinition right_leg = frog.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(53, 34).addBox(-4.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(37, 45).addBox(-4.0F, 4.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -14.0F, 15.0F));

		PartDefinition left_hind = frog.addOrReplaceChild("left_hind", CubeListBuilder.create().texOffs(37, 51).addBox(-7.0F, -2.0F, 1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(55, 41).addBox(-6.9F, -6.0F, 1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 5.0F));

		PartDefinition left_leg = frog.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(53, 22).addBox(-9.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(55, 48).addBox(-9.0F, -5.0F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -9.0F, 12.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
       		 this.animateWalk(GlowToadDefinition.toad_walk, limbSwing, limbSwingAmount, 2.5f, 2.5f);
			this.animate(((GlowToadEntity) entity).idleAnimationState, GlowToadDefinition.toad_idle, ageInTicks, 1.0f);

	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = -pHeadPitch * ((float)Math.PI / 180F);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		frog.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart root() {
		return frog;
	}

}