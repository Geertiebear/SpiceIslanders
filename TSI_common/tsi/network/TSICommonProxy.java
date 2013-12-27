package tsi.network;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import tsi.disease.DiseaseCold;
import tsi.disease.core.DiseaseRegistry;
import tsi.disease.core.IDisease;
import tsi.disease.player.ExtendedDiseasePlayer;

public class TSICommonProxy {

	private static HashMap<String, IDisease>  playerDiseases = new HashMap <String, IDisease>();
	
	public static void storeData(String username, IDisease disease){
		playerDiseases.put(username, disease);
	}
	public static IDisease loadData (String username){
		return playerDiseases.get(username);
	}
	public static void removeData(String username){
		playerDiseases.remove(username);
	}
	
	public static void addPlayerDisease(EntityPlayer target, IDisease disease){
		ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(target);
		
		prop.getDisease(disease);
		storeData(target.username, disease);
	}
	public static void removePlayerDisease(EntityPlayer target){
		ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(target);
		
		prop.removeDisease();
		removeData(target.username);
	}
	
	public void registerSoundHandler(){
		
	}
	
	public void registerDiseases(){
		DiseaseRegistry.registerDisease(new DiseaseCold(), "cold");
	}
}
