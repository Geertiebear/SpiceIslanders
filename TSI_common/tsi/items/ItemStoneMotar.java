package tsi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStoneMotar extends TSIItems {

	public ItemStoneMotar(int par1) {
		super(par1);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(player.inventory.hasItem(ModItems.stonePestle.itemID)){
			ItemStack toAdd = new ItemStack(ModItems.stoneMotarPestle);
			player.inventory.consumeInventoryItem(ModItems.stonePestle.itemID);
			player.inventory.consumeInventoryItem(this.itemID);
			player.inventory.addItemStackToInventory(toAdd);
		}
		return stack;
	}
}
