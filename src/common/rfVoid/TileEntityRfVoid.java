package rfVoid;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import cofh.api.energy.IEnergyHandler;

public class TileEntityRfVoid extends TileEntity implements IEnergyHandler {
    public TileEntityRfVoid() {
        super();
    }

    @Override
    public void updateEntity() {
        // Does nothing.
    }

//public interface IEnergyHandler {
    @Override
    public int receiveEnergy(ForgeDirection from, int quantity, boolean simulate)
    {
        return quantity;
    }

    @Override
    public int extractEnergy(ForgeDirection from, int quantity, boolean simulate)
    {
        return 0;
    }

    @Override
    public boolean canInterface(ForgeDirection from)
    {
        return true;
    }

    @Override
    public int getEnergyStored(ForgeDirection from)
    {
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from)
    {
        return Integer.MAX_VALUE;
    }
//}
}
