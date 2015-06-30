package techreborn.tiles;

import ic2.api.energy.prefab.BasicSink;
import ic2.api.energy.tile.IEnergyTile;
import ic2.api.tile.IWrenchable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import techreborn.api.TechRebornAPI;
import techreborn.api.recipe.RecipeCrafter;
import techreborn.api.upgrade.UpgradeHandler;
import techreborn.blocks.BlockMachineCasing;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;
import techreborn.lib.Location;
import techreborn.util.Inventory;
import techreborn.util.ItemUtils;

public class TileBlastFurnace extends TileMachineBase implements IWrenchable, IInventory, IEnergyTile, ISidedInventory {

	public int tickTime;
	public BasicSink energy;
	public Inventory inventory = new Inventory(4, "TileBlastFurnace", 64);
	public RecipeCrafter crafter;
	public static int euTick = 5;
	
	public TileBlastFurnace() {
		//TODO configs
		energy = new BasicSink(this, 1000,ConfigTechReborn.CentrifugeTier);
		int[] inputs = new int[2];
		inputs[0] = 0;
		inputs[1] = 1;
		int[] outputs = new int[2];
		outputs[0] = 2;
		outputs[1] = 3;
		crafter = new RecipeCrafter("blastFurnaceRecipe", this, energy, 2, 2, inventory, inputs, outputs);
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		energy.updateEntity();
		crafter.updateEntity();
	}

	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
		return false;
	}

	@Override
	public short getFacing() {
		return 0;
	}

	@Override
	public void setFacing(short facing) {
	}

	@Override
	public boolean wrenchCanRemove(EntityPlayer entityPlayer)
	{
		if (entityPlayer.isSneaking())
		{
			return true;
		}
		return false;
	}

	@Override
	public float getWrenchDropRate() {
		return 1.0F;
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(ModBlocks.BlastFurnace, 1);
	}

	public int getHeat() {
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity tileEntity = worldObj.getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
			if (tileEntity instanceof TileMachineCasing) {
				if ((tileEntity.getBlockType() instanceof BlockMachineCasing)) {
					int heat;
					heat = BlockMachineCasing.getHeatFromMeta(tileEntity.getBlockMetadata());
					Location location = new Location(xCoord, yCoord, zCoord, direction);
					location.modifyPositionFromSide(direction, 1);
					if (worldObj.getBlock(location.getX(), location.getY(), location.getZ()).getUnlocalizedName().equals("tile.lava")) {
						heat += 500;
					}
					return heat;
				}
			}
		}
		return 0;
	}


//	@Override
//	public void updateEntity(){
//		super.updateEntity();
//		energy.updateEntity();
//		if (getStackInSlot(0) != null && getStackInSlot(1) != null) {
//			if (recipe == null) {
//				for (BlastFurnaceRecipe furnaceRecipe : TechRebornAPI.blastFurnaceRecipes) {
//					if (ItemUtils.isItemEqual(getStackInSlot(0), furnaceRecipe.getInput1(), true, true) && ItemUtils.isItemEqual(getStackInSlot(1), furnaceRecipe.getInput2(), true, true)) {
//						recipe = furnaceRecipe;
//					}
//				}
//			} else {
//				if (!ItemUtils.isItemEqual(getStackInSlot(0), recipe.getInput1(), true, true) || !ItemUtils.isItemEqual(getStackInSlot(1), recipe.getInput2(), true, true)) {
//					recipe = null;
//					tickTime = 0;
//					return;
//				}
//				if (tickTime >= recipe.getTickTime()) {
//					//When both slots are empty
//					if (getStackInSlot(2) == null && getStackInSlot(3) == null) {
//						setInventorySlotContents(2, recipe.getOutput1());
//						setInventorySlotContents(3, recipe.getOutput2());
//						tickTime = 0;
//						recipe = null;
//					} else
//					//When both are the same as the recipe
//					if (ItemUtils.isItemEqual(getStackInSlot(2), recipe.getOutput1(), true, true) && ItemUtils.isItemEqual(getStackInSlot(3), recipe.getOutput2(), true, true) && !areBothOutputsFull()) {
//						decrStackSize(2, -recipe.getOutput1().stackSize);
//						decrStackSize(3, -recipe.getOutput2().stackSize);
//						tickTime = 0;
//						recipe = null;
//					} else
//					//When slot one has stuff and slot 2 is empty
//					if (ItemUtils.isItemEqual(getStackInSlot(2), recipe.getOutput1(), true, true) && getStackInSlot(3) == null) {
//						//Stops if the first slot if full
//						if (recipe.getOutput1() != null
//								&& getStackInSlot(2) != null
//								&& getStackInSlot(2).stackSize
//								+ recipe.getOutput1().stackSize > recipe
//								.getOutput1().getMaxStackSize()) {
//							return;
//						}
//						decrStackSize(2, recipe.getOutput1().stackSize);
//						setInventorySlotContents(3, recipe.getOutput2());
//						tickTime = 0;
//						recipe = null;
//					} else
//					//When slot 2 has stuff and slot 1 is empty
//					if (ItemUtils.isItemEqual(getStackInSlot(3), recipe.getInput2(), true, true) && getStackInSlot(2) == null) {
//						if (recipe.getOutput2() != null
//								&& getStackInSlot(3) != null
//								&& getStackInSlot(3).stackSize
//								+ recipe.getOutput2().stackSize > recipe
//								.getOutput1().getMaxStackSize()) {
//							return;
//						}
//						decrStackSize(3, recipe.getOutput2().stackSize);
//						setInventorySlotContents(2, recipe.getOutput1());
//						tickTime = 0;
//						recipe = null;
//					}
//				} else if (getHeat() >= recipe.getMinHeat()) {
//					if (energy.canUseEnergy(5)) {
//						tickTime++;
//						energy.useEnergy(5);
//					}
//				}
//			}
//		} else {
//			recipe = null;
//			tickTime = 0;
//		}
//	}
//
//	public boolean areBothOutputsFull() {
//		if (recipe.getOutput1() != null
//				&& getStackInSlot(2) != null
//				&& getStackInSlot(2).stackSize
//				+ recipe.getOutput1().stackSize > recipe
//				.getOutput1().getMaxStackSize()) {
//			return true;
//		}
//		if (recipe.getOutput2() != null
//				&& getStackInSlot(3) != null
//				&& getStackInSlot(3).stackSize
//				+ recipe.getOutput2().stackSize > recipe
//				.getOutput1().getMaxStackSize()) {
//			return true;
//		}
//		return false;
//	}

	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return inventory.getStackInSlot(p_70301_1_);
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		return inventory.decrStackSize(p_70298_1_, p_70298_2_);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return inventory.getStackInSlotOnClosing(p_70304_1_);
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		inventory.setInventorySlotContents(p_70299_1_, p_70299_2_);
	}

	@Override
	public String getInventoryName() {
		return inventory.getInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return inventory.hasCustomInventoryName();
	}

	@Override
	public int getInventoryStackLimit() {
		return inventory.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return inventory.isUseableByPlayer(p_70300_1_);
	}

	@Override
	public void openInventory() {
		inventory.openInventory();
	}

	@Override
	public void closeInventory() {
		inventory.closeInventory();
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return inventory.isItemValidForSlot(p_94041_1_, p_94041_2_);
	}

    @Override
    public void invalidate()
    {
        energy.invalidate();
        super.invalidate();
    }
    @Override
    public void onChunkUnload()
    {
        energy.onChunkUnload();
        super.onChunkUnload();
    }

	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net,
							 S35PacketUpdateTileEntity packet) {
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord,
				yCoord, zCoord);
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		inventory.readFromNBT(tagCompound);
		tickTime = tagCompound.getInteger("tickTime");
		energy.readFromNBT(tagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		inventory.writeToNBT(tagCompound);
		energy.writeToNBT(tagCompound);
		writeUpdateToNBT(tagCompound);
	}

	public void writeUpdateToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("tickTime", tickTime);
	}
	
	// ISidedInventory 
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
        return side == ForgeDirection.DOWN.ordinal() ? new int[]{0, 1, 2, 3} : new int[]{0, 1, 2, 3};
	}

	@Override
	public boolean canInsertItem(int slotIndex, ItemStack itemStack, int side)
	{
		if (slotIndex >= 1)
			return false;
        return isItemValidForSlot(slotIndex, itemStack);
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side)
	{
        return slotIndex == 2 || slotIndex == 3;
	}


}
