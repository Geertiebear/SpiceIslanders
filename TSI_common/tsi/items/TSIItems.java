package tsi.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import tsi.core.TSIBase;
import tsi.lib.Strings;

public class TSIItems extends Item{

	public TSIItems(int par1) {
		super(par1);
		setCreativeTab(TSIBase.creativeTab);
	}

	@Override
	public void registerIcons(IconRegister icon){
		this.itemIcon = icon.registerIcon(Strings.modid.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}


}
 