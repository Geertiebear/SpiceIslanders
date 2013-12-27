package tsi.network;

import net.minecraftforge.common.MinecraftForge;
import tsi.core.TSILogger;
import tsi.core.handler.TSISoundHandler;

public class TSIClientProxy extends TSICommonProxy{

	@Override
	public void registerSoundHandler(){
		MinecraftForge.EVENT_BUS.register(new TSISoundHandler());
		TSILogger.logDebug("Loaded Sound");
	}
}
