package galaxyblast.npcs;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RoamingBandit extends RoamingSurvivor
{

	public RoamingBandit(World par1World)
	{
		super(par1World);
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false));
	}

	protected void addRandomArmor()
    {
		 if (this.rand.nextFloat() != 99)
	        {
	            int i = 1;
	            float f = this.worldObj.difficultySetting == 3 ? 0.1F : 0.25F;

	            if (this.rand.nextFloat() < 0.75F)
	            {
	                ++i;
	            }

	            if (this.rand.nextFloat() < 0.25F)
	            {
	                ++i;
	            }

	            if (this.rand.nextFloat() < 0.055F)
	            {
	                ++i;
	            }

	            for (int j = 3; j >= 0; --j)
	            {
	                ItemStack itemstack = this.func_130225_q(j);

	                if (itemstack == null)
	                {
	                    Item item = getArmorItemForSlot(j + 1, i);

	                    if (item != null)
	                    {
	                        this.setCurrentItemOrArmor(j + 1, new ItemStack(item));
	                    }
	                }
	            }
	        }
		 this.setCurrentItemOrArmor(0, new ItemStack(Item.swordIron));
    }
}
