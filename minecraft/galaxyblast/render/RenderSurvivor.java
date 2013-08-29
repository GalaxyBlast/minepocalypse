package galaxyblast.render;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import galaxyblast.models.ModelSurvivor;
import galaxyblast.npcs.RoamingSurvivor;

public class RenderSurvivor extends RenderBiped
{
	protected ModelSurvivor model;

	public RenderSurvivor(ModelSurvivor modelSurvivor, float f)
	{
		super(modelSurvivor, f);
		model = ((ModelSurvivor) mainModel);
	}

	public void renderSurvivor(RoamingSurvivor entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		renderSurvivor((RoamingSurvivor) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		renderSurvivor((RoamingSurvivor) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return new ResourceLocation("textures/entity/survivor.png");
	}

}
