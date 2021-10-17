package com.rafael.rafaelcraft.entity.model;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rafael.rafaelcraft.entity.EnderBeastEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EnderBeastEntityModel<T extends EnderBeastEntity> extends EntityModel<T>
{


    private final ModelRenderer ender_beast;
    private final ModelRenderer body;
    private final ModelRenderer chest;
    private final ModelRenderer neck;
    private final ModelRenderer left_arm;
    private final ModelRenderer head;
    private final ModelRenderer forehead;
    private final ModelRenderer mouth;
    private final ModelRenderer left_second_arm;
    private final ModelRenderer left_second_arm_r1;
    private final ModelRenderer right_second_arm;
    private final ModelRenderer right_second_arm_r1;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_arm;

    public EnderBeastEntityModel()
    {
        textureWidth = 256;
        textureHeight = 256;

        ender_beast = new ModelRenderer(this);
        ender_beast.setRotationPoint(0.0F, 24.0F, 14.0F);


        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -19.0F, -8.0F);
        ender_beast.addChild(body);
        setRotationAngle(body, 0.829F, 0.0F, 0.0F);
        body.setTextureOffset(0, 104).addBox(-8.0F, -17.0F, 5.0F, 16.0F, 24.0F, 8.0F, 0.0F, false);

        chest = new ModelRenderer(this);
        chest.setRotationPoint(0.0F, 1.0F, 0.0F);
        body.addChild(chest);
        setRotationAngle(chest, 0.2618F, 0.0F, 0.0F);
        chest.setTextureOffset(60, 24).addBox(-12.0F, -34.0F, 6.0F, 24.0F, 24.0F, 12.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, -20.0F, -4.0F);
        chest.addChild(neck);
        setRotationAngle(neck, 0.48F, 0.0F, 0.0F);
        neck.setTextureOffset(44, 0).addBox(-6.0F, -16.0F, 17.0F, 12.0F, 14.0F, 8.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(12.0F, -43.0F, -27.0F);
        ender_beast.addChild(left_arm);
        left_arm.setTextureOffset(96, 86).addBox(0.0F, -2.0F, -3.0F, 8.0F, 45.0F, 8.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -45.0F, -42.0F);
        ender_beast.addChild(head);


        forehead = new ModelRenderer(this);
        forehead.setRotationPoint(0.0F, -2.0F, 2.0F);
        head.addChild(forehead);
        forehead.setTextureOffset(0, 72).addBox(-8.0F, -6.0F, -17.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setRotationPoint(0.0F, 21.0F, 39.0F);
        head.addChild(mouth);
        mouth.setTextureOffset(52, 60).addBox(-9.0F, -19.0F, -57.0F, 18.0F, 6.0F, 20.0F, 0.25F, false);

        left_second_arm = new ModelRenderer(this);
        left_second_arm.setRotationPoint(15.0F, -39.0F, -15.0F);
        ender_beast.addChild(left_second_arm);


        left_second_arm_r1 = new ModelRenderer(this);
        left_second_arm_r1.setRotationPoint(-15.0F, 39.0F, 15.0F);
        left_second_arm.addChild(left_second_arm_r1);
        setRotationAngle(left_second_arm_r1, -1.5708F, 0.0F, 0.0F);
        left_second_arm_r1.setTextureOffset(0, 36).addBox(12.0F, 11.0F, -40.0F, 8.0F, 8.0F, 28.0F, 0.0F, false);

        right_second_arm = new ModelRenderer(this);
        right_second_arm.setRotationPoint(-12.0F, -37.0F, -15.0F);
        ender_beast.addChild(right_second_arm);


        right_second_arm_r1 = new ModelRenderer(this);
        right_second_arm_r1.setRotationPoint(12.0F, 37.0F, 15.0F);
        right_second_arm.addChild(right_second_arm_r1);
        setRotationAngle(right_second_arm_r1, -1.5708F, 0.0F, 0.0F);
        right_second_arm_r1.setTextureOffset(0, 0).addBox(-20.0F, 11.0F, -40.0F, 8.0F, 8.0F, 28.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(-4.1F, -23.0F, 3.0F);
        ender_beast.addChild(right_leg);
        right_leg.setTextureOffset(128, 52).addBox(-3.9F, -1.0F, -5.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(-1.9F, -12.0F, 0.0F);
        ender_beast.addChild(left_leg);
        left_leg.setTextureOffset(120, 0).addBox(1.9F, -12.0F, -2.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(-12.0F, -42.0F, -26.0F);
        ender_beast.addChild(right_arm);
        right_arm.setTextureOffset(64, 86).addBox(-8.0F, -3.0F, -4.0F, 8.0F, 45.0F, 8.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        ender_beast.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.2f * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.2f * limbSwingAmount;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
        this.right_second_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.2f * limbSwingAmount;
        this.left_second_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2f * limbSwingAmount;

    }
}