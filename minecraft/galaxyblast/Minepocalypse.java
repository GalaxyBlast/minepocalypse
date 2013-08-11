package galaxyblast;

import galaxyblast.blocks.InitBlocks;
import galaxyblast.items.*;
import galaxyblast.worldGen.worldGenOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.*;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Minepocalypse", name = "§5Minepocalypse", version = "0.2.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Minepocalypse
{
	public static final String modid = "minepocalypse";
	
	@Instance("Minepocalypse")
	public static Minepocalypse instance = new Minepocalypse();
	
	@SidedProxy(clientSide = "galaxyblast.ClientProxy", serverSide = "galaxyblast.CommonProxy")
	
	public static CommonProxy proxy;
	
	//items
	public static final Item syringe = new Syringe(15000).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("syringe");
	public static final Item blood = new Syringe(15001).setUnlocalizedName("blood");
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		LocalizedNames.LocalizeNames();
		InitBlocks.Init();
		InitItems.Init();
		
		GameRegistry.registerWorldGenerator(new worldGenOres());
		
		EntityRegistry.addSpawn(EntityZombie.class, 100, 2, 4, EnumCreatureType.monster, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityZombie.class, 80, 4, 8, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills);
		EntityRegistry.addSpawn(EntityZombie.class, 30, 15, 30, EnumCreatureType.monster, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.jungle);
		
		//pig zombies
		EntityRegistry.addSpawn(EntityPigZombie.class, 40, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.forest);
		
		//creepers
		EntityRegistry.addSpawn(EntityCreeper.class, 30, 2, 4, EnumCreatureType.monster, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.jungle, BiomeGenBase.desert);
		
		//spiders
		EntityRegistry.addSpawn(EntitySpider.class, 65, 2, 4, EnumCreatureType.monster, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills);
	}
}
