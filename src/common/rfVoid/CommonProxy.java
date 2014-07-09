package rfVoid;

import net.minecraft.item.ItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraftforge.common.Configuration;

public class CommonProxy {
    public int rfVoidBlockID = 1898;
    public BlockRfVoid rfVoidBlock;
    public static final String NAME_RF_VOID = "rfvoid:rfvoid";

    public void init(Configuration config) {
        initConfig(config);
        initBlocks();
        initLocales();
    }

    public void initConfig(Configuration config) {
        try { config.load(); }
        catch(RuntimeException e) { /* and ignore it. We'll just regen the config. */ }

        rfVoidBlockID = config.getBlock("rfVoid", rfVoidBlockID).getInt(rfVoidBlockID);

        try { config.save(); }
        catch(RuntimeException e) {
            System.err.println("rfVoid: can't save my config! This may be a problem.");
            e.printStackTrace(System.err);
        }
    }

    public void initBlocks() {
        rfVoidBlock = new BlockRfVoid(rfVoidBlockID);
        GameRegistry.registerBlock(rfVoidBlock, ItemBlock.class, NAME_RF_VOID);
        GameRegistry.registerTileEntity(TileEntityRfVoid.class, NAME_RF_VOID);
    }

    public void initLocales() {
        String langDir = "/lang/";
        String[] languages = { "en_US" };
        LanguageRegistry lr = LanguageRegistry.instance();

        for(String lang: languages) {
            lr.loadLocalization(langDir + lang + ".xml", lang, true);
        }
    }
}
