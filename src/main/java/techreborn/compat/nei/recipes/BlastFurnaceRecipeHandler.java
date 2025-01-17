package techreborn.compat.nei.recipes;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import ic2.core.util.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.api.recipe.machines.BlastFurnaceRecipe;
import techreborn.api.recipe.machines.GrinderRecipe;
import techreborn.client.gui.GuiBlastFurnace;
import techreborn.util.ItemUtils;

import java.awt.*;
import java.util.List;

public class BlastFurnaceRecipeHandler extends GenericRecipeHander implements INeiBaseRecipe {
	@Override
	public void addPositionedStacks(List<PositionedStack> input, List<PositionedStack> outputs, IBaseRecipeType recipeType) {
		int offset = 4;
		if (recipeType.getInputs().size() > 0) {
			PositionedStack pStack = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(0)), 40 - offset, 25 - offset);
			input.add(pStack);
		}

		if (recipeType.getInputs().size() > 1) {
			PositionedStack pStack2 = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(1)), 40 - offset, 43 - offset);
			input.add(pStack2);
		}

		if (recipeType.getOutputsSize() > 0) {
			PositionedStack pStack3 = new PositionedStack(recipeType.getOutput(0), 100 - offset, 35 - offset);
			outputs.add(pStack3);
		}
		
		if (recipeType.getOutputsSize() > 1) {
			PositionedStack pStack4 = new PositionedStack(recipeType.getOutput(1), 118 - offset, 35 - offset);
			outputs.add(pStack4);
		}
	}

	@Override
	public String getRecipeName() {
		return "blastFurnaceRecipe";
	}

	@Override
	public String getGuiTexture() {
		return "techreborn:textures/gui/industrial_blast_furnace.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiBlastFurnace.class;
	}

	@Override
	public INeiBaseRecipe getNeiBaseRecipe() {
		return this;
	}
	
	@Override
	public void loadTransferRects() {
		this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(
				new Rectangle(55, 20, 25, 20), getNeiBaseRecipe().getRecipeName(), new Object[0]));
	}

	@Override
	public void drawBackground(int recipeIndex) {
		super.drawBackground(recipeIndex);
		CachedRecipe recipe = arecipes.get(recipeIndex);
		if (recipe instanceof CachedGenericRecipe) {
			if (((CachedGenericRecipe) recipe).recipie instanceof BlastFurnaceRecipe) {
				BlastFurnaceRecipe blastFurnaceRecipeHandler = (BlastFurnaceRecipe) ((CachedGenericRecipe) recipe).recipie;
				GuiDraw.drawString("Requires " + blastFurnaceRecipeHandler.neededHeat + " heat", 14, 135, -1);
			}
		}

	}
}
