package tsi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tsi.core.TSIBase;
import tsi.disease.player.ExtendedDiseasePlayer;

public class ItemNAT extends TSIItems{

	public ItemNAT(int id) {
		super(id);
		setMaxDamage(22);
		setMaxStackSize(1);
		setCreativeTab(TSIBase.creativeTab);
	}
	

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if (!world.isRemote){
			ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(player);
			prop.addBact(10000);
		}
		return stack;
	}
}
