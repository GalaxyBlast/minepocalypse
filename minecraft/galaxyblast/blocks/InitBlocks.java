package galaxyblast.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InitBlocks
{
	public static Block copper;
	public static Block silver;
	
	public static void Init()
	{
		copper = new BasicBlock(1360, Material.rock, 1F).setUnlocalizedName("copper");
		silver = new BasicBlock(1361, Material.rock, 1.2F).setUnlocalizedName("silver");
		
		register();
		name();
	}
	
	private static void register()
	{
		GameRegistry.registerBlock(copper, "copper");
		GameRegistry.registerBlock(silver, "silver");
	}
	
	private static void name()
	{
		LanguageRegistry.addName(copper, "Copper Ore");
		LanguageRegistry.addName(silver, "Silver Ore");
	}
}
