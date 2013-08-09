package galaxyblast;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizedNames
{
	protected static Minepocalypse a;
	
	public static void LocalizeNames()
	{
		LanguageRegistry.addName(a.syringe, "Syringe");
		LanguageRegistry.addName(a.blood, "Blood Sample");
	}
}
