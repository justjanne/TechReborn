package techreborn.items;

import java.security.InvalidParameterException;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import techreborn.client.TechRebornCreativeTabMisc;
import techreborn.init.ModItems;

public class ItemPlates extends ItemTR {
		
	public static ItemStack getPlateByName(String name, int count)
	{
		for (int i = 0; i < types.length; i++) {
			if (types[i].equalsIgnoreCase(name)) {
				return new ItemStack(ModItems.plate, count, i);
			}
		}
		throw new InvalidParameterException("The plate " + name + " could not be found.");
	}
	
	public static ItemStack getPlateByName(String name)
	{
		return getPlateByName(name, 1);
	}
	
	public static final String[] types = new String[]
	{ "aluminum", "batteryAlloy", "brass", "bronze", "carbon",
			"chrome", "coal", "copper", "diamond", "electrum", "emerald",
			"gold", "invar", "iridium", "iron", "lapis", "lead",
			"magnalium", "nickel", "obsidian", "osmium",
			"peridot", "platinum", "redGarnet", "redstone",
			"ruby", "sapphire", "silicon", "silver", "steel",
			"teslatite", "tin", "titanium", "tungsten", "tungstensteel",
			"yellowGarnet", "zinc" };

	private IIcon[] textures;

	public ItemPlates()
	{
		setUnlocalizedName("techreborn.plate");
		setHasSubtypes(true);
		setCreativeTab(TechRebornCreativeTabMisc.instance);
	}

	@Override
	// Registers Textures For All Dusts
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[types.length];

		for (int i = 0; i < types.length; ++i)
		{
			textures[i] = iconRegister.registerIcon("techreborn:" + "plate/"
					+ types[i] + "Plate");
		}
	}

	@Override
	// Adds Texture what match's meta data
	public IIcon getIconFromDamage(int meta)
	{
		if (meta < 0 || meta >= textures.length)
		{
			meta = 0;
		}

		return textures[meta];
	}

	@Override
	// gets Unlocalized Name depending on meta data
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= types.length)
		{
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + types[meta];
	}

	// Adds Dusts SubItems To Creative Tab
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int meta = 0; meta < types.length; ++meta)
		{
			list.add(new ItemStack(item, 1, meta));
		}
	}

}
