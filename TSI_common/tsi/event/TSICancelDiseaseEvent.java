package tsi.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class TSICancelDiseaseEvent extends PlayerEvent{

	public TSICancelDiseaseEvent(EntityPlayer player) {
		super(player);
	}
	
}
