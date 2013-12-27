package tsi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMarbleMotar extends TSIItems {

	public ItemMarbleMotar(int par1) {
		super(par1);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		ItemStack toAdd = new ItemStack(ModItems.marbleMotarPestle);
		if (player.inventory.hasItem(ModItems.marblePestle.itemID)){
			player.inventory.consumeInventoryItem(ModItems.marblePestle.itemID);
			player.inventory.consumeInventoryItem(ModItems.marbleMotar.itemID);
			player.inventory.addItemStackToInventory(toAdd);
		}
		return stack;
	}
}
