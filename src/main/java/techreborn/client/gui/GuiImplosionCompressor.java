package techreborn.client.gui;

import techreborn.client.container.ContainerGrinder;
import techreborn.client.container.ContainerImplosionCompressor;
import techreborn.tiles.TileImplosionCompressor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiImplosionCompressor extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation(
			"techreborn", "textures/gui/implosion_compressor.png");

	TileImplosionCompressor compresser;
	
	public GuiImplosionCompressor(EntityPlayer player, TileImplosionCompressor tilecompresser)
	{
		super(new ContainerImplosionCompressor(tilecompresser, player));
		this.xSize = 176;
		this.ySize = 167;
		compresser = tilecompresser;

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_)
	{
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_,
			int p_146979_2_)
	{
		this.fontRendererObj.drawString("Implosion Compressor", 60, 6, 4210752);
		this.fontRendererObj.drawString(
				I18n.format("container.inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);
	}

}