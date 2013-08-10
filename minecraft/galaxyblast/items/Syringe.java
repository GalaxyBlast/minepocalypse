package galaxyblast.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import galaxyblast.Minepocalypse;
import galaxyblast.diseases.Diseases;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class Syringe extends Item
{

	public Syringe(int par1)
	{
		super(par1);
		this.setMaxStackSize(16);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(this.itemID == Minepocalypse.syringe.itemID)
		{
            par3EntityPlayer.attackEntityFrom(DamageSource.magic, 1F);
            par3EntityPlayer.heal(1F);
            par1ItemStack.stackSize--;
            if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Minepocalypse.blood)))
            {
                par3EntityPlayer.dropPlayerItem(new ItemStack(Minepocalypse.blood));
            }
		}
		else
		{
			//par3EntityPlayer.addPotionEffect(new PotionEffect(Diseases.cold.id, 6000, 0));
		}
        return par1ItemStack;
    }

	@Override
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Minepocalypse.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
