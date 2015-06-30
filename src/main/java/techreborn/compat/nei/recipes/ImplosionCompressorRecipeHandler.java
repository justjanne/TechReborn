package techreborn.compat.nei.recipes;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.client.gui.GuiImplosionCompressor;
import techreborn.util.ItemUtils;

import java.awt.Rectangle;
import java.util.List;

public class ImplosionCompressorRecipeHandler extends GenericRecipeHander implements INeiBaseRecipe {
	@Override
	public void addPositionedStacks(List<PositionedStack> input, List<PositionedStack> outputs, IBaseRecipeType recipeType) {
		int offset = 4;
		if (recipeType.getInputs().size() > 0) {
			PositionedStack pStack = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(0)), 37 - offset, 26 - offset);
			input.add(pStack);
		}

		if (recipeType.getInputs().size() > 1) {
			PositionedStack pStack2 = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(1)), 37 - offset, 44 - offset);
			input.add(pStack2);
		}

		if (recipeType.getOutputsSize() > 0) {
			PositionedStack pStack3 = new PositionedStack(recipeType.getOutput(0), 93 - offset, 35 - offset);
			outputs.add(pStack3);
		}

		if (recipeType.getOutputsSize() > 1) {
			PositionedStack pStack4 = new PositionedStack(recipeType.getOutput(1), 111 - offset, 35 - offset);
			outputs.add(pStack4);
		}
	}

	@Override
	public String getRecipeName() {
		return "implosionCompressorRecipe";
	}

	@Override
	public String getGuiTexture() {
		return "techreborn:textures/gui/implosion_compressor.png";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiImplosionCompressor.class;
	}

	@Override
	public INeiBaseRecipe getNeiBaseRecipe() {
		return this;
	}
	
	@Override
	public void loadTransferRects() {
		this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(
				new Rectangle(50, 20, 25, 20), getNeiBaseRecipe().getRecipeName(), new Object[0]));
	}
}
