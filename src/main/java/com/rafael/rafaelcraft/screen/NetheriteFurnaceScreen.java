package com.rafael.rafaelcraft.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.rafael.rafaelcraft.RafaelCraft;
import com.rafael.rafaelcraft.container.NetheriteFurnaceContainer;
import com.rafael.rafaelcraft.tileentity.NetheriteFurnaceTile;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.loot.functions.Smelt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class NetheriteFurnaceScreen extends ContainerScreen<NetheriteFurnaceContainer>
{
    private final ResourceLocation GUI = new ResourceLocation(RafaelCraft.MOD_ID, "textures/gui/netherite_furnace_gui.png");

    public NetheriteFurnaceScreen(NetheriteFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        if(container.isLightningStorm())
        {
            this.blit(matrixStack, i + 86, j + 15, 176, 14, 13, 17);
        }

        //if(container.hasSmeltingFuel())
        //{
            //this.blit(matrixStack, i + 57, j + 37, 176, 0, 14, 14);
        //}

    }
}
