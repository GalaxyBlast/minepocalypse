package galaxyblast.items;

import net.minecraft.item.Item;

public class InitItems
{
	public static Item copperIngot;
	public static Item silverIngot;
	public static Item steelIngot;
	
	public static void Init()
	{
		Currency.load();
	}
}
