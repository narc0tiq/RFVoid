package rfVoid;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import net.minecraftforge.common.Configuration;

@Mod(modid="RFVoid",
     name="RF Void",
     version="%conf:VERSION%",
     dependencies="required-after:CoFHCore")
@NetworkMod(serverSideRequired=false,
            clientSideRequired=true,
            versionBounds="%conf:VERSION_BOUNDS%")
public class RfVoid {
    // Not really that sided a proxy.
    @SidedProxy(clientSide="rfVoid.CommonProxy",
                serverSide="rfVoid.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration config = null;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(config);
    }
}
