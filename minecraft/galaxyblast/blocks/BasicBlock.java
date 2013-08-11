package galaxyblast.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import galaxyblast.Minepocalypse;
import galaxyblast.items.InitItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block
{
	public BasicBlock(int par1, Material par2Material, float hard)
	{
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hard);
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
		if(this.blockID == InitBlocks.ruby.blockID)
			return InitItems.ruby.itemID;
		else if(this.blockID == InitBlocks.sapphire.blockID)
			return InitItems.sapphire.itemID;
		else
			return this.blockID;
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Minepocalypse.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
