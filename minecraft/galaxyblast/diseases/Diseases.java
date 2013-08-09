package galaxyblast.diseases;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class Diseases
{
	private static Random rand = new Random();
	
	public static final Potion cold = new Potion(32, false, 0).setPotionName("The Common Cold").setIconIndex(3, 1);
	public static final Potion flu = new Potion(33, true, 0).setPotionName("The Flu").setIconIndex(3, 1);
	public static final Potion rsv = new Potion(34, false, 0).setPotionName("RSV").setIconIndex(3, 1);
	
	public static final Potion asthma = new Potion(35, true, 0).setPotionName("Asthma");
	public static final Potion infected = new Potion(36, true, 0).setPotionName("Infected");
	
	public static void updateDiseases(EntityPlayer par1)
	{
		/** --- Disabled for now, make sure to re-enable for BETA release ---
		//RODs (Randomly Obtained Diseases)
		if(rand.nextInt(35000) == 45 && !par1.isPotionActive(cold.id))
		{
			par1.addPotionEffect(new PotionEffect(cold.id, 12000, 0));
    		par1.addChatMessage("You've caught the common cold!");
		}
		if(rand.nextInt(10000) == 35 && par1.isPotionActive(cold.id) || rand.nextInt(250000) == 55)
		{
			par1.addPotionEffect(new PotionEffect(flu.id, 6000, 0));
    		par1.addChatMessage("You've caught the flu!");
		}
		if(rand.nextInt(500000) == 73 && !par1.isPotionActive(rsv.id))
		{
			par1.addPotionEffect(new PotionEffect(rsv.id, 12000, 0));
    		par1.addChatMessage("You've caught rsv!");
		}
		
		//potion effects
		//flu
		if(par1.isPotionActive(flu.id))
		{
			par1.landMovementFactor = 0.05F;
    		par1.foodStats.addExhaustion(0.05F);
		}
		//rsv
		if(par1.isPotionActive(rsv.id))
		{
			if(rand.nextInt(5000) == 12)
			{
				par1.attackEntityFrom(DamageSource.drown, 1.0F);
			}
		}
		if(par1.isPotionActive(asthma.id))
		{
			if(par1.getAir() > 150)
				par1.setAir(150);
		}
		if(par1.isPotionActive(infected.id))
		{
			par1.foodStats.addExhaustion(0.1F);
			if(rand.nextInt(15000) == 33)
			{
				par1.attackEntityFrom(DamageSource.magic, 1.0F);
			}
		}*/
	}
}
