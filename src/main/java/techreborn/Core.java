package techreborn;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.lang3.time.StopWatch;
import techreborn.achievement.TRAchievements;
import techreborn.api.recipe.RecipeHandler;
import techreborn.client.GuiHandler;
import techreborn.command.TechRebornDevCommand;
import techreborn.compat.CompatManager;
import techreborn.compat.recipes.RecipeManager;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;
import techreborn.init.ModFluids;
import techreborn.init.ModItems;
import techreborn.init.ModRecipes;
import techreborn.lib.ModInfo;
import techreborn.packets.PacketHandler;
import techreborn.proxies.CommonProxy;
import techreborn.util.LogHelper;
import techreborn.world.TROreGen;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import erogenousbeef.coreTR.multiblock.MultiblockEventHandler;
import erogenousbeef.coreTR.multiblock.MultiblockServerTickHandler;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, dependencies = ModInfo.MOD_DEPENDENCUIES, guiFactory = ModInfo.GUI_FACTORY_CLASS)
public class Core {
	public static ConfigTechReborn config;

	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.Instance
	public static Core INSTANCE;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event){
		INSTANCE = this;
		String path = event.getSuggestedConfigurationFile().getAbsolutePath()
				.replace(ModInfo.MOD_ID, "TechReborn");

		config = ConfigTechReborn.initialize(new File(path));
		LogHelper.info("PreInitialization Complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		// Register ModBlocks
		ModBlocks.init();
		// Register Fluids
		ModFluids.init();
		// Register ModItems
		ModItems.init();
		// Recipes
        StopWatch watch = new StopWatch();
        watch.start();
		ModRecipes.init();
        LogHelper.all(watch + " : main recipes");
        watch.stop();
		//Client only init, needs to be done before parts system
		proxy.init();
		// Compat
		CompatManager.init(event);
		// WorldGen
		GameRegistry.registerWorldGenerator(new TROreGen(), 0);
		// Register Gui Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
		// packets
		PacketHandler.setChannels(NetworkRegistry.INSTANCE.newChannel(
				ModInfo.MOD_ID + "_packets", new PacketHandler()));
		// Achievements
		TRAchievements.init();
		// Multiblock events
		MinecraftForge.EVENT_BUS.register(new MultiblockEventHandler());
		FMLCommonHandler.instance().bus().register(new MultiblockServerTickHandler());

		LogHelper.info("Initialization Complete");
	}

	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event){
		// Has to be done here as Buildcraft registers there recipes late
        StopWatch watch = new StopWatch();
        watch.start();
//		RecipeManager.init();
        LogHelper.all(watch + " : main recipes");
        watch.stop();
        //Has to be done after the recipes have been added
        CompatManager.postInit(event);

		LogHelper.info(RecipeHandler.recipeList.size() + " recipes loaded");
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event){
		event.registerServerCommand(new TechRebornDevCommand());
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent cfgChange){
		if (cfgChange.modID.equals("TechReborn")) {
			ConfigTechReborn.Configs();
		}
	}
}
