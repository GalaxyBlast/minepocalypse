package galaxyblast;

import galaxyblast.models.ModelSurvivor;
import galaxyblast.npcs.RoamingSurvivor;
import galaxyblast.render.RenderSurvivor;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(RoamingSurvivor.class, new RenderSurvivor(new ModelSurvivor(), 0.3F));
	}
}
