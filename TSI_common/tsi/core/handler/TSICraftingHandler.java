package tsi.core.handler;

import tsi.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class TSICraftingHandler implements ICraftingHandler{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		for (int i = 0; i < craftMatrix.getSizeInventory(); i++) // Checks all
																	// the slots
		{
			if (craftMatrix.getStackInSlot(i) != null) // If there is an item
			{
				ItemStack j = craftMatrix.getStackInSlot(i); // Gets the item
				if (j.getItem() != null && j.getItem() == ModItems.NAT) 
				{
					ItemStack k = new ItemStack(ModItems.NAT, 2, (j.getItemDamage() + 1)); 
					if (k.getItemDamage() >= k.getMaxDamage()) { 
						k.stackSize--; 
					}
					craftMatrix.setInventorySlotContents(i, k);
					
				} else if (j.getItem() !=null && j.getItem() == ModItems.woodMotarPestle){
					ItemStack k = new ItemStack(ModItems.woodMotarPestle, 2, (j.getItemDamage() + 1));
					if (k.getItemDamage() >= k.getMaxDamage()){
						k.stackSize--;
					}
					craftMatrix.setInventorySlotContents(i, k);
				}
			}
			

		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		 
	}

}
