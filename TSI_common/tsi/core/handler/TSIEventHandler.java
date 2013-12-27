package tsi.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import tsi.core.TSILogger;
import tsi.disease.core.IDisease;
import tsi.disease.helper.DiseaseHelper;
import tsi.disease.player.ExtendedDiseasePlayer;
import tsi.event.TSICancelDiseaseEvent;
import tsi.event.TSIOnFoodEatenEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class TSIEventHandler {

	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && ExtendedDiseasePlayer.get((EntityPlayer)event.entity) == null){
			ExtendedDiseasePlayer.register((EntityPlayer) event.entity);
		}
		if(event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedDiseasePlayer.Ext_Prop_Name) == null){
			event.entity.registerExtendedProperties(ExtendedDiseasePlayer.Ext_Prop_Name, 
			new ExtendedDiseasePlayer((EntityPlayer) event.entity));
		}
	}
	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER){
				//The entityplayer since I have to use it so many many times
				EntityPlayer player = (EntityPlayer) event.entity;
				
				// Adding bacteria every tick
				ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(player);
				prop.addBact(2);
				//TSILogger.logDebug("Call!");
				
				//Determine disease and give disease
				DiseaseHelper.getDisease(player);
				
				if (prop.hasDisease() && !prop.isCanceled()){
					IDisease playerDisease = prop.returnDisease();
					playerDisease.addEffects(player);
				}
			}
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT){
				EntityPlayer player = (EntityPlayer) event.entity;
				
				if (isFoodEaten(player)){
					TSILogger.logDebug("Food has been eaten");
				}
			}
		}
	}
	
	@ForgeSubscribe
	public void onDiseaseCancled(TSICancelDiseaseEvent event){
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(event.entityPlayer);
			
			if (prop.hasDisease()){
				prop.removeDisease();
				prop.setCanceled(true);
			}
		}
	}
	
	//TODO Fix this :P
	/**
	@ForgeSubscribe
	public void onPlayerDestroyItem(PlayerDestroyItemEvent event){
		if (event.original.getItem() == Item.appleGold){
			ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(event.entityPlayer);
			prop.removeDisease();
			prop.setCanceled(true);
			TSILogger.logDebug("I have eaten!");
		}
	}
	**/

	private boolean isFoodEaten(EntityPlayer player){
		int foodLevel = player.getFoodStats().getFoodLevel();
		int previousFoodLevel = player.getFoodStats().getPrevFoodLevel();
		
		if (foodLevel > previousFoodLevel){
			return true;
		}else{
		
		return false;
		}
	}
}
