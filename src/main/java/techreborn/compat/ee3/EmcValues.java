package techreborn.compat.ee3;

import com.pahimar.ee3.api.exchange.RecipeRegistryProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.api.recipe.RecipeHandler;
import techreborn.compat.ICompatModule;

public class EmcValues implements ICompatModule {

	@Override
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Override
	public void init(FMLInitializationEvent event) {
		for (IBaseRecipeType recipeType : RecipeHandler.recipeList) {
			if (recipeType.getOutputsSize() == 1) {
				RecipeRegistryProxy.addRecipe(recipeType.getOutput(0), recipeType.getInputs());
			}
		}
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {

	}
}
