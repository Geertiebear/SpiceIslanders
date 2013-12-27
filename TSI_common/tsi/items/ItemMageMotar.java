package tsi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMageMotar extends TSIItems {

	public ItemMageMotar(int par1) {
		super(par1);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(player.inventory.hasItem(ModItems.magePestle.itemID)){
			ItemStack toAdd = new ItemStack(ModItems.mageMotarPestle);
			player.inventory.consumeInventoryItem(ModItems.magePestle.itemID);
			player.inventory.consumeInventoryItem(this.itemID);
			player.inventory.addItemStackToInventory(toAdd);
		}
		return stack;
	}
}
