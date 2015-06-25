package techreborn.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import techreborn.client.SlotFake;
import techreborn.client.SlotFluid;
import techreborn.client.SlotOutput;
import techreborn.tiles.TileQuantumTank;

public class ContainerQuantumTank extends TechRebornContainer {
	public TileQuantumTank tileQuantumTank;
	public EntityPlayer player;

	public ContainerQuantumTank(TileQuantumTank tileQuantumTank,
			EntityPlayer player)
	{
		super();
		this.tileQuantumTank = tileQuantumTank;
		this.player = player;

		this.addSlotToContainer(new SlotFluid(tileQuantumTank.inventory, 0, 80, 17));
		this.addSlotToContainer(new SlotOutput(tileQuantumTank.inventory, 1,
				80, 53));
		this.addSlotToContainer(new SlotFake(tileQuantumTank.inventory, 2, 59,
				42, false, false, 1));

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
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
}
