package tsi.disease.helper;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import tsi.disease.core.DiseaseRegistry;
import tsi.disease.core.IDisease;
import tsi.disease.player.ExtendedDiseasePlayer;

public class DiseaseHelper {
	
	private static Random rand = new Random();

	private static int chanceGettingDisease(IDisease disease, int bacteria){
		int minimumBacteria = disease.minimumBacteria();
		if (bacteria == 0){
			return 0;
		} else if(bacteria <= 50000 && bacteria >= minimumBacteria){
			return 1000;
		} else if (bacteria <= 100000 && bacteria >= minimumBacteria){
			return 900;
		} else if (bacteria <= 150000 && bacteria >= minimumBacteria){
			return 800;
		} else if (bacteria <= 200000 && bacteria >= minimumBacteria){
			return 700;
		} else if (bacteria <= 250000 && bacteria >= minimumBacteria){
			return 600;
		} else {
			return 0;
		}
		
	}
	private static IDisease getChanceDisease(){
		int diseaseID =  rand.nextInt(DiseaseRegistry.NoDisease());
		
		if (diseaseID == 0){
			diseaseID = 1;
		}
		
		return DiseaseRegistry.DiseaseByID(diseaseID);
	}
	
	public static void getDisease(EntityPlayer player){
		ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(player);
		
		int bact = prop.getCurrentBacteria();
		
		IDisease disease = getChanceDisease();
		
		if(rand.nextInt(800) != chanceGettingDisease(disease, bact)){
			return;
		} else if (!prop.hasDisease()){
			prop.getDisease(disease);
		} else {
			return;
		}
	}
}
