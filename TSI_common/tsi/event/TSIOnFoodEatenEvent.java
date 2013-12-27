package tsi.event;

import tsi.core.TSILogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.Event;

public class TSIOnFoodEatenEvent extends Event{

	public EntityPlayer player;
	public ItemFood food;
	
	public TSIOnFoodEatenEvent(EntityPlayer player, ItemFood food) {
		this.player = player;
		this.food = food;
		TSILogger.logDebug("I have eaten a:" + food.toString());
	}
	@Override
	public boolean isCancelable(){
		return false;
	}

}
