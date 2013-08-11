package galaxyblast.items;

import galaxyblast.blocks.InitBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InitItems
{
	public static Item copperIngot;
	public static Item silverIngot;
	public static Item steelIngot;
	public static Item tinIngot;
	public static Item titaniumIngot;
	public static Item ruby;
	public static Item sapphire;
	public static Item tungstenIngot;
	
	public static void Init()
	{
		copperIngot = new BasicItem(16810).setUnlocalizedName("copperIngot");
		silverIngot = new BasicItem(16811).setUnlocalizedName("silverIngot");
		steelIngot = new BasicItem(16812).setUnlocalizedName("steelIngot");
		tinIngot = new BasicItem(16813).setUnlocalizedName("tinIngot");
		titaniumIngot = new BasicItem(16814).setUnlocalizedName("titaniumIngot");
		ruby = new BasicItem(16815).setUnlocalizedName("ruby");
		sapphire = new BasicItem(16816).setUnlocalizedName("sapphire");
		tungstenIngot = new BasicItem(16817).setUnlocalizedName("tungstenIngot");
		
		Currency.load();
		
		names();
		smelting();
	}

	private static void smelting()
	{
		GameRegistry.addSmelting(InitBlocks.copper.blockID, new ItemStack(copperIngot), 0.4F);
		GameRegistry.addSmelting(InitBlocks.silver.blockID, new ItemStack(silverIngot), 0.4F);
		GameRegistry.addSmelting(InitBlocks.tin.blockID, new ItemStack(tinIngot), 0.6F);
		GameRegistry.addSmelting(InitBlocks.titanium.blockID, new ItemStack(titaniumIngot), 1F);
		GameRegistry.addSmelting(InitBlocks.tungsten.blockID, new ItemStack(tungstenIngot), 1.4F);
	}

	private static void names()
	{
		LanguageRegistry.addName(copperIngot, "Copper Ingot");
		LanguageRegistry.addName(silverIngot, "Silver Ingot");
		LanguageRegistry.addName(steelIngot, "Steel Ingot");
		LanguageRegistry.addName(tinIngot, "Tin Ingot");
		LanguageRegistry.addName(titaniumIngot, "Titanium Ingot");
		LanguageRegistry.addName(ruby, "Ruby");
		LanguageRegistry.addName(sapphire, "Sapphire");
		LanguageRegistry.addName(tungstenIngot, "Tungsten Ingot");
	}
}
