package tsi.disease.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import tsi.core.TSILogger;
import tsi.disease.core.DiseaseRegistry;
import tsi.disease.core.IDisease;


public class ExtendedDiseasePlayer implements IExtendedEntityProperties {
	
	public final static String Ext_Prop_Name = "DiseasePlayer";

	private final EntityPlayer player;
	
	private boolean hasDisease;
	private boolean isCanceled;
	private int disease;
	
	private int maxBacteria;
	public static final int Bact_Watcher = 21;
	
	public ExtendedDiseasePlayer(EntityPlayer player){
		this.player = player;
		this.maxBacteria = 250000;
		this.player.getDataWatcher().addObject(Bact_Watcher, 0);
		this.hasDisease = false;
		this.disease = 0;
		this.isCanceled = false;
	}
	
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(Ext_Prop_Name, new ExtendedDiseasePlayer(player));
	}
	
	public static final ExtendedDiseasePlayer get (EntityPlayer player){
		return (ExtendedDiseasePlayer) player.getExtendedProperties(Ext_Prop_Name);
	}
	
	public void getDisease(IDisease disease){
		int diseaseID = disease.ID();
		
		this.disease = diseaseID;
		this.hasDisease = true;
	}
	
	public void removeDisease(){
		this.disease = 0;
		this.hasDisease = false;
	}
	
	public boolean hasDisease(){
		return hasDisease;
	}
	public IDisease returnDisease(){
		return DiseaseRegistry.DiseaseByID(disease);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setInteger("maxBacteria", maxBacteria);
		properties.setInteger("currentBacteria", this.player.getDataWatcher().getWatchableObjectInt(Bact_Watcher));
		properties.setBoolean("hasDisease", hasDisease);
		properties.setBoolean("isCanceled", isCanceled);
		properties.setInteger("diseaseID", disease);
		
		compound.setTag(Ext_Prop_Name, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = (NBTTagCompound) compound.getTag(Ext_Prop_Name);
		
		this.maxBacteria = properties.getInteger("maxBacteria");
		this.player.getDataWatcher().updateObject(Bact_Watcher, properties.getInteger("currentBacteria"));
		this.hasDisease = properties.getBoolean("hasDisease");
		this.isCanceled = properties.getBoolean("isCanceled");
		this.disease = properties.getInteger("diseaseID");
		
		TSILogger.logDebug("Debug " + this.player.getDataWatcher().getWatchableObjectInt(Bact_Watcher));
	}
	@Override
	public void init(Entity entity, World world) {
	}
	
	public int getMaxBacteria(){
		return this.maxBacteria;
	}

	public int getCurrentBacteria() {
		return this.player.getDataWatcher().getWatchableObjectInt(Bact_Watcher);
	}
	public void setMaxBact(int b){
		this.maxBacteria = b;
	}
	public void setCurrentBact (int b){
		this.player.getDataWatcher().updateObject(Bact_Watcher, b);
	}
	public void addBact(int amount){
		this.player.getDataWatcher().updateObject(Bact_Watcher, (this.player.getDataWatcher().getWatchableObjectInt(Bact_Watcher) + amount));
	}
	
	public boolean isCanceled(){
		return isCanceled;
	}
	public void setCanceled(boolean value){
		this.isCanceled = value;
	}

}
