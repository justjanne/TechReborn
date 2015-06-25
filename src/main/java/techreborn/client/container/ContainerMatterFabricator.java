package techreborn.client.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import techreborn.client.SlotOutput;
import techreborn.tiles.TileMatterFabricator;

public class ContainerMatterFabricator extends TechRebornContainer{
	
	EntityPlayer player;

	TileMatterFabricator tile;

	public int progressTime;

	public ContainerMatterFabricator(TileMatterFabricator tileMatterfab,
			EntityPlayer player)
	{
		tile = tileMatterfab;
		this.player = player;

		// input
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 0, 33, 17));
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 1, 33, 35));
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 2, 33, 53));
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 3, 51, 17));
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 4, 51, 35));
		this.addSlotToContainer(new Slot(tileMatterfab.inventory, 5, 51, 53));

		// outputs
		this.addSlotToContainer(new SlotOutput(tileMatterfab.inventory, 6,
				116, 35));

		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9
						+ 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18,
					142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if (this.progressTime != tile.progresstime) {
				icrafting.sendProgressBarUpdate(this, 0, tile.progresstime);
			}
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, tile.progresstime);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int value) {
		if (id == 0) {
			this.progressTime = value;
		}
	}

	public int getProgressScaled(int scale) {
		if(progressTime != 0) {
			return progressTime * scale / tile.maxProgresstime();
		}
		return 0;
	}

}
