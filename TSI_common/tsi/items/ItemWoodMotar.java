package tsi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWoodMotar extends TSIItems {

	public ItemWoodMotar(int par1) {
		super(par1);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if (player.inventory.hasItem(ModItems.woodPestle.itemID)){
			ItemStack toAdd = new ItemStack(ModItems.woodMotarPestle);
			player.inventory.consumeInventoryItem(ModItems.woodPestle.itemID);
			player.inventory.consumeInventoryItem(ModItems.woodMotar.itemID);
			player.inventory.addItemStackToInventory(toAdd);
		}
		return stack;
	}

}
