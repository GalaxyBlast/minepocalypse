package galaxyblast.npcs;

import galaxyblast.items.InitItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RoamingSurvivor extends EntityCreature
{
	
	public RoamingSurvivor(World par1World)
	{
		super(par1World);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(0, new EntityAIWander(this, 1D));
        //this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 0.5D));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1D, true));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 1D, true));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntitySpider.class, 1D, true));
        //this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, false));
        this.addRandomArmor();
	}
	
	public int getMaxHealth()
	{
		return 20;
	}
	
	public int getAttackStrength(Entity par1Entity)
    {
		return 2;
    }
	
	protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
    }
	
	public boolean getCanSpawnHere()
    {
		if(this.rand.nextInt(100) < 10)
			return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
		else
			return false;
    }
	
	public boolean isAIEnabled()
    {
        return true;
    }
	
	protected void addRandomArmor()
    {
		 if (this.rand.nextFloat() != 99)
	        {
	            int i = 0;
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
	            
	            if (this.rand.nextFloat() < 0.005F)
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
		 this.setCurrentItemOrArmor(0, new ItemStack(Item.swordStone));
    }

	protected void dropFewItems(boolean par1, int par2)
    {
        super.dropFewItems(par1, par2);

        for(int i = 0;i < 5;i++)
        {
        	this.dropItem(this.getCurrentItemOrArmor(i).itemID, 1);
        }
        
        if(this.rand.nextFloat() < 0.9)
        {
        	this.dropItem(InitItems.copperIngot.itemID, this.rand.nextInt(12));
        }
        
        if(this.rand.nextFloat() < 0.75)
        {
        	this.dropItem(Item.axeStone.itemID, 1);
        }
        
        if(this.rand.nextFloat() < 0.6)
        {
        	this.dropItem(InitItems.silverIngot.itemID, this.rand.nextInt(12));
        }
        
        if(this.rand.nextFloat() < 0.5)
        {
        	this.dropItem(Item.pickaxeIron.itemID, 1);
        }
        
        if(this.rand.nextFloat() < 0.65)
        {
        	this.dropItem(Item.stick.itemID, this.rand.nextInt(15));
        }
        
        if(this.rand.nextFloat() < 0.5)
        {
        	this.dropItem(Block.planks.blockID, this.rand.nextInt(32));
        }
        
        if(this.rand.nextFloat() < 0.5)
        {
        	this.dropItem(Block.cobblestone.blockID, this.rand.nextInt(48));
        }
        
        if(this.rand.nextFloat() < 0.5)
        {
        	this.dropItem(Item.bread.itemID, this.rand.nextInt(12));
        }
        
        if(this.rand.nextFloat() < 0.6)
        {
        	this.dropItem(Item.ingotIron.itemID, this.rand.nextInt(12));
        }
        
        if(this.rand.nextFloat() < 0.33)
        {
        	this.dropItem(Item.ingotGold.itemID, this.rand.nextInt(16));
        }
        
        if(this.rand.nextFloat() < 0.1)
        {
        	this.dropItem(Item.diamond.itemID, this.rand.nextInt(8));
        }
    }
	
	public boolean isChild()
    {
        return false;
    }
	
	protected boolean canDespawn()
    {
        return false;
    }
}
