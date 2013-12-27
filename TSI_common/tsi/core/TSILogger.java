package tsi.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import tsi.lib.Strings;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class TSILogger {

    public static final Logger logger = Logger.getLogger("TSI-" + FMLCommonHandler.instance().getEffectiveSide());
    
    static{
        logger.setParent(FMLLog.getLogger());
    }
    public static void logError(String error){
        logger.warning(error);
    }
    public static void logDebug(String debug){
        logger.log(Level.INFO, debug);
    }
}
