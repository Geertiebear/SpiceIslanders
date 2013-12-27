package tsi.disease.core;

import net.minecraft.entity.player.EntityPlayer;

public interface IDisease {
	public abstract int ID();
	
	/**
	 * 
	 * Not Implemented yet, may be later
	 */
	public abstract int diseaseLevel();

	public abstract void addEffects(EntityPlayer player);
	
	public abstract int minimumBacteria();
}
