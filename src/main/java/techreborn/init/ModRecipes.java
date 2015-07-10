package techreborn.init;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.ArrayUtils;
import techreborn.api.recipe.RecipeHandler;
import techreborn.api.recipe.machines.AlloySmelterRecipe;
import techreborn.api.recipe.machines.AssemblingMachineRecipe;
import techreborn.api.recipe.machines.BlastFurnaceRecipe;
import techreborn.api.recipe.machines.CentrifugeRecipe;
import techreborn.api.recipe.machines.ChemicalReactorRecipe;
import techreborn.api.recipe.machines.GrinderRecipe;
import techreborn.api.recipe.machines.ImplosionCompressorRecipe;
import techreborn.api.recipe.machines.IndustrialElectrolyzerRecipe;
import techreborn.api.recipe.machines.IndustrialSawmillRecipe;
import techreborn.api.recipe.machines.LatheRecipe;
import techreborn.api.recipe.machines.PlateCuttingMachineRecipe;
import techreborn.blocks.BlockOre;
import techreborn.blocks.BlockStorage;
import techreborn.blocks.BlockStorage2;
import techreborn.config.ConfigTechReborn;
import techreborn.items.ItemCells;
import techreborn.items.ItemDusts;
import techreborn.items.ItemDustsSmall;
import techreborn.items.ItemDustsTiny;
import techreborn.items.ItemGems;
import techreborn.items.ItemIngots;
import techreborn.items.ItemNuggets;
import techreborn.items.ItemParts;
import techreborn.items.ItemPlates;
import techreborn.items.ItemRods;
import techreborn.util.CraftingHelper;
import techreborn.util.LogHelper;

public class ModRecipes {
	public static ConfigTechReborn config;

	public static void init() {
		addShapelessRecipes();
		addGeneralShapedRecipes();
		addHammerRecipes();
		addMachineRecipes();

		addSmeltingRecipes();
		addUUrecipes();

        addAlloySmelterRecipes();
        addLatheRecipes();
        addPlateCuttingMachineRecipes();
		addAssemblingMachineRecipes();
		addIndustrialCentrifugeRecipes();
		addChemicalReactorRecipes();
		addIndustrialElectrolyzerRecipes();

        addIndustrialSawmillRecipes();
        addBlastFurnaceRecipes();
		addIndustrialGrinderRecipes();
		addImplosionCompressorRecipes();
	}

	static void addGeneralShapedRecipes() {

		// Storage Blocks
		for(String name : ArrayUtils.addAll(BlockStorage.types, BlockStorage2.types))	{
			CraftingHelper.addShapedOreRecipe(BlockStorage.getStorageBlockByName(name),
					"AAA", "AAA", "AAA",
					'A', "ingot" + name.substring(0, 1).toUpperCase() + name.substring(1));
		}

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.storage, 1, 3),
				 "AAA", "AAA", "AAA",
					'A', "gemSapphire");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.storage, 1, 4),
				 "AAA", "AAA", "AAA",
					'A', "gemRuby");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.storage, 1, 5),
				 "AAA", "AAA", "AAA",
					'A', "gemGreenSapphire");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 40),
				"PLP", "RGB", "PYP",
				'P', "plateAluminum",
				'L', "dyeLime",
				'R', "dyeRed",
				'G', "paneGlass",
				'B', "dyeBlue",
				'Y', Items.glowstone_dust);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 4, 6),
				"EEE", "EAE", "EEE",
				'E', "gemEmerald",
				'A', IC2Items.getItem("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 7),
				"AGA", "RPB", "ASA",
				'A', "ingotAluminium",
				'G', "dyeGreen",
				'R', "dyeRed",
				'P', "paneGlass",
				'B', "dyeBlue",
				'S', Items.glowstone_dust);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 4, 8),
				"DSD", "S S", "DSD",
				'D', "dustDiamond",
				'S', "ingotSteel");

		CraftingHelper.addShapedOreRecipe(
				new ItemStack(ModItems.parts, 16, 13),
				"CSC", "SCS", "CSC",
				'S', "ingotSteel",
				'C', IC2Items.getItem("electronicCircuit"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 2, 14),
				"TST", "SBS", "TST",
				'S', "ingotSteel",
				'T', "ingotTungsten",
				'B', "blockSteel");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 15),
				"AAA", "AMA", "AAA",
				'A', "ingotAluminium",
				'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 16),
				"AAA", "AMA", "AAA",
				'A', "ingotBronze",
				'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 17),
				"AAA", "AMA", "AAA",
				'A', "ingotSteel",
				'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 18),
				"AAA", "AMA", "AAA",
				'A', "ingotTitanium",
				'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.parts, 1, 19),
				"AAA", "AMA", "AAA",
				'A', "ingotBrass",
				'M', new ItemStack(ModItems.parts, 1, 13));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("energyFlowCircuit", 4),
				"ATA", "LIL", "ATA",
				'T', "plateTungsten",
				'I', "plateIridium",
				'A', IC2Items.getItem("advancedCircuit"),
				'L', IC2Items.getItem("lapotronCrystal"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Supercondensator),
				"EOE", "SAS", "EOE",
				'E', ItemParts.getPartByName("energyFlowCircuit"),
				'O', ModItems.lapotronicOrb,
				'S', ItemParts.getPartByName("superconductor"),
				'A', ModBlocks.HighAdvancedMachineBlock);

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("superconductor", 4),
				"CCC", "TIT", "EEE",
				'E', ItemParts.getPartByName("energyFlowCircuit"),
				'C', ItemParts.getPartByName("heliumCoolantSimple"),
				'T', "ingotTungsten",
				'I', IC2Items.getItem("iridiumPlate"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("diamondSawBlade"),
				"DSD", "S S", "DSD",
				'S', "plateSteel",
				'D', "dustDiamond");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lapotronicOrb),
				"LLL", "LPL", "LLL",
				'L', IC2Items.getItem("lapotronCrystal"),
				'P', IC2Items.getItem("iridiumPlate"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.lapotronicOrb),
				"LLL", "LPL", "LLL",
				'L', IC2Items.getItem("lapotronCrystal"),
				'P', IC2Items.getItem("iridiumPlate"));

		CraftingHelper.addShapedOreRecipe(ItemParts.getPartByName("tungstenGrindingHead", 2),
				"TST", "SBS", "TST",
				'T', "plateTungsten",
				'S', "plateSteel",
				'B', "blockSteel");

		LogHelper.info("Shapped Recipes Added");
	}

	static void addShapelessRecipes() {

		for(String name : ArrayUtils.addAll(BlockStorage.types, BlockStorage2.types))	{
			try {
				CraftingHelper.addShapedOreRecipe(ItemIngots.getIngotByName(name, 9),
						"A  ", "   ", "   ",
						'A', "block" + name.substring(0, 1).toUpperCase() + name.substring(1));
			}
			catch (Exception e) {
				//Iridium reinforced tungstensteel, etc.
			}
		}

		for(String name : ItemDustsSmall.types)
		{
			CraftingHelper.addShapedOreRecipe(ItemDustsSmall.getSmallDustByName(name, 4),
					"A  ", "   ", "   ",
					'A', ItemDusts.getDustByName(name));
			CraftingHelper.addShapedOreRecipe(ItemDustsTiny.getTinyDustByName(name, 9),
					" A ", "   ", "   ",
					'A', ItemDusts.getDustByName(name));
			CraftingHelper.addShapedOreRecipe(ItemDusts.getDustByName(name, 1),
					"AA ", "AA ", "   ",
					'A', ItemDustsSmall.getSmallDustByName(name));
			CraftingHelper.addShapedOreRecipe(ItemDusts.getDustByName(name, 1),
					"AAA", "AAA", "AAA",
					'A', ItemDustsTiny.getTinyDustByName(name));
		}

		CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.gems, 9, 1), "blockSapphire");
		CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.gems, 9, 0), "blockRuby");
		CraftingHelper.addShapelessOreRecipe(new ItemStack(ModItems.gems, 9, 2), "blockGreenSapphire");

		LogHelper.info("Shapless Recipes Added");
	}

	static void addMachineRecipes()
	{
		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.industrialSawmill),
				"PAP",
				"SSS",
				"ACA",
				'P', IC2Items.getItem("pump"),
				'A', IC2Items.getItem("advancedCircuit"),
				'S', ItemParts.getPartByName("diamondSawBlade"),
				'C', IC2Items.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ComputerCube),
				"DME", "MAM", "EMD",
				'E', ItemParts.getPartByName("energyFlowCircuit"),
				'D', ItemParts.getPartByName("dataOrb"),
				'M', ItemParts.getPartByName("computerMonitor"),
				'A', IC2Items.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.quantumTank),
				"EPE", "PCP", "EPE",
				'P', "platePlatinum",
				'E', "circuitMaster",
				'C', ModBlocks.quantumChest);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.digitalChest),
				"PPP", "PDP", "PCP",
				'P', "plateAluminum",
				'D', ItemParts.getPartByName("dataOrb"),
				'C', ItemParts.getPartByName("computerMonitor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.digitalChest),
				"PPP", "PDP", "PCP",
				'P', "plateSteel",
				'D', ItemParts.getPartByName("dataOrb"),
				'C', ItemParts.getPartByName("computerMonitor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MatterFabricator),
				"ETE", "AOA", "ETE",
				'E', ItemParts.getPartByName("energyFlowCircuit"),
				'T', IC2Items.getItem("teleporter"),
				'A', ModBlocks.HighAdvancedMachineBlock,
				'O', ModItems.lapotronicOrb);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.thermalGenerator),
				"III", "IHI", "CGC",
				'I', "plateInvar",
				'H', IC2Items.getItem("reinforcedGlass"),
				'C', "circuitBasic",
				'G', IC2Items.getItem("geothermalGenerator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.thermalGenerator),
				"AAA", "AHA", "CGC",
				'A', "plateAluminum",
				'H', IC2Items.getItem("reinforcedGlass"),
				'C', "circuitBasic",
				'G', IC2Items.getItem("geothermalGenerator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Gasturbine),
				"IAI", "WGW", "IAI",
				'I', "plateInvar",
				'A', IC2Items.getItem("advancedCircuit"),
				'W', IC2Items.getItem("windMill"),
				'G', IC2Items.getItem("reinforcedGlass"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Gasturbine),
				"IAI", "WGW", "IAI",
				'I', "plateAluminum",
				'A', IC2Items.getItem("advancedCircuit"),
				'W', IC2Items.getItem("windMill"),
				'G', IC2Items.getItem("reinforcedGlass"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Semifluidgenerator),
				"III", "IHI", "CGC",
				'I', "plateIron",
				'H', IC2Items.getItem("reinforcedGlass"),
				'C', "circuitBasic",
				'G', IC2Items.getItem("generator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Semifluidgenerator),
				"AAA", "AHA", "CGC",
				'A', "plateAluminum",
				'H', IC2Items.getItem("reinforcedGlass"),
				'C', "circuitBasic",
				'G', IC2Items.getItem("generator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.DieselGenerator),
				"III", "I I", "CGC",
				'I', "plateIron",
				'C', "circuitBasic",
				'G', IC2Items.getItem("generator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.DieselGenerator),
				"AAA", "A A", "CGC",
				'A', "plateAluminum",
				'C', "circuitBasic",
				'G', IC2Items.getItem("generator"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MagicalAbsorber),
				"CSC", "IBI", "CAC",
				'C', "circuitMaster",
				'S', "craftingSuperconductor",
				'B', Blocks.beacon,
				'A', ModBlocks.Magicenergeyconverter,
				'I', IC2Items.getItem("iridiumPlate"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Magicenergeyconverter),
				"CTC", "PBP", "CLC",
				'C', "circuitAdvanced",
				'P', "platePlatinum",
				'B', Blocks.beacon,
				'L', IC2Items.getItem("lapotronCrystal"),
				'T', IC2Items.getItem("teleporter"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Dragoneggenergysiphoner),
				"CTC", "ISI", "CBC",
				'I', IC2Items.getItem("iridiumPlate"),
				'C', "circuitMaster",
				'B', "batteryUltimate",
				'S', ModBlocks.Supercondensator,
				'T', IC2Items.getItem("teleporter"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.centrifuge),
				"SCS", "BEB", "SCS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'B', IC2Items.getItem("advancedMachine"),
				'E', IC2Items.getItem("extractor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.IndustrialElectrolyzer),
				"SXS", "CEC", "SMS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'X', IC2Items.getItem("extractor"),
				'E', IC2Items.getItem("electrolyzer"),
				'M', IC2Items.getItem("magnetizer"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.BlastFurnace),
				"CHC", "HBH", "FHF",
				'H', new ItemStack(ModItems.parts, 1, 17),
				'C', "circuitAdvanced",
				'B', IC2Items.getItem("advancedMachine"),
				'F', IC2Items.getItem("inductionFurnace"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Grinder),
				"ECP", "GGG", "CBC",
				'E', ModBlocks.IndustrialElectrolyzer,
				'P', IC2Items.getItem("pump"),
				'C', "circuitAdvanced",
				'B', IC2Items.getItem("advancedMachine"),
				'G', "craftingGrinder");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ImplosionCompressor),
				"ABA", "CPC", "ABA",
				'A', IC2Items.getItem("advancedAlloy"),
				'C', "circuitAdvanced",
				'B', IC2Items.getItem("advancedMachine"),
				'P', IC2Items.getItem("compressor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.VacuumFreezer),
				"SPS", "CGC", "SPS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'G', IC2Items.getItem("reinforcedGlass"),
				'P', IC2Items.getItem("pump"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Distillationtower),
				"CMC", "PBP", "EME",
				'E', ModBlocks.IndustrialElectrolyzer,
				'M', "circuitMaster",
				'B', IC2Items.getItem("advancedMachine"),
				'C', ModBlocks.centrifuge,
				'P', IC2Items.getItem("pump"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.AlloyFurnace),
				"III", "F F", "III",
				'I', "plateIron",
				'F', IC2Items.getItem("ironFurnace"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.AlloySmelter),
				"IHI", "CFC", "IHI",
				'I', "plateInvar",
				'C', "circuitBasic",
				'H', new ItemStack(ModItems.parts, 1, 17),
				'F', ModBlocks.AlloyFurnace);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.AssemblyMachine),
				"CPC", "SBS", "CSC",
				'S', "plateSteel",
				'C', "circuitBasic",
				'B', IC2Items.getItem("machine"),
				'P', "craftingPiston");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ChemicalReactor),
				"IMI", "CPC", "IEI",
				'I', "plateInvar",
				'C', "circuitAdvanced",
				'M', IC2Items.getItem("magnetizer"),
				'P', IC2Items.getItem("compressor"),
				'E', IC2Items.getItem("extractor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ChemicalReactor),
				"AMA", "CPC", "AEA",
				'A', "plateAluminum",
				'C', "circuitAdvanced",
				'M', IC2Items.getItem("magnetizer"),
				'P', IC2Items.getItem("compressor"),
				'E', IC2Items.getItem("extractor"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.lathe),
				"SLS", "GBG", "SCS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'G', "gearSteel",
				'B', IC2Items.getItem("advancedMachine"),
				'L', IC2Items.getItem("LathingTool"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.platecuttingmachine),
				"SCS", "GDG", "SBS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'G', "gearSteel",
				'B', IC2Items.getItem("advancedMachine"),
				'D', new ItemStack(ModItems.parts, 1, 9));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.RollingMachine),
				"PCP", "MBM", "PCP",
				'P', "craftingPiston",
				'C', "circuitAdvanced",
				'M', IC2Items.getItem("compressor"),
				'B', IC2Items.getItem("machine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ElectricCraftingTable),
				"ITI", "IBI", "ICI",
				'I', "plateIron",
				'C', "circuitAdvanced",
				'T', "crafterWood",
				'B', IC2Items.getItem("machine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ElectricCraftingTable),
				"ATA", "ABA", "ACA",
				'A', "plateAluminum",
				'C', "circuitAdvanced",
				'T', "crafterWood",
				'B', IC2Items.getItem("machine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.ChunkLoader),
				"SCS", "CMC", "SCS",
				'S', "plateSteel",
				'C', "circuitMaster",
				'M', new ItemStack(ModItems.parts, 1, 39));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Lesu),
				" L ", "CBC", " M ",
				'L', IC2Items.getItem("lvTransformer"),
				'C', "circuitAdvanced",
				'M', IC2Items.getItem("mvTransformer"),
				'B', ModBlocks.LesuStorage);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.LesuStorage),
				"LLL", "LCL", "LLL",
				'L', "blockLapis",
				'C', "circuitBasic");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Woodenshelf),
				"WWW", "A A", "WWW",
				'W', "plankWood",
				'A', "plateAluminum");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.Metalshelf),
				"III", "A A", "III",
				'I', "plateIron",
				'A', "plateAluminum");

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.HighAdvancedMachineBlock),
				"CTC", "TBT", "CTC",
				'C', "plateChrome",
				'T', "plateTitanium",
				'B', IC2Items.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 0),
				"III", "CBC", "III",
				'I', "plateIron",
				'C', "circuitBasic",
				'B', IC2Items.getItem("machine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 1),
				"SSS", "CBC", "SSS",
				'S', "plateSteel",
				'C', "circuitAdvanced",
				'B', IC2Items.getItem("advancedMachine"));

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.MachineCasing, 4, 2),
				"HHH", "CBC", "HHH",
				'H', "plateChrome",
				'C', "circuitElite",
				'B', ModBlocks.HighAdvancedMachineBlock);

		CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.quantumChest),
				"DCD", "ATA", "DQD",
				'D', ItemParts.getPartByName("dataOrb"),
				'C', ItemParts.getPartByName("computerMonitor"),
				'A', ModBlocks.HighAdvancedMachineBlock,
				'Q', ModBlocks.digitalChest,
				'T', IC2Items.getItem("teleporter"));
	}

	static void addSmeltingRecipes() {
		GameRegistry.addSmelting(ItemDusts.getDustByName("iron", 1), new ItemStack(Items.iron_ingot), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("gold", 1), new ItemStack(Items.gold_ingot), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("copper", 1), IC2Items.getItem("copperIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("tin", 1), IC2Items.getItem("tinIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("bronze", 1), IC2Items.getItem("bronzeIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("lead", 1), IC2Items.getItem("leadIngot"), 1F);
		GameRegistry.addSmelting(ItemDusts.getDustByName("silver", 1), IC2Items.getItem("silverIngot"), 1F);

		LogHelper.info("Smelting Recipes Added");
	}

	static void addHammerRecipes(){
		ItemStack hammerIron = new ItemStack(ModItems.hammerIron, 1, OreDictionary.WILDCARD_VALUE);
		ItemStack hammerDiamond = new ItemStack(ModItems.hammerDiamond, 1, OreDictionary.WILDCARD_VALUE);

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plate, 1, 13), hammerIron, new ItemStack(Items.iron_ingot));

	}

	static void addAlloySmelterRecipes(){
        //Bronze
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemIngots.getIngotByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemDusts.getDustByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemIngots.getIngotByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemDusts.getDustByName("tin", 1), ItemIngots.getIngotByName("bronze", 4), 200, 16));

        //Electrum
        RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1), ItemIngots.getIngotByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1), ItemDusts.getDustByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("gold", 1), ItemIngots.getIngotByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("gold", 1), ItemDusts.getDustByName("silver", 1), ItemIngots.getIngotByName("electrum", 2), 200, 16));

        //Invar
        RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 2), ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 2), ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("iron", 2), ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("invar", 3), 200, 16));

        //Cupronickel
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 1), ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 1), ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 1), ItemIngots.getIngotByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 1), ItemDusts.getDustByName("nickel", 1), ItemIngots.getIngotByName("cupronickel", 2), 200, 16));

        //Nichrome
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("chrome", 1), ItemIngots.getIngotByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("chrome", 1), ItemDusts.getDustByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("chrome", 1), ItemIngots.getIngotByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("chrome", 1), ItemDusts.getDustByName("nickel", 4), ItemIngots.getIngotByName("nichrome", 5), 200, 16));

        //Magnalium
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("magnesium", 1), ItemIngots.getIngotByName("aluminum", 4), ItemIngots.getIngotByName("magnalium", 3), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("magnesium", 1), ItemDusts.getDustByName("aluminum", 4), ItemIngots.getIngotByName("magnalium", 3), 200, 16));

        //Battery Alloy
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("lead", 4), ItemIngots.getIngotByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("lead", 4), ItemDusts.getDustByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("lead", 4), ItemIngots.getIngotByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));
        RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("lead", 4), ItemDusts.getDustByName("antimony", 1), ItemIngots.getIngotByName("batteryAlloy", 5), 200, 16));

        //Brass
        if(OreDictionary.doesOreNameExist("ingotBrass")) {
            ItemStack brassStack = OreDictionary.getOres("ingotBrass").get(0);
            brassStack.stackSize = 4;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemIngots.getIngotByName("zinc", 1), brassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemDusts.getDustByName("zinc", 1), brassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemIngots.getIngotByName("zinc", 1), brassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemDusts.getDustByName("zinc", 1), brassStack, 200, 16));
        }

        //Red Alloy
        if(OreDictionary.doesOreNameExist("ingotRedAlloy")) {
            ItemStack redAlloyStack = OreDictionary.getOres("ingotRedAlloy").get(0);
            redAlloyStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 4), ItemIngots.getIngotByName("copper", 1), redAlloyStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 4), new ItemStack(Items.iron_ingot, 1), redAlloyStack, 200, 16));
        }

        //Blue Alloy
        if(OreDictionary.doesOreNameExist("ingotBlueAlloy")) {
            ItemStack blueAlloyStack = OreDictionary.getOres("ingotBlueAlloy").get(0);
            blueAlloyStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("teslatite", 4), ItemIngots.getIngotByName("silver", 1), blueAlloyStack, 200, 16));
        }

        //Blue Alloy
        if(OreDictionary.doesOreNameExist("ingotPurpleAlloy") && OreDictionary.doesOreNameExist("dustInfusedTeslatite")) {
            ItemStack purpleAlloyStack = OreDictionary.getOres("ingotPurpleAlloy").get(0);
            purpleAlloyStack.stackSize = 1;
            ItemStack infusedTeslatiteStack = OreDictionary.getOres("ingotPurpleAlloy").get(0);
            infusedTeslatiteStack.stackSize = 8;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("redAlloy", 1), ItemIngots.getIngotByName("blueAlloy", 1), purpleAlloyStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.gold_ingot, 1), infusedTeslatiteStack, purpleAlloyStack, 200, 16));
        }

        //Aluminum Brass
        if(OreDictionary.doesOreNameExist("ingotAluminumBrass")) {
            ItemStack aluminumBrassStack = OreDictionary.getOres("ingotAluminumBrass").get(0);
            aluminumBrassStack.stackSize = 4;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemIngots.getIngotByName("aluminum", 1), aluminumBrassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemIngots.getIngotByName("copper", 3), ItemDusts.getDustByName("aluminum", 1), aluminumBrassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemIngots.getIngotByName("aluminum", 1), aluminumBrassStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("copper", 3), ItemDusts.getDustByName("aluminum", 1), aluminumBrassStack, 200, 16));
        }

        //Manyullyn
        if(OreDictionary.doesOreNameExist("ingotManyullyn") && OreDictionary.doesOreNameExist("ingotCobalt") && OreDictionary.doesOreNameExist("ingotArdite")) {
            ItemStack manyullynStack = OreDictionary.getOres("ingotManyullyn").get(0);
            manyullynStack.stackSize = 1;
            ItemStack cobaltStack = OreDictionary.getOres("ingotCobalt").get(0);
            cobaltStack.stackSize = 1;
            ItemStack arditeStack = OreDictionary.getOres("ingotArdite").get(0);
            arditeStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(cobaltStack, arditeStack, manyullynStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(cobaltStack, ItemDusts.getDustByName("ardite", 1), manyullynStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("cobalt", 1), arditeStack, manyullynStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(ItemDusts.getDustByName("cobalt", 1), ItemDusts.getDustByName("ardite", 1), manyullynStack, 200, 16));
        }

        //Conductive Iron
        if(OreDictionary.doesOreNameExist("ingotConductiveIron")) {
            ItemStack conductiveIronStack = OreDictionary.getOres("ingotConductiveIron").get(0);
            conductiveIronStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 1), new ItemStack(Items.iron_ingot, 1), conductiveIronStack, 200, 16));
        }

        //Redstone Alloy
        if(OreDictionary.doesOreNameExist("ingotRedstoneAlloy") && OreDictionary.doesOreNameExist("itemSilicon")) {
            ItemStack redstoneAlloyStack = OreDictionary.getOres("ingotRedstoneAlloy").get(0);
            redstoneAlloyStack.stackSize = 1;
            ItemStack siliconStack = OreDictionary.getOres("itemSilicon").get(0);
            siliconStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.redstone, 1), siliconStack, redstoneAlloyStack, 200, 16));
        }

        //Pulsating Iron
        if(OreDictionary.doesOreNameExist("ingotPhasedIron")) {
            ItemStack pulsatingIronStack = OreDictionary.getOres("ingotPhasedIron").get(0);
            pulsatingIronStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.ender_pearl, 1), pulsatingIronStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Items.iron_ingot, 1), ItemDusts.getDustByName("enderPearl", 1), pulsatingIronStack, 200, 16));
        }

        //Vibrant Alloy
        if(OreDictionary.doesOreNameExist("ingotEnergeticAlloy") && OreDictionary.doesOreNameExist("ingotPhasedGold")) {
            ItemStack energeticAlloyStack = OreDictionary.getOres("ingotEnergeticAlloy").get(0);
            energeticAlloyStack.stackSize = 1;
            ItemStack vibrantAlloyStack = OreDictionary.getOres("ingotPhasedGold").get(0);
            vibrantAlloyStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(energeticAlloyStack, new ItemStack(Items.ender_pearl, 1), vibrantAlloyStack, 200, 16));
            RecipeHandler.addRecipe(new AlloySmelterRecipe(energeticAlloyStack, ItemDusts.getDustByName("enderPearl", 1), vibrantAlloyStack, 200, 16));
        }

        //Soularium
        if(OreDictionary.doesOreNameExist("ingotSoularium")) {
            ItemStack soulariumStack = OreDictionary.getOres("ingotSoularium").get(0);
            soulariumStack.stackSize = 1;
            RecipeHandler.addRecipe(new AlloySmelterRecipe(new ItemStack(Blocks.soul_sand, 1), new ItemStack(Items.gold_ingot, 1), soulariumStack, 200, 16));
        }

    }

	static void addLatheRecipes() {
		//Metal Rods
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("brass", 1), ItemRods.getRodByName("brass", 1), 300, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("bronze", 1), ItemRods.getRodByName("bronze", 1), 380, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("copper", 1), ItemRods.getRodByName("copper", 1), 300, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("electrum", 1), ItemRods.getRodByName("electrum", 1), 740, 16));
        RecipeHandler.addRecipe(new LatheRecipe(new ItemStack(Items.gold_ingot), ItemRods.getRodByName("gold", 1), 980, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("invar", 1), ItemRods.getRodByName("invar", 1), 280, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("iridium", 1), ItemRods.getRodByName("iridium", 1), 960, 16));
        RecipeHandler.addRecipe(new LatheRecipe(new ItemStack(Items.iron_ingot), ItemRods.getRodByName("iron", 1), 280, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("lead", 1), ItemRods.getRodByName("lead", 1), 1020, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("nickel", 1), ItemRods.getRodByName("nickel", 1), 280, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("platinum", 1), ItemRods.getRodByName("platinum", 1), 960, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("silver", 1), ItemRods.getRodByName("silver", 1), 520, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("steel", 1), ItemRods.getRodByName("steel", 1), 280, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("tin", 1), ItemRods.getRodByName("tin", 1), 580, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("titanium", 1), ItemRods.getRodByName("titanium", 1), 240, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemIngots.getIngotByName("tungstensteel", 1), ItemRods.getRodByName("tungstensteel", 1), 580, 16));

        //Laser Focus
        RecipeHandler.addRecipe(new LatheRecipe(ItemPlates.getPlateByName("ruby", 1), ItemParts.getPartByName("laserFocus", 1), 10, 16));
        RecipeHandler.addRecipe(new LatheRecipe(ItemPlates.getPlateByName("redGarnet", 1), ItemParts.getPartByName("laserFocus", 1), 10, 16));
	}

    static void addPlateCuttingMachineRecipes() {
        //Storage Blocks
        if(OreDictionary.doesOreNameExist("blockAluminum")) {
            ItemStack blockStack = OreDictionary.getOres("blockAluminum").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("aluminum", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockBrass")) {
            ItemStack blockStack = OreDictionary.getOres("blockBrass").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("brass", 9), 200, 116));
        }
        if(OreDictionary.doesOreNameExist("blockBronze")) {
            ItemStack blockStack = OreDictionary.getOres("blockBronze").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("bronze", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockCoal")) {
            ItemStack blockStack = OreDictionary.getOres("blockCoal").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("carbon", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockChrome")) {
            ItemStack blockStack = OreDictionary.getOres("blockChrome").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("chrome", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockCopper")) {
            ItemStack blockStack = OreDictionary.getOres("blockCopper").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("copper", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockDiamond")) {
            ItemStack blockStack = OreDictionary.getOres("blockDiamond").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("diamond", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockElectrum")) {
            ItemStack blockStack = OreDictionary.getOres("blockElectrum").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("electrum", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockEmerald")) {
            ItemStack blockStack = OreDictionary.getOres("blockEmerald").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("emerald", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockGold")) {
            ItemStack blockStack = OreDictionary.getOres("blockGold").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("gold", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockInvar")) {
            ItemStack blockStack = OreDictionary.getOres("blockInvar").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("invar", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockIridium")) {
            ItemStack blockStack = OreDictionary.getOres("blockIridium").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("iridium", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockIron")) {
            ItemStack blockStack = OreDictionary.getOres("blockIron").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("iron", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockLapis")) {
            ItemStack blockStack = OreDictionary.getOres("blockLapis").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("lapis", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockLead")) {
            ItemStack blockStack = OreDictionary.getOres("blockLead").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("lead", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockNickel")) {
            ItemStack blockStack = OreDictionary.getOres("blockNickel").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("nickel", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockOsmium")) {
            ItemStack blockStack = OreDictionary.getOres("blockOsmium").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("osmium", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockPeridot")) {
            ItemStack blockStack = OreDictionary.getOres("blockPeridot").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("peridot", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockPlatinum")) {
            ItemStack blockStack = OreDictionary.getOres("blockPlatinum").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("platinum", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockRedGarnet")) {
            ItemStack blockStack = OreDictionary.getOres("blockRedGarnet").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("redGarnet", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("BlockRedstone")) {
            ItemStack blockStack = OreDictionary.getOres("blockRedstone").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("redstone", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockRuby")) {
            ItemStack blockStack = OreDictionary.getOres("blockRuby").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("ruby", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockSapphire")) {
            ItemStack blockStack = OreDictionary.getOres("blockSapphire").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("sapphire", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockSilver")) {
            ItemStack blockStack = OreDictionary.getOres("blockSilver").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("silver", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockSteel")) {
            ItemStack blockStack = OreDictionary.getOres("blockSteel").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("steel", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockTeslatite")) {
            ItemStack blockStack = OreDictionary.getOres("blockTeslatite").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("teslatite", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockTin")) {
            ItemStack blockStack = OreDictionary.getOres("blockTin").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("tin", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockTitanium")) {
            ItemStack blockStack = OreDictionary.getOres("blockTitanium").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("titanium", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockTungsten")) {
            ItemStack blockStack = OreDictionary.getOres("blockTungsten").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("tungsten", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockTungstensteel")) {
            ItemStack blockStack = OreDictionary.getOres("blockTungstensteel").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("tungstensteel", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockYellowGarnet")) {
            ItemStack blockStack = OreDictionary.getOres("blockYellowGarnet").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("yellowGarnet", 9), 200, 16));
        }
        if(OreDictionary.doesOreNameExist("blockZinc")) {
            ItemStack blockStack = OreDictionary.getOres("blockZinc").get(0);
            RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(blockStack, ItemPlates.getPlateByName("zinc", 9), 200, 16));
        }

        //Obsidian
        RecipeHandler.addRecipe(new PlateCuttingMachineRecipe(new ItemStack(Blocks.obsidian), ItemPlates.getPlateByName("obsidian", 9), 100, 4));
    }

    static void addIndustrialSawmillRecipes() {
        ItemStack pulpStack = OreDictionary.getOres("pulpWood").get(0);
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 0), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 0), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 0), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 0), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 1), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 1), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 1), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 2), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 2), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 2), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 2), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 3), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 3), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log, 1, 3), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 3), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 4), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 4), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 0), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 4), pulpStack, new ItemStack(Items.bucket), 200, 30, false));

        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Blocks.planks, 6, 5), pulpStack, null, 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Blocks.planks, 6, 5), pulpStack, IC2Items.getItem("cell"), 200, 30, false));
        RecipeHandler.addRecipe(new IndustrialSawmillRecipe(new ItemStack(Blocks.log2, 1, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Blocks.planks, 6, 5), pulpStack, new ItemStack(Items.bucket), 200, 30, false));
    }
    
    static void addBlastFurnaceRecipes()
    {
        RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("titanium"), null, ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("titanium", 4), null, ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("titanium", 9), null, ItemIngots.getIngotByName("titanium"), null, 3600, 120, 1500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("aluminum"), null, ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("aluminum", 4), null, ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("aluminum", 9), null, ItemIngots.getIngotByName("aluminum"), null, 2200, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("kanthal"), null, ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("kanthal", 4), null, ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("kanthal", 9), null, ItemIngots.getIngotByName("kanthal"), null, 5500, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("tungsten"), null, ItemIngots.getIngotByName("tungsten"), null, 18000, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("tungsten", 4), null, ItemIngots.getIngotByName("tungsten"), null, 18000, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("tungsten", 9), null, ItemIngots.getIngotByName("tungsten"), null, 18000, 120, 2500));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("chrome"), null, ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("chrome", 4), null, ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("chrome", 9), null, ItemIngots.getIngotByName("chrome"), null, 4420, 120, 1700));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("steel"), null, ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsSmall.getSmallDustByName("steel", 4), null, ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));
		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDustsTiny.getTinyDustByName("steel", 9), null, ItemIngots.getIngotByName("steel"), null, 2800, 120, 1000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemDusts.getDustByName("galena", 2), null, ItemIngots.getIngotByName("silver"), ItemIngots.getIngotByName("lead"), 80, 120, 1500));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(new ItemStack(Items.iron_ingot), ItemDusts.getDustByName("coal", 2), ItemIngots.getIngotByName("steel"), ItemDusts.getDustByName("darkAshes", 2), 500, 120, 1000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemIngots.getIngotByName("tungsten"), ItemIngots.getIngotByName("steel"), ItemIngots.getIngotByName("hotTungstensteel"), ItemDusts.getDustByName("darkAshes", 4), 500, 500, 3000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(ItemCells.getCellByName("silicon", 2), null, ItemPlates.getPlateByName("silicon"), new ItemStack(IC2Items.getItem("cell").getItem(), 2), 1000, 120, 1500));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(new ItemStack(Blocks.iron_ore), ItemDusts.getDustByName("calcite"), new ItemStack(Items.iron_ingot, 3), ItemDusts.getDustByName("darkAshes"), 140, 120, 15000));

		RecipeHandler.addRecipe(new BlastFurnaceRecipe(BlockOre.getOreByName("pyrite"), ItemDusts.getDustByName("calcite"), new ItemStack(Items.iron_ingot, 2), ItemDusts.getDustByName("darkAshes"), 140, 120, 15000));
	}
	
	static void addUUrecipes() {
		if(ConfigTechReborn.UUrecipesIridiamOre)
			CraftingHelper.addShapedOreRecipe((IC2Items.getItem("iridiumOre")),
					"UUU",
					" U ",
					"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesWood)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.log, 8),
				" U ",
				"   ",
				"   ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesStone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.stone, 16),
				"   ",
				" U ",
				"   ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesSnowBlock)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.snow, 16),
				"U U",
				"   ",
				"   ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesGrass)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.grass, 16),
				"   ",
				"U  ",
				"U  ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesObsidian)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.obsidian, 12),
				"U U",
				"U U",
				"   ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesGlass)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.glass, 32),
				" U ",
				"U U",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesWater)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.water, 1),
				"   ",
				" U ",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesLava)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.lava, 1),
				" U ",
				" U ",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesCocoa)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 32, 3),
				"UU ",
				"  U",
				"UU ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesGlowstoneBlock)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.glowstone, 8),
				" U ",
				"U U",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesCactus)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.cactus, 48),
				" U ",
				"UUU",
				"U U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesSugarCane)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.reeds, 48),
				"U U",
				"U U",
				"U U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesVine)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.vine, 24),
				"U  ",
				"U  ",
				"U  ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesSnowBall)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.snowball, 16),
				"   ",
				"   ",
				"UUU",
					'U', ModItems.uuMatter);
		
		CraftingHelper.addShapedOreRecipe(new ItemStack(Items.clay_ball, 48),
			"UU ",
			"U  ", 
			"UU ", 
				'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipeslilypad)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.waterlily, 64),
				"U U",
				" U ",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesGunpowder)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.gunpowder, 15),
				"UUU",
				"U  ",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesBone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.bone, 32),
				"U  ",
				"UU ",
				"U  ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesFeather)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.feather, 32),
				" U ",
				" U ",
				"U U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesInk)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 48),
				" UU",
				" UU",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesEnderPearl)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.ender_pearl, 1),
				"UUU",
				"U U",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesCoal)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.coal, 5),
				"  U",
				"U  ",
				"  U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesIronOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.iron_ore, 2),
				"U U",
				" U ",
				"U U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesGoldOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.gold_ore, 2),
				" U ",
				"UUU",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesRedStone)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.redstone, 24),
				"   ",
				" U ",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesLapis)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.dye, 9 , 4),
				" U ",
				" U ",
				" UU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesEmeraldOre)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Blocks.emerald_ore, 1),
				"UU ",
				"U U",
				" UU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesEmerald)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.emerald, 2),
				"UUU",
				"UUU",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesDiamond)
			CraftingHelper.addShapedOreRecipe(new ItemStack(Items.diamond, 1),
				"UUU",
				"UUU",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesTinDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 10, 77),
				"   ",
				"U U",
				"  U",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesCopperDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 10, 21),
				"  U",
				"U U",
				"   ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesLeadDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 14, 42),
				"UUU",
				"UUU",
				"U  ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesPlatinumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 1, 58),
				"  U",
				"UUU",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesTungstenDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 1, 79),
				"U  ",
				"UUU",
				"UUU",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesTitaniumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 2, 78),
				"UUU",
				" U ",
				" U ",
					'U', ModItems.uuMatter);

		if(ConfigTechReborn.UUrecipesAluminumDust)
			CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.dusts, 16, 2),
				" U ",
				" U ",
				"UUU",
					'U', ModItems.uuMatter);

		
		if(ConfigTechReborn.HideUuRecipes)
			hideUUrecipes();
		
	}
	
	static void hideUUrecipes() {
		//TODO
	}

	static void addAssemblingMachineRecipes() {
		//Ender Eye
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.blaze_powder), new ItemStack(Items.ender_eye), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.ender_pearl, 6), new ItemStack(Items.blaze_rod), new ItemStack(Items.ender_eye, 6), 120, 5));

		//Redstone Lamp
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.redstone, 4), new ItemStack(Items.glowstone_dust, 4), new ItemStack(Blocks.redstone_lamp), 120, 5));

		//Note Block
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Blocks.planks, 8), new ItemStack(Items.redstone, 1), new ItemStack(Blocks.noteblock), 120, 5));

		//Jukebox
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Blocks.planks, 8), new ItemStack(Blocks.jukebox), 120, 5));

		//Clock
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.redstone, 1), new ItemStack(Items.gold_ingot, 4), new ItemStack(Items.clock), 120, 5));

		//Compass
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.redstone, 1), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.clock), 120, 5));

		//Lead
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.string, 1), new ItemStack(Items.slime_ball, 1), new ItemStack(Items.lead, 2), 120, 5));

		//Circuit Parts
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.glowstone_dust), ItemDusts.getDustByName("lazurite", 1), ItemParts.getPartByName("advancedCircuitParts", 2), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(Items.glowstone_dust), ItemDusts.getDustByName("lapis", 1), ItemParts.getPartByName("advancedCircuitParts", 2), 120, 5));

		//Electronic Circuit
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemParts.getPartByName("basicCircuitBoard", 1), new ItemStack(IC2Items.getItem("insulatedCopperCableItem").getItem(), 3), IC2Items.getItem("electronicCircuit"), 120, 5));

		//Advanced Circuit
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemParts.getPartByName("advancedCircuitBoard", 1), ItemParts.getPartByName("advancedCircuitParts", 2), IC2Items.getItem("advancedCircuit"), 120, 5));

		//Energy Flow Circuit
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemParts.getPartByName("processorCircuitBoard", 1), new ItemStack(IC2Items.getItem("lapotronCrystal").getItem(), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ModItems.parts, 1, 4), 120, 5));

		//Data Control Circuit
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemParts.getPartByName("processorCircuitBoard", 1), ItemParts.getPartByName("dataStorageCircuit", 1), ItemParts.getPartByName("dataControlCircuit", 1), 120, 5));

		//Data Storage Circuit
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("emerald", 8), IC2Items.getItem("advancedCircuit"), ItemParts.getPartByName("dataStorageCircuit", 1), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("peridot", 8), IC2Items.getItem("advancedCircuit"), ItemParts.getPartByName("dataStorageCircuit", 1), 120, 5));

		//Data Orb
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemParts.getPartByName("dataControlCircuit", 1), ItemParts.getPartByName("dataStorageCircuit", 8), ItemParts.getPartByName("dataOrb"), 120, 5));

		//Basic Circuit Board
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("aluminum", 1), ItemPlates.getPlateByName("electrum", 2), ItemParts.getPartByName("basicCircuitBoard", 2), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("iron", 1), ItemPlates.getPlateByName("electrum", 2), ItemParts.getPartByName("basicCircuitBoard", 2), 120, 5));

		//Advanced Circuit Board
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("electrum", 2), IC2Items.getItem("electronicCircuit"), ItemParts.getPartByName("advancedCircuitBoard", 1), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("electrum", 4), ItemPlates.getPlateByName("silicon", 1), ItemParts.getPartByName("advancedCircuitBoard", 2), 120, 5));

		//Processor Circuit Board
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("platinum", 1), IC2Items.getItem("advancedCircuit"), ItemParts.getPartByName("processorCircuitBoard", 1), 120, 5));

		//Frequency Transmitter
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(IC2Items.getItem("electronicCircuit"), IC2Items.getItem("insulatedCopperCableItem"), IC2Items.getItem("frequencyTransmitter"), 120, 5));

		//Wind Mill
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("magnalium", 2), IC2Items.getItem("generator"), IC2Items.getItem("windMill"), 120, 5));
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(new ItemStack(IC2Items.getItem("carbonPlate").getItem(), 4), IC2Items.getItem("generator"), IC2Items.getItem("windMill"), 120, 5));

		//Water Mill
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemPlates.getPlateByName("aluminum", 4), IC2Items.getItem("generator"), IC2Items.getItem("waterMill"), 120, 5));

		//Industrial TNT
		RecipeHandler.addRecipe(new AssemblingMachineRecipe(ItemDusts.getDustByName("flint", 5), new ItemStack(Blocks.tnt), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 5), 120, 5));
	}

	static void addIndustrialCentrifugeRecipes() {
		//Plantball/Bio Chaff
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.grass, 16), null, new ItemStack(IC2Items.getItem("biochaff").getItem(), 8), new ItemStack(IC2Items.getItem("plantBall").getItem(), 8), new ItemStack(Items.clay_ball), new ItemStack(Blocks.sand, 8), 2500, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.dirt, 16), null, new ItemStack(IC2Items.getItem("biochaff").getItem(), 4), new ItemStack(IC2Items.getItem("plantBall").getItem(), 4), new ItemStack(Items.clay_ball), new ItemStack(Blocks.sand, 8), 2500, 5));

		//Methane
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.mushroom_stew, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.apple, 32), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.porkchop, 12), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_porkchop, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.bread, 64), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.fish, 12), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_fished, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.beef, 12), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_beef, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.pumpkin, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.speckled_melon, 1), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), new ItemStack(Items.gold_nugget, 6), null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.spider_eye, 32), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.chicken, 12), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cooked_chicken, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.rotten_flesh, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.melon, 64), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cookie, 64), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.cake, 8), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.golden_carrot, 1), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), new ItemStack(Items.gold_nugget, 6), null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.carrot, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.baked_potato, 24), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.potato, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.poisonous_potato, 12), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.nether_wart, 1), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(IC2Items.getItem("terraWart").getItem(), 16), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.brown_mushroom, 1), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.red_mushroom, 1), IC2Items.getItem("cell"), ItemCells.getCellByName("methane", 1), null, null, null, 5000, 5));

		//Rubber Wood Yields
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(IC2Items.getItem("rubberWood").getItem(), 15), new ItemStack(IC2Items.getItem("cell").getItem(), 5), new ItemStack(IC2Items.getItem("resin").getItem(), 8), new ItemStack(IC2Items.getItem("plantBall").getItem(), 6), ItemCells.getCellByName("methane", 1), ItemCells.getCellByName("carbon", 4), 5000, 5));

		//Soul Sand Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.soul_sand, 16), IC2Items.getItem("cell"), ItemCells.getCellByName("oil", 1), ItemDusts.getDustByName("saltpeter", 4), ItemDusts.getDustByName("coal", 1), new ItemStack(Blocks.sand, 10), 2500, 5));

		//Mycelium Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Blocks.mycelium, 8), null, new ItemStack(Blocks.brown_mushroom, 2), new ItemStack(Blocks.red_mushroom, 2), new ItemStack(Items.clay_ball, 1), new ItemStack(Blocks.sand, 4), 1640, 5));

		//Ice
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("ice", 1), null, new ItemStack(Blocks.ice, 1), IC2Items.getItem("cell"), null, null, 40, 5));

		//Blaze Powder Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.blaze_powder), null, ItemDusts.getDustByName("darkAshes", 1), ItemDusts.getDustByName("sulfur", 1), null, null, 1240, 5));

		//Magma Cream Products
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.magma_cream, 1), null, new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.slime_ball, 1), null, null, 2500, 5));

		//Dust Byproducts
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("platinum", 1), null, ItemDustsTiny.getTinyDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, null, 3000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("electrum", 2), null, ItemDusts.getDustByName("silver", 1), ItemDusts.getDustByName("gold", 1), null, null, 2400, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("invar", 3), null, ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), null, null, 1340, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("marble", 8), null, ItemDusts.getDustByName("magnesium", 1), ItemDusts.getDustByName("calcite", 7), null, null, 1280, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("redrock", 4), null, ItemDusts.getDustByName("calcite", 2), ItemDusts.getDustByName("flint", 1), ItemDusts.getDustByName("clay", 1), null, 640, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("basalt", 16), null, ItemDusts.getDustByName("peridot", 1), ItemDusts.getDustByName("calcite", 3), ItemDusts.getDustByName("magnesium", 8), ItemDusts.getDustByName("darkAshes", 4), 2680, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.glowstone_dust, 16), IC2Items.getItem("cell"), new ItemStack(Items.redstone, 8), ItemDusts.getDustByName("gold", 8), ItemCells.getCellByName("helium", 1), null, 25000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("yellowGarnet", 16), null, ItemDusts.getDustByName("andradite", 5), ItemDusts.getDustByName("grossular", 8), ItemDusts.getDustByName("uvarovite", 3), null, 2940, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("redGarnet", 16), null, ItemDusts.getDustByName("pyrope", 3), ItemDusts.getDustByName("almandine", 5), ItemDusts.getDustByName("spessartine", 8), null, 2940, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("phosphorous", 5), new ItemStack(IC2Items.getItem("cell").getItem(), 3), ItemCells.getCellByName("calcium", 3), null, null, null, 1280, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("darkAshes", 2), null, ItemDusts.getDustByName("ashes", 2), null, null, null, 240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("ashes", 1), IC2Items.getItem("cell"), ItemCells.getCellByName("carbon"), null, null, null, 80, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(new ItemStack(Items.redstone, 10), new ItemStack(IC2Items.getItem("cell").getItem(), 4), ItemCells.getCellByName("silicon", 1), ItemDusts.getDustByName("pyrite", 3), ItemDusts.getDustByName("ruby", 1), ItemCells.getCellByName("mercury", 3), 6800, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("manyullyn", 2), null, ItemDusts.getDustByName("cobalt", 1), ItemDusts.getDustByName("ardite", 1), null, null, 1240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("nichrome", 5), null, ItemDusts.getDustByName("nickel", 4), ItemDusts.getDustByName("chrome", 1), null, null, 2240, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("cupronickel", 2), null, ItemDusts.getDustByName("copper", 1), ItemDusts.getDustByName("nickel", 1), null, null, 960, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("kanthal", 3), null, ItemDusts.getDustByName("iron", 1), ItemDusts.getDustByName("aluminum", 1), ItemDusts.getDustByName("chrome", 1), null, 1040, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("endstone", 16), new ItemStack(IC2Items.getItem("cell").getItem(), 2), ItemCells.getCellByName("helium3", 1), ItemCells.getCellByName("helium"), ItemDustsTiny.getTinyDustByName("Tungsten", 1), new ItemStack(Blocks.sand, 12), 4800, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("cinnabar", 2), IC2Items.getItem("cell"), ItemCells.getCellByName("mercury", 1), ItemDusts.getDustByName("sulfur", 1), null, null, 80, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("brass", 4), null, ItemDusts.getDustByName("zinc", 1), ItemDusts.getDustByName("copper", 3), null, null, 2000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("aluminumBrass", 4), null, ItemDusts.getDustByName("aluminum", 1), ItemDusts.getDustByName("copper", 3), null, null, 2000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("bronze", 4), null, ItemDusts.getDustByName("tin", 1), ItemDusts.getDustByName("copper", 3), null, null, 2420, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("flint", 1), null, IC2Items.getItem("silicondioxideDust"), null, null, null, 160, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("netherrack", 16), null, new ItemStack(Items.redstone, 1), ItemDusts.getDustByName("sulfur", 4), ItemDusts.getDustByName("basalt", 1), new ItemStack(Items.gold_nugget, 1), 2400, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("enderEye", 1), null, ItemDusts.getDustByName("enderPearl", 1), new ItemStack(Items.blaze_powder, 1), null, null, 1280, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("tetrahedrite", 8), null, ItemDusts.getDustByName("copper", 3), ItemDusts.getDustByName("antimony", 1), ItemDusts.getDustByName("sulfur", 3), ItemDusts.getDustByName("iron", 1), 3640, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemDusts.getDustByName("lapis", 16), null, ItemDusts.getDustByName("lazurite", 12), ItemDusts.getDustByName("sodalite", 2), ItemDusts.getDustByName("pyrite", 7), ItemDusts.getDustByName("calcite", 1), 3580, 5));

		//Deuterium/Tritium
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("helium", 16), null, ItemCells.getCellByName("deuterium", 1), new ItemStack(IC2Items.getItem("cell").getItem(), 15), null, null, 10000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("deuterium", 4), null, ItemCells.getCellByName("tritium", 1), new ItemStack(IC2Items.getItem("cell").getItem(), 3), null, null, 3000, 5));
		RecipeHandler.addRecipe(new CentrifugeRecipe(ItemCells.getCellByName("hydrogen", 4), null, ItemCells.getCellByName("deuterium", 1), new ItemStack(IC2Items.getItem("cell").getItem(), 3), null, null, 3000, 5));

		//Lava Cell Byproducts
		ItemStack lavaCells = IC2Items.getItem("lavaCell");
		lavaCells.stackSize = 8;
		RecipeHandler.addRecipe(new CentrifugeRecipe(lavaCells, null, ItemNuggets.getNuggetByName("electrum", 4), ItemIngots.getIngotByName("copper", 2), ItemDustsTiny.getTinyDustByName("Tungsten", 1), ItemIngots.getIngotByName("tin", 17), 6000, 5));
	}

	static void addIndustrialGrinderRecipes() {
		//Coal Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.coal_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.coal, 1), ItemDustsSmall.getSmallDustByName("Coal", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.coal_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.coal, 1), ItemDustsSmall.getSmallDustByName("Coal", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.coal_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.coal, 1), ItemDustsSmall.getSmallDustByName("Coal", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), new ItemStack(Items.bucket), 100, 120));

		//Iron Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("iron", 2), ItemDustsSmall.getSmallDustByName("Nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("iron", 2), ItemDustsSmall.getSmallDustByName("Nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("iron", 2), ItemDustsSmall.getSmallDustByName("Nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.iron_ore, 1), new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("iron", 2), ItemDusts.getDustByName("nickel", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), new ItemStack(Items.bucket), 100, 120));

		//Gold Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("gold", 2), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("gold", 2), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("gold", 2), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("gold", 2), ItemDusts.getDustByName("copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("gold", 2), ItemDusts.getDustByName("copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("gold", 2), ItemDusts.getDustByName("copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("gold", 3), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("gold", 3), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.gold_ore, 1), new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("gold", 3), ItemDustsSmall.getSmallDustByName("Copper", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

		//Diamond Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.diamond_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.diamond, 1), ItemDustsSmall.getSmallDustByName("Diamond", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.diamond_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.diamond, 1), ItemDustsSmall.getSmallDustByName("Diamond", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.diamond_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.diamond, 1), ItemDustsSmall.getSmallDustByName("Diamond", 6), ItemDustsSmall.getSmallDustByName("Coal", 2), new ItemStack(Items.bucket), 100, 120));

		//Emerald Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.emerald_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.emerald, 1), ItemDustsSmall.getSmallDustByName("Emerald", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.emerald_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.emerald, 1), ItemDustsSmall.getSmallDustByName("Emerald", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.emerald_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.emerald, 1), ItemDustsSmall.getSmallDustByName("Emerald", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), new ItemStack(Items.bucket), 100, 120));

		//Redstone
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.redstone_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.redstone, 10), ItemDustsSmall.getSmallDustByName("Cinnabar", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.redstone_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.redstone, 10), ItemDustsSmall.getSmallDustByName("Cinnabar", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.redstone_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.redstone, 10), ItemDustsSmall.getSmallDustByName("Cinnabar", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), new ItemStack(Items.bucket), 100, 120));

		//Lapis Lazuli Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.lapis_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.dye, 6, 4), ItemDustsSmall.getSmallDustByName("Lapis", 36), ItemDustsSmall.getSmallDustByName("Lazurite", 8), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.lapis_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.dye, 6, 4), ItemDustsSmall.getSmallDustByName("Lapis", 36), ItemDustsSmall.getSmallDustByName("Lazurite", 8), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.lapis_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.dye, 6, 4), ItemDustsSmall.getSmallDustByName("Lapis", 36), ItemDustsSmall.getSmallDustByName("Lazurite", 8), new ItemStack(Items.bucket), 100, 120));

		//Copper Ore
		if (OreDictionary.doesOreNameExist("oreCopper")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCopper").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("copper", 2), ItemDusts.getDustByName("gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("copper", 2), ItemDusts.getDustByName("gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("copper", 2), ItemDusts.getDustByName("gold", 1), ItemDustsSmall.getSmallDustByName("Nickel", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDusts.getDustByName("nickel", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDusts.getDustByName("nickel", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("copper", 2), ItemDustsSmall.getSmallDustByName("Gold", 1), ItemDusts.getDustByName("nickel", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Copper Ore");
			}
		}

		//Tin Ore
		if (OreDictionary.doesOreNameExist("oreTin")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTin").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("zinc", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("zinc", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("tin", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("zinc", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Tin Ore");
			}
		}

		//Nickel Ore
		if (OreDictionary.doesOreNameExist("oreNickel")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreNickel").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("nickel", 3), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("nickel", 3), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("nickel", 3), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Platinum", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("platinum", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("platinum", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("nickel", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("platinum", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Nickel Ore");
			}
		}

		//Zinc Ore
		if (OreDictionary.doesOreNameExist("oreZinc")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreZinc").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDustsSmall.getSmallDustByName("Tin", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("iron", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("iron", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("zinc", 2), ItemDustsSmall.getSmallDustByName("Iron", 1), ItemDusts.getDustByName("iron", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Zinc Ore");
			}
		}

		//Silver Ore
		if (OreDictionary.doesOreNameExist("oreSilver")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSilver").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("silver", 2), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("silver", 2), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("silver", 2), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("silver", 3), ItemDustsSmall.getSmallDustByName("Lead", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Silver Ore");
			}
		}

		//Lead Ore
		if (OreDictionary.doesOreNameExist("oreLead")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreLead").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("lead", 2), ItemDustsSmall.getSmallDustByName("Silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("lead", 2), ItemDustsSmall.getSmallDustByName("Silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("lead", 2), ItemDustsSmall.getSmallDustByName("Silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));

				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("lead", 2), ItemDusts.getDustByName("silver", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Lead Ore");
			}
		}

		//Uranium Ore
		if (OreDictionary.doesOreNameExist("oreUranium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreUranium").get(0);
				ItemStack uranium238Stack = IC2Items.getItem("Uran238");
				uranium238Stack.stackSize = 8;
				ItemStack uranium235Stack = IC2Items.getItem("smallUran235");
				uranium235Stack.stackSize = 2;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), uranium238Stack, uranium235Stack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, uranium238Stack, uranium235Stack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, uranium238Stack, uranium235Stack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Uranium Ore");
			}
		}

		//Pitchblende Ore
		if (OreDictionary.doesOreNameExist("orePitchblende")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("orePitchblende").get(0);
				ItemStack uranium238Stack = IC2Items.getItem("Uran238");
				uranium238Stack.stackSize = 8;
				ItemStack uranium235Stack = IC2Items.getItem("smallUran235");
				uranium235Stack.stackSize = 2;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), uranium238Stack, uranium235Stack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, uranium238Stack, uranium235Stack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, uranium238Stack, uranium235Stack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Uranium Ore");
			}
		}

		//Aluminum Ore
		if (OreDictionary.doesOreNameExist("oreAluminum")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreAluminum").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("aluminum", 2), ItemDustsSmall.getSmallDustByName("Bauxite", 1), ItemDustsSmall.getSmallDustByName("Bauxite", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("aluminum", 2), ItemDustsSmall.getSmallDustByName("Bauxite", 1), ItemDustsSmall.getSmallDustByName("Bauxite", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("aluminum", 2), ItemDustsSmall.getSmallDustByName("Bauxite", 1), ItemDustsSmall.getSmallDustByName("Bauxite", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Lead Ore");
			}
		}

		//Ardite Ore
		if (OreDictionary.doesOreNameExist("oreArdite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreArdite").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("ardite", 2), ItemDustsSmall.getSmallDustByName("Ardite", 1), ItemDustsSmall.getSmallDustByName("Ardite", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("ardite", 2), ItemDustsSmall.getSmallDustByName("Ardite", 1), ItemDustsSmall.getSmallDustByName("Ardite", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("ardite", 2), ItemDustsSmall.getSmallDustByName("Ardite", 1), ItemDustsSmall.getSmallDustByName("Ardite", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Ardite Ore");
			}
		}

		//Cobalt Ore
		if (OreDictionary.doesOreNameExist("oreCobalt")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCobalt").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("cobalt", 2), ItemDustsSmall.getSmallDustByName("Cobalt", 1), ItemDustsSmall.getSmallDustByName("Cobalt", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("cobalt", 2), ItemDustsSmall.getSmallDustByName("Cobalt", 1), ItemDustsSmall.getSmallDustByName("Cobalt", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("cobalt", 2), ItemDustsSmall.getSmallDustByName("Cobalt", 1), ItemDustsSmall.getSmallDustByName("Cobalt", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Cobalt Ore");
			}
		}

		//Dark Iron Ore
		if (OreDictionary.doesOreNameExist("oreDarkIron")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreDarkIron").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("darkIron", 2), ItemDustsSmall.getSmallDustByName("DarkIron", 1), ItemDustsSmall.getSmallDustByName("Iron", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("darkIron", 2), ItemDustsSmall.getSmallDustByName("DarkIron", 1), ItemDustsSmall.getSmallDustByName("Iron", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("darkIron", 2), ItemDustsSmall.getSmallDustByName("DarkIron", 1), ItemDustsSmall.getSmallDustByName("Iron", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Dark Iron Ore");
			}
		}

		//Cadmium Ore
		if (OreDictionary.doesOreNameExist("oreCadmium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCadmium").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("cadmium", 2), ItemDustsSmall.getSmallDustByName("Cadmium", 1), ItemDustsSmall.getSmallDustByName("Cadmium", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("cadmium", 2), ItemDustsSmall.getSmallDustByName("Cadmium", 1), ItemDustsSmall.getSmallDustByName("Cadmium", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("cadmium", 2), ItemDustsSmall.getSmallDustByName("Cadmium", 1), ItemDustsSmall.getSmallDustByName("Cadmium", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Cadmium Ore");
			}
		}

		//Indium Ore
		if (OreDictionary.doesOreNameExist("oreIndium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreIndium").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("indium", 2), ItemDustsSmall.getSmallDustByName("Indium", 1), ItemDustsSmall.getSmallDustByName("Indium", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("indium", 2), ItemDustsSmall.getSmallDustByName("Indium", 1), ItemDustsSmall.getSmallDustByName("Indium", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("indium", 2), ItemDustsSmall.getSmallDustByName("Indium", 1), ItemDustsSmall.getSmallDustByName("Indium", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Indium Ore");
			}
		}

		//Calcite Ore
		if (OreDictionary.doesOreNameExist("oreCalcite") && OreDictionary.doesOreNameExist("gemCalcite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCalcite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemCalcite").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, ItemDustsSmall.getSmallDustByName("Calcite", 6), null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, ItemDustsSmall.getSmallDustByName("Calcite", 6), null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, ItemDustsSmall.getSmallDustByName("Calcite", 6), null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Calcite Ore");
			}
		}

		//Magnetite Ore
		if (OreDictionary.doesOreNameExist("oreMagnetite") && OreDictionary.doesOreNameExist("chunkMagnetite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreMagnetite").get(0);
				ItemStack chunkStack = OreDictionary.getOres("chunkMagnetite").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), chunkStack, ItemDustsSmall.getSmallDustByName("Magnetite", 6), null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, chunkStack, ItemDustsSmall.getSmallDustByName("Magnetite", 6), null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, chunkStack, ItemDustsSmall.getSmallDustByName("Magnetite", 6), null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Magnetite Ore");
			}
		}

		//Graphite Ore
		if (OreDictionary.doesOreNameExist("oreGraphite") && OreDictionary.doesOreNameExist("chunkGraphite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreGraphite").get(0);
				ItemStack chunkStack = OreDictionary.getOres("chunkGraphite").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), chunkStack, ItemDustsSmall.getSmallDustByName("Graphite", 6), null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, chunkStack, ItemDustsSmall.getSmallDustByName("Graphite", 6), null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, chunkStack, ItemDustsSmall.getSmallDustByName("Graphite", 6), null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Graphite Ore");
			}
		}

		//Osmium Ore
		if (OreDictionary.doesOreNameExist("oreOsmium")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreOsmium").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("osmium", 2), ItemDustsSmall.getSmallDustByName("Osmium", 1), ItemDustsSmall.getSmallDustByName("Osmium", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("osmium", 2), ItemDustsSmall.getSmallDustByName("Osmium", 1), ItemDustsSmall.getSmallDustByName("Osmium", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("osmium", 2), ItemDustsSmall.getSmallDustByName("Osmium", 1), ItemDustsSmall.getSmallDustByName("Osmium", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Osmium Ore");
			}
		}

		//Teslatite Ore
		if (OreDictionary.doesOreNameExist("oreTeslatite") && OreDictionary.doesOreNameExist("dustTeslatite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTeslatite").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustTeslatite").get(0);
				dustStack.stackSize = 10;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), dustStack, ItemDustsSmall.getSmallDustByName("Sodalite", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, dustStack, ItemDustsSmall.getSmallDustByName("Sodalite", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, dustStack, ItemDustsSmall.getSmallDustByName("Sodalite", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Teslatite Ore");
			}
		}

		//Sulfur Ore
		if (OreDictionary.doesOreNameExist("oreSulfur")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSulfur").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("sulfur", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("sulfur", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("sulfur", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Sulfur", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Sulfur Ore");
			}
		}

		//Saltpeter Ore
		if (OreDictionary.doesOreNameExist("oreSaltpeter")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreSaltpeter").get(0);
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("saltpeter", 2), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("saltpeter", 2), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("saltpeter", 2), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), ItemDustsSmall.getSmallDustByName("Saltpeter", 1), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Saltpeter Ore");
			}
		}

		//Apatite Ore
		if (OreDictionary.doesOreNameExist("oreApatite") & OreDictionary.doesOreNameExist("gemApatite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreApatite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemApatite").get(0);
				gemStack.stackSize = 6;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, gemStack, ItemDustsSmall.getSmallDustByName("Phosphorous", 4), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Apatite Ore");
			}
		}

		//Nether Quartz Ore
		if (OreDictionary.doesOreNameExist("dustNetherQuartz")) {
			try {
				ItemStack dustStack = OreDictionary.getOres("dustNetherQuartz").get(0);
				dustStack.stackSize = 4;
				RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.quartz_ore, 1), null, new FluidStack(FluidRegistry.WATER, 1000), new ItemStack(Items.quartz, 2), dustStack, ItemDustsSmall.getSmallDustByName("Netherrack", 2), null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.quartz_ore, 1), IC2Items.getItem("waterCell"), null, new ItemStack(Items.quartz, 2), dustStack, ItemDustsSmall.getSmallDustByName("Netherrack", 2), IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(Blocks.quartz_ore, 1), new ItemStack(Items.water_bucket), null, new ItemStack(Items.quartz, 2), dustStack, ItemDustsSmall.getSmallDustByName("Netherrack", 2), new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Nether Quartz Ore");
			}
		}

		//Certus Quartz Ore
		if (OreDictionary.doesOreNameExist("oreCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		//Charged Certus Quartz Ore
		if (OreDictionary.doesOreNameExist("oreChargedCertusQuartz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreChargedCertusQuartz").get(0);
				ItemStack gemStack = OreDictionary.getOres("crystalChargedCertusQuartz").get(0);
				ItemStack dustStack = OreDictionary.getOres("dustCertusQuartz").get(0);
				dustStack.stackSize = 2;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Charged Certus Quartz Ore");
			}
		}

		//Amethyst Ore
		if (OreDictionary.doesOreNameExist("oreAmethyst") && OreDictionary.doesOreNameExist("gemAmethyst")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreAmethyst").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemAmethyst").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemAmethyst").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Certus Quartz Ore");
			}
		}

		//Topaz Ore
		if (OreDictionary.doesOreNameExist("oreTopaz") && OreDictionary.doesOreNameExist("gemTopaz")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTopaz").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTopaz").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTopaz").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Topaz Ore");
			}
		}

		//Tanzanite Ore
		if (OreDictionary.doesOreNameExist("oreTanzanite") && OreDictionary.doesOreNameExist("gemTanzanite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreTanzanite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemTanzanite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemTanzanite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Tanzanite Ore");
			}
		}

		//Malachite Ore
		if (OreDictionary.doesOreNameExist("oreMalachite") && OreDictionary.doesOreNameExist("gemMalachite")) {
			try {
				ItemStack oreStack = OreDictionary.getOres("oreMalachite").get(0);
				ItemStack gemStack = OreDictionary.getOres("gemMalachite").get(0);
				gemStack.stackSize = 2;
				ItemStack dustStack = OreDictionary.getOres("gemMalachite").get(0);
				dustStack.stackSize = 1;
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, null, new FluidStack(FluidRegistry.WATER, 1000), gemStack, dustStack, null, null, 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, IC2Items.getItem("waterCell"), null, gemStack, dustStack, null, IC2Items.getItem("cell"), 100, 120));
				RecipeHandler.addRecipe(new GrinderRecipe(oreStack, new ItemStack(Items.water_bucket), null, gemStack, dustStack, null, new ItemStack(Items.bucket), 100, 120));
			} catch (Exception e) {
				LogHelper.info("Failed to Load Grinder Recipe for Malachite Ore");
			}
		}

		//Galena Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDusts.getDustByName("silver", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDusts.getDustByName("silver", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("galena", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDusts.getDustByName("silver", 1), new ItemStack(Items.bucket), 100, 120));

		//Iridium Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), null, new FluidStack(FluidRegistry.WATER, 1000), IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDustsSmall.getSmallDustByName("Platinum", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), IC2Items.getItem("waterCell"), null, IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDustsSmall.getSmallDustByName("Platinum", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), new ItemStack(Items.water_bucket), null, IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDustsSmall.getSmallDustByName("Platinum", 2), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), null, new FluidStack(ModFluids.fluidMercury, 1000), IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), ItemCells.getCellByName("mercury", 1), null, IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 1), new ItemStack(ModItems.bucketMercury), null, IC2Items.getItem("iridiumOre"), ItemDustsSmall.getSmallDustByName("Iridium", 6), ItemDusts.getDustByName("platinum", 2), new ItemStack(Items.bucket), 100, 120));

		//Ruby Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2), null, new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("ruby", 1), ItemDustsSmall.getSmallDustByName("Ruby", 6), ItemDustsSmall.getSmallDustByName("Chrome", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2), IC2Items.getItem("waterCell"), null, ItemGems.getGemByName("ruby", 1), ItemDustsSmall.getSmallDustByName("Ruby", 6), ItemDustsSmall.getSmallDustByName("Chrome", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 2), new ItemStack(Items.water_bucket), null, ItemGems.getGemByName("ruby", 1), ItemDustsSmall.getSmallDustByName("Ruby", 6), ItemDustsSmall.getSmallDustByName("Chrome", 2), new ItemStack(Items.bucket), 100, 120));
		
		//Sapphire Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3), null, new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("sapphire", 1), ItemDustsSmall.getSmallDustByName("Sapphire", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3), IC2Items.getItem("waterCell"), null, ItemGems.getGemByName("sapphire", 1), ItemDustsSmall.getSmallDustByName("Sapphire", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 3), new ItemStack(Items.water_bucket), null, ItemGems.getGemByName("sapphire", 1), ItemDustsSmall.getSmallDustByName("Sapphire", 6), ItemDustsSmall.getSmallDustByName("Aluminum", 2), new ItemStack(Items.bucket), 100, 120));

		//Bauxite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("bauxite", 2), ItemDustsSmall.getSmallDustByName("Grossular", 4), ItemDustsSmall.getSmallDustByName("Titanium", 4), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("bauxite", 2), ItemDustsSmall.getSmallDustByName("Grossular", 4), ItemDustsSmall.getSmallDustByName("Titanium", 4), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 4), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("bauxite", 2), ItemDustsSmall.getSmallDustByName("Grossular", 4), ItemDustsSmall.getSmallDustByName("Titanium", 4), new ItemStack(Items.bucket), 100, 120));

		//Pyrite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("pyrite", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Phosphorous", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("pyrite", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Phosphorous", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 5), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("pyrite", 2), ItemDustsSmall.getSmallDustByName("Sulfur", 1), ItemDustsSmall.getSmallDustByName("Phosphorous", 1), new ItemStack(Items.bucket), 100, 120));

		//Cinnabar Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("cinnabar", 2), ItemDustsSmall.getSmallDustByName("Redstone", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("cinnabar", 2), ItemDustsSmall.getSmallDustByName("Redstone", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 6), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("cinnabar", 2), ItemDustsSmall.getSmallDustByName("Redstone", 1), ItemDustsSmall.getSmallDustByName("Glowstone", 1), new ItemStack(Items.bucket), 100, 120));

		//Sphalerite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("sphalerite", 2), ItemDustsSmall.getSmallDustByName("Zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("sphalerite", 2), ItemDustsSmall.getSmallDustByName("Zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("sphalerite", 2), ItemDustsSmall.getSmallDustByName("Zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("sphalerite", 2), ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("sphalerite", 2), ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 7), new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("sphalerite", 2), ItemDusts.getDustByName("zinc", 1), ItemDustsSmall.getSmallDustByName("YellowGarnet", 1), new ItemStack(Items.bucket), 100, 120));

		//Tungsten Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDustsSmall.getSmallDustByName("Silver", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDusts.getDustByName("silver", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDusts.getDustByName("silver", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 8), new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("tungsten", 2), ItemDustsSmall.getSmallDustByName("Manganese", 1), ItemDusts.getDustByName("silver", 2), new ItemStack(Items.bucket), 100, 120));

		//Sheldonite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("platinum", 2), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("platinum", 2), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("platinum", 2), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), null, new FluidStack(ModFluids.fluidMercury, 1000), ItemDusts.getDustByName("platinum", 3), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), ItemCells.getCellByName("mercury", 1), null, ItemDusts.getDustByName("platinum", 3), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 9), new ItemStack(ModItems.bucketMercury), null, ItemDusts.getDustByName("platinum", 3), ItemDustsSmall.getSmallDustByName("Iridium", 1), ItemDustsSmall.getSmallDustByName("Iridium", 1), new ItemStack(Items.bucket), 100, 120));

		//Peridot Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10), null, new FluidStack(FluidRegistry.WATER, 1000), ItemGems.getGemByName("peridot", 1), ItemDustsSmall.getSmallDustByName("Peridot", 6), ItemDustsSmall.getSmallDustByName("Pyrope", 2), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10), IC2Items.getItem("waterCell"), null, ItemGems.getGemByName("peridot", 1), ItemDustsSmall.getSmallDustByName("Peridot", 6), ItemDustsSmall.getSmallDustByName("Pyrope", 2), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 10), new ItemStack(Items.water_bucket), null, ItemGems.getGemByName("peridot", 1), ItemDustsSmall.getSmallDustByName("Peridot", 6), ItemDustsSmall.getSmallDustByName("Pyrope", 2), new ItemStack(Items.bucket), 100, 120));

		//Sodalite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("sodalite", 12), ItemDustsSmall.getSmallDustByName("Lazurite", 4), ItemDustsSmall.getSmallDustByName("Lapis", 4), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("sodalite", 12), ItemDustsSmall.getSmallDustByName("Lazurite", 4), ItemDustsSmall.getSmallDustByName("Lapis", 4), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 11), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("sodalite", 12), ItemDustsSmall.getSmallDustByName("Lazurite", 4), ItemDustsSmall.getSmallDustByName("Lapis", 4), new ItemStack(Items.bucket), 100, 120));

		//Tetrahedrite Ore
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), null, new FluidStack(FluidRegistry.WATER, 1000), ItemDusts.getDustByName("tetrahedrite", 2), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), IC2Items.getItem("waterCell"), null, ItemDusts.getDustByName("tetrahedrite", 2), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), new ItemStack(Items.water_bucket), null, ItemDusts.getDustByName("tetrahedrite", 2), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), new ItemStack(Items.bucket), 100, 120));

		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), null, new FluidStack(ModFluids.fluidSodiumpersulfate, 1000), ItemDusts.getDustByName("tetrahedrite", 3), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), null, 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), ItemCells.getCellByName("sodiumPersulfate", 1), null, ItemDusts.getDustByName("tetrahedrite", 3), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), IC2Items.getItem("cell"), 100, 120));
		RecipeHandler.addRecipe(new GrinderRecipe(new ItemStack(ModBlocks.ore, 1, 12), new ItemStack(ModItems.bucketSodiumpersulfate), null, ItemDusts.getDustByName("tetrahedrite", 3), ItemDustsSmall.getSmallDustByName("Antimony", 1), ItemDustsSmall.getSmallDustByName("Zinc", 1), new ItemStack(Items.bucket), 100, 120));
	}

	static void addImplosionCompressorRecipes() {
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemParts.getPartByName("iridiumAlloyIngot"), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 8), IC2Items.getItem("iridiumPlate"), ItemDusts.getDustByName("darkAshes", 4), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("diamond", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 32), new ItemStack(IC2Items.getItem("industrialDiamond").getItem(), 3), ItemDusts.getDustByName("darkAshes", 16), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(IC2Items.getItem("coalChunk"), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 8), IC2Items.getItem("industrialDiamond"), ItemDusts.getDustByName("darkAshes", 4), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("emerald", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), new ItemStack(Items.emerald, 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("sapphire", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), ItemGems.getGemByName("sapphire", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("ruby", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), ItemGems.getGemByName("ruby", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("yellowGarnet", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), ItemGems.getGemByName("yellowGarnet", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("redGarnet", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), ItemGems.getGemByName("redGarnet", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(ItemDusts.getDustByName("peridot", 4), new ItemStack(IC2Items.getItem("industrialTnt").getItem(), 24), ItemGems.getGemByName("peridot", 3), ItemDusts.getDustByName("darkAshes", 12), 20, 30));
	}

	static void addChemicalReactorRecipes() {
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("calcium", 1), ItemCells.getCellByName("carbon", 1), ItemCells.getCellByName("calciumCarbonate", 2), 240, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_nugget, 8), new ItemStack(Items.melon, 1), new ItemStack(Items.speckled_melon, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrogen", 1), ItemCells.getCellByName("carbon", 1), ItemCells.getCellByName("nitrocarbon", 2), 1500, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("carbon", 1), ItemCells.getCellByName("hydrogen", 4), ItemCells.getCellByName("methane", 5), 3500, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sulfur", 1), ItemCells.getCellByName("sodium", 1), ItemCells.getCellByName("sodiumSulfide", 2), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1), ItemDusts.getDustByName("phosphorous", 1), new ItemStack(IC2Items.getItem("fertilizer").getItem(), 3), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.ender_eye, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_nugget, 8), new ItemStack(Items.carrot, 1), new ItemStack(Items.golden_carrot, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("glyceryl", 1), ItemCells.getCellByName("diesel", 4), ItemCells.getCellByName("nitroDiesel", 5), 1000, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1), null, new ItemStack(IC2Items.getItem("fertilizer").getItem(), 1), 100, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.gold_ingot, 8), new ItemStack(Items.apple, 1), new ItemStack(Items.golden_apple, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Blocks.gold_block, 8), new ItemStack(Items.apple, 1), new ItemStack(Items.golden_apple, 1, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sodiumSulfide", 1), IC2Items.getItem("airCell"), ItemCells.getCellByName("sodiumPersulfate", 2), 2000, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.slime_ball, 1), new ItemStack(Items.magma_cream, 1), 40, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrocarbon", 1), IC2Items.getItem("waterCell"), ItemCells.getCellByName("glyceryl", 2), 580, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemDusts.getDustByName("calcite", 1), ItemDusts.getDustByName("sulfur", 1), new ItemStack(IC2Items.getItem("fertilizer").getItem(), 2), 100, 30));
		ItemStack waterCells = IC2Items.getItem("waterCell").copy();
		waterCells.stackSize = 2;
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("sulfur", 1), waterCells, ItemCells.getCellByName("sulfuricAcid", 3), 1140, 30));
		ItemStack waterCells2 = IC2Items.getItem("waterCell").copy();
		waterCells2.stackSize = 5;
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("hydrogen", 4), IC2Items.getItem("airCell"), waterCells2, 10, 30));
		RecipeHandler.addRecipe(new ChemicalReactorRecipe(ItemCells.getCellByName("nitrogen", 1), IC2Items.getItem("airCell"), ItemCells.getCellByName("nitrogenDioxide", 2), 1240, 30));
	}

	static void addIndustrialElectrolyzerRecipes() {
		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("sulfuricAcid", 7),
				null,
				ItemCells.getCellByName("hydrogen", 2),
				ItemDusts.getDustByName("sulfur"),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 5),
				new ItemStack(IC2Items.getItem("cell").getItem(), 3, 0),
				400, 90
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("nitrocarbon", 2),
				null,
				ItemCells.getCellByName("nitrogen"),
				ItemCells.getCellByName("carbon"),
				null,
				null,
				80, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("ruby", 6),
				IC2Items.getItem("cell"),
				ItemDusts.getDustByName("aluminum", 2),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				ItemDusts.getDustByName("chrome", 1),
				null,
				140, 90
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("sapphire", 5),
				IC2Items.getItem("cell"),
				ItemDusts.getDustByName("aluminum", 2),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				null,
				null,
				100, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("nitrogenDioxide", 3),
				null,
				ItemCells.getCellByName("nitrogen", 1),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				null,
				IC2Items.getItem("cell"),
				160, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("sodiumSulfide", 2),
				null,
				ItemCells.getCellByName("sodium", 1),
				ItemDusts.getDustByName("sulfur", 1),
				null,
				IC2Items.getItem("cell"),
				200, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("greenSapphire", 5),
				IC2Items.getItem("cell"),
				ItemDusts.getDustByName("aluminum", 2),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				null,
				null,
				100, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("emerald", 29),
				new ItemStack(IC2Items.getItem("cell").getItem(), 18, 0),
				ItemCells.getCellByName("berylium", 3),
				ItemDusts.getDustByName("aluminum", 2),
				ItemCells.getCellByName("silicon", 6),
				new ItemStack(IC2Items.getItem("cell").getItem(), 9, 5),
				520, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				new ItemStack(IC2Items.getItem("silicondioxideDust").getItem(), 3, 0),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 0),
				ItemCells.getCellByName("silicon", 1),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				null,
				null,
				60, 60
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(new ItemStack(Items.dye, 3, 15),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 0),
				null,
				ItemCells.getCellByName("calcium", 1),
				null,
				null,
				20, 106
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("glyceryl", 20),
				null,
				ItemCells.getCellByName("carbon", 3),
				ItemCells.getCellByName("hydrogen", 5),
				ItemCells.getCellByName("nitrogen", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 9, 0),
				800, 90
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("peridot", 9),
				new ItemStack(IC2Items.getItem("cell").getItem(), 4, 0),
				ItemDusts.getDustByName("magnesium", 2),
				ItemDusts.getDustByName("iron"),
				ItemCells.getCellByName("silicon", 2),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 5),
				200, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("calciumCarbonate", 5),
				null,
				ItemCells.getCellByName("carbon"),
				ItemCells.getCellByName("calcium"),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 0),
				400, 90
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemCells.getCellByName("sodiumPersulfate", 6),
				null,
				ItemCells.getCellByName("sodium"),
				ItemDusts.getDustByName("sulfur"),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 5),
				new ItemStack(IC2Items.getItem("cell").getItem(), 3, 0),
				420, 90
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("pyrope", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 9, 0),
				ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("magnesium", 3),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				400, 120
		));

		ItemStack sand = new ItemStack(Blocks.sand);
		sand.stackSize = 16;

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				sand,
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 0),
				ItemCells.getCellByName("silicon", 1),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				null,
				null,
				1000, 25
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("almandine", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 9, 0),
				ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("iron", 3),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				480, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("spessartine", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 9, 0),
				ItemDusts.getDustByName("aluminum", 2),
				ItemDusts.getDustByName("manganese", 3),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				480, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("andradite", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 12, 0),
				ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("iron", 2),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				480, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("grossular", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 12, 0),
				ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("aluminum", 2),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				440, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("Uvarovite", 20),
				new ItemStack(IC2Items.getItem("cell").getItem(), 12, 0),
				ItemCells.getCellByName("calcium", 3),
				ItemDusts.getDustByName("chrome", 2),
				ItemCells.getCellByName("silicon", 3),
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 5),
				480, 120
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				new ItemStack(IC2Items.getItem("cell").getItem(), 6, 10),
				null,
				ItemCells.getCellByName("hydrogen", 4),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 5),
				new ItemStack(IC2Items.getItem("cell").getItem(), 1, 0),
				null,
				100, 30
		));

		RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
				ItemDusts.getDustByName("darkAshes"),
				new ItemStack(IC2Items.getItem("cell").getItem(), 2, 0),
				ItemCells.getCellByName("carbon", 2),
				null,
				null,
				null,
				20, 30
		));

		if (OreDictionary.doesOreNameExist("dustSalt")) {
			ItemStack salt = OreDictionary.getOres("dustSalt").get(0);
			salt.stackSize = 2;
			RecipeHandler.addRecipe(new IndustrialElectrolyzerRecipe(
					salt,
					new ItemStack(IC2Items.getItem("cell").getItem(), 2, 0),
					ItemCells.getCellByName("sodium"),
					ItemCells.getCellByName("chlorine"),
					null,
					null,
					40, 60
			));
		}


	}
}
