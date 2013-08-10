package galaxyblast.worldGen;

import galaxyblast.blocks.InitBlocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class worldGenOres implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case 0: genSurface(world, chunkX*16, chunkZ*16, random);
		}
	}

	private void genSurface(World world, int x, int z, Random rand)
	{
		for(int i = 0;i < 8;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(128);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.copper.blockID, 16).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 8;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(64);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.silver.blockID, 10).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 8;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(64);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.tin.blockID, 10).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 2;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(32);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.titanium.blockID, 6).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 2;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(32);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.ruby.blockID, 8).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 2;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(32);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.sapphire.blockID, 8).generate(world, rand, posX, posY, posZ);
		}
		
		for(int i = 0;i < 2;i++)
		{
			int posX = rand.nextInt(16) + x;
			int posY = rand.nextInt(16);
			int posZ = rand.nextInt(16) + z;
			
			new WorldGenMinable(InitBlocks.tungsten.blockID, 6).generate(world, rand, posX, posY, posZ);
		}
	}

}
