package techreborn.tiles.lesu;


import net.minecraftforge.common.util.ForgeDirection;
import techreborn.config.ConfigTechReborn;
import techreborn.lib.Functions;
import techreborn.powerSystem.TilePowerAcceptor;
import techreborn.util.Inventory;

import java.util.ArrayList;

public class TileLesu extends TilePowerAcceptor  {//TODO wrench

    private ArrayList<LesuNetwork> countedNetworks = new ArrayList<LesuNetwork>();
    public int connectedBlocks = 0;
    public int currentBlocks = 0;

    private double euLastTick = 0;
    private double euChange;
    private int ticks;
	private int output;
	private int maxStorage;

    public Inventory inventory = new Inventory(2, "TileAesu", 64);

    public TileLesu() {
        super(5);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if(worldObj.isRemote){
            return;
        }
        countedNetworks.clear();
        connectedBlocks = 0;
        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS){
            if(worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ) instanceof TileLesuStorage){
                if(((TileLesuStorage) worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ)).network != null){
                    LesuNetwork network = ((TileLesuStorage) worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ)).network;
                    if(!countedNetworks.contains(network)){
                        if(network.master == null || network.master == this){
                            connectedBlocks += network.storages.size();
                            countedNetworks.add(network);
                            network.master = this;
							break;
                        }
                    }
                }
            }
        }
        if(currentBlocks != connectedBlocks){
            maxStorage = ((connectedBlocks + 1) * ConfigTechReborn.lesuStoragePerBlock);
            output = (connectedBlocks * ConfigTechReborn.extraOutputPerLesuBlock) + ConfigTechReborn.baseLesuOutput;
        }

        if(ticks == ConfigTechReborn.aveargeEuOutTickTime){
            euChange = -1;
            ticks = 0;
        } else {
            ticks ++;
            if(euChange == -1){
                euChange = 0;
            }
            euChange += getEnergy() - euLastTick;
            if(euLastTick == getEnergy()){
                euChange = 0;
            }
        }

        euLastTick = getEnergy();
    }


    public double getEuChange(){
        if(euChange == -1){
            return 0;
        }
        return (euChange / ticks);
    }

	public int getMaxEnergyAmount() {
		return (5000 * ConfigTechReborn.extraOutputPerLesuBlock) + ConfigTechReborn.baseLesuOutput;
	}


	public double getMaxPower() {
		return maxStorage;
	}


	@Override
	public boolean canAcceptEnergy(ForgeDirection direction) {
		return direction.ordinal() != blockMetadata;
	}

	@Override
	public boolean canProvideEnergy(ForgeDirection direction) {
		return Functions.getIntDirFromDirection(direction) == blockMetadata;
	}

	@Override
	public double getMaxOutput() {
		return output;
	}

	@Override
	public double getMaxInput() {
		return 8192;
	}
}
