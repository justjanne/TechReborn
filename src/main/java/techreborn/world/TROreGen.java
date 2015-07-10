package techreborn.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;
import techreborn.util.LogHelper;

import java.util.Random;

public class TROreGen implements IWorldGenerator {
	public static ConfigTechReborn config;

	WorldGenMinable oreGalena;
	WorldGenMinable oreIridium;
	WorldGenMinable oreRuby;
	WorldGenMinable oreSapphire;
	WorldGenMinable oreBauxite;
	WorldGenMinable orePyrite;
	WorldGenMinable oreCinnabar;
	WorldGenMinable oreSphalerite;
	WorldGenMinable oreTungston;
	WorldGenMinable oreSheldonite;
	WorldGenMinable orePeridot;
	WorldGenMinable oreSodalite;
	WorldGenMinable oreTetrahedrite;
	WorldGenMinable oreCassiterite;
	WorldGenMinable oreLead;
	WorldGenMinable oreSilver;

	public TROreGen(){
		// World
		oreGalena = new WorldGenMinable(ModBlocks.ore, 0, ConfigTechReborn.GalenaOreRare, Blocks.stone);
		oreIridium = new WorldGenMinable(ModBlocks.ore, 1, ConfigTechReborn.IridiumOreRare, Blocks.stone);
		oreRuby = new WorldGenMinable(ModBlocks.ore, 2, ConfigTechReborn.RubyOreRare, Blocks.stone);
		oreSapphire = new WorldGenMinable(ModBlocks.ore, 3, ConfigTechReborn.SapphireOreRare, Blocks.stone);
		oreBauxite = new WorldGenMinable(ModBlocks.ore, 4, ConfigTechReborn.BauxiteOreRare, Blocks.stone);
		oreTetrahedrite = new WorldGenMinable(ModBlocks.ore, 12, ConfigTechReborn.TetrahedriteOreRare, Blocks.stone);
		oreCassiterite = new WorldGenMinable(ModBlocks.ore, 13, ConfigTechReborn.CassiteriteOreRare, Blocks.stone);
		oreLead = new WorldGenMinable(ModBlocks.ore, 14, ConfigTechReborn.LeadOreRare, Blocks.stone);
		oreSilver = new WorldGenMinable(ModBlocks.ore, 15, ConfigTechReborn.SilverOreRare, Blocks.stone);

		// Nether
		orePyrite = new WorldGenMinable(ModBlocks.ore, 5, ConfigTechReborn.PyriteOreRare, Blocks.netherrack);
		oreCinnabar = new WorldGenMinable(ModBlocks.ore, 6, ConfigTechReborn.CinnabarOreRare, Blocks.netherrack);
		oreSphalerite = new WorldGenMinable(ModBlocks.ore, 7, ConfigTechReborn.SphaleriteOreRare, Blocks.netherrack);
		
		// End
		oreTungston = new WorldGenMinable(ModBlocks.ore, 8, ConfigTechReborn.TungstenOreRare, Blocks.end_stone);
		oreSheldonite = new WorldGenMinable(ModBlocks.ore, 9, ConfigTechReborn.SheldoniteOreRare, Blocks.end_stone);
		orePeridot = new WorldGenMinable(ModBlocks.ore, 10, ConfigTechReborn.PeridotOreRare, Blocks.end_stone);
		oreSodalite = new WorldGenMinable(ModBlocks.ore, 11, ConfigTechReborn.SodaliteOreRare, Blocks.end_stone);
		
		LogHelper.info("WorldGen Loaded");
	}
	
	public void retroGen(Random random, int chunkX, int chunkZ, World world) {
		//TODO
		generateUndergroundOres(random, chunkX, chunkZ, world);
		generateHellOres(random, chunkX, chunkZ, world);
		generateEndOres(random, chunkX, chunkZ, world);
		world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
	}

	@Override
	public void generate(Random random, int xChunk, int zChunk, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		if (world.provider.isSurfaceWorld()){
			generateUndergroundOres(random, xChunk * 16, zChunk * 16, world);
			} else if (world.provider.isHellWorld){
				generateHellOres(random, xChunk * 16, zChunk * 16, world);
			} else if (world.provider.dimensionId == 1){
			generateEndOres(random, xChunk * 16, zChunk * 16, world);
		}

	}

	void generateUndergroundOres(Random random, int xChunk, int zChunk, World world)
	{
		int xPos, yPos, zPos;
		if (config.GalenaOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreGalena.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.IridiumOreTrue){
			for (int i = 0; i <= 1; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(1);
				oreIridium.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.RubyOreTrue){
			for (int i = 0; i <= 3; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreRuby.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SapphireOreTrue){
			for (int i = 0; i <= 3; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreSapphire.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.BauxiteOreTrue){
			for (int i = 0; i <= 10; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreBauxite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.TetrahedriteOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreTetrahedrite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.CassiteriteOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreCassiterite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.LeadOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreLead.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SilverOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 20);
				zPos = zChunk + random.nextInt(16);
				oreSilver.generate(world, random, xPos, yPos, zPos);
			}
		}
	}

	void generateHellOres(Random random, int xChunk, int zChunk, World world){
		int xPos, yPos, zPos;
		if (config.PyriteOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				orePyrite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.CinnabarOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreCinnabar.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SphaleriteOreTrue){
			for (int i = 0; i <= 16; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreSphalerite.generate(world, random, xPos, yPos, zPos);
			}
		}
	}

	void generateEndOres(Random random, int xChunk, int zChunk, World world){
		int xPos, yPos, zPos;
		if (config.TungstenOreTrue){
			for (int i = 0; i <= 2; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreTungston.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SheldoniteOreTrue){
			for (int i = 0; i <= 3; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreSheldonite.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.PeridotOreTrue){
			for (int i = 0; i <= 3; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				orePeridot.generate(world, random, xPos, yPos, zPos);
			}
		}
		if (config.SodaliteOreTrue){
			for (int i = 0; i <= 3; i++){
				xPos = xChunk + random.nextInt(16);
				yPos = 10 + random.nextInt(60 - 10);
				zPos = zChunk + random.nextInt(16);
				oreSodalite.generate(world, random, xPos, yPos, zPos);
			}
		}
	}
}
