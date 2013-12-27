package tsi.core.handler;

import tsi.core.TSILogger;
import tsi.lib.Sounds;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class TSISoundHandler {

	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event){
		for (String soundFile: Sounds.sounds){
			try{
				event.manager.addSound(soundFile);
				TSILogger.logDebug("Sound has been loaded");
			} catch (Exception e){
				TSILogger.logError("Sound " + soundFile + " could not be loaded");
			}
		}
	}
}
