package tsi.disease;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import tsi.core.TSILogger;
import tsi.disease.core.IDisease;
import tsi.lib.Sounds;
import tsi.network.TSIPacketSound;
import cpw.mods.fml.common.network.PacketDispatcher;

public class DiseaseCold implements IDisease {

	private Random rand = new Random();
	
	@Override
	public int ID() {
		return 1;
	}

	@Override
	public int diseaseLevel() {
		return 0;
	}

	@Override
	public void addEffects(EntityPlayer player) {

		
		player.addPotionEffect(new PotionEffect(4, 2, 1));
		
		if (rand.nextInt(600) == 0){
			PacketDispatcher.sendPacketToAllAround(player.posX, player.posY, player.posZ, 64D, player.worldObj.provider.dimensionId, new TSIPacketSound(Sounds.COUGH, player.posX, player.posY, player.posZ, 1.5F, 1F).makePacket());
		}
		//TSILogger.logDebug("I have caught a cold :(");
	}	

	@Override
	public int minimumBacteria() {
		return 10000;
	}

}
