package galaxyblast.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class InitBlocks
{
	public static Block copper;
	public static Block silver;
	public static Block tin;
	public static Block titanium;
	public static Block ruby;
	public static Block sapphire;
	public static Block tungsten;
	
	public static void Init()
	{
		copper = new BasicBlock(1360, Material.rock, 1F).setUnlocalizedName("copper");
		silver = new BasicBlock(1361, Material.rock, 1.2F).setUnlocalizedName("silver");
		tin = new BasicBlock(1362, Material.rock, 1F).setUnlocalizedName("tin");
		titanium = new BasicBlock(1363, Material.rock, 15F).setUnlocalizedName("titanium");
		ruby = new BasicBlock(1364, Material.rock, 2.5F).setUnlocalizedName("ruby");
		sapphire = new BasicBlock(1365, Material.rock, 2.5F).setUnlocalizedName("sapphire");
		tungsten = new BasicBlock(1366, Material.rock, 12F).setUnlocalizedName("tungsten");
		
		register();
		name();
		harvest();
	}
	
	private static void harvest()
	{
		MinecraftForge.setBlockHarvestLevel(silver, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(titanium, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(ruby, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(sapphire, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tungsten, "pickaxe", 2);
	}

	private static void register()
	{
		GameRegistry.registerBlock(copper, "copper");
		GameRegistry.registerBlock(silver, "silver");
		GameRegistry.registerBlock(tin, "tin");
		GameRegistry.registerBlock(titanium, "titanium");
		GameRegistry.registerBlock(ruby, "ruby");
		GameRegistry.registerBlock(sapphire, "sapphire");
		GameRegistry.registerBlock(tungsten, "tungsten");
	}
	
	private static void name()
	{
		LanguageRegistry.addName(copper, "Copper Ore");
		LanguageRegistry.addName(silver, "Silver Ore");
		LanguageRegistry.addName(tin, "Tin Ore");
		LanguageRegistry.addName(titanium, "Titanium Ore");
		LanguageRegistry.addName(ruby, "Ruby Ore");
		LanguageRegistry.addName(sapphire, "Sapphire Ore");
		LanguageRegistry.addName(tungsten, "Tungsten Ore");
	}
}
