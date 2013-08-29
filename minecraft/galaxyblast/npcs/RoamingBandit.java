package galaxyblast.npcs;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RoamingBandit extends EntityZombie
{

	public RoamingBandit(World par1World)
	{
		super(par1World);
	}

	@Override
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
	
	@Override
	public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                boolean flag = true;
                ItemStack itemstack = this.getCurrentItemOrArmor(4);

                if (itemstack != null)
                {
                    if (itemstack.isItemStackDamageable())
                    {
                        itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

                        if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage())
                        {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }

                    flag = false;
                }
            }
        }

        super.onLivingUpdate();
    }
	
	@Override
	protected String getLivingSound()
    {
        return "";
    }

	@Override
    protected String getHurtSound()
    {
        return "";
    }

	@Override
    protected String getDeathSound()
    {
        return "";
    }
}
