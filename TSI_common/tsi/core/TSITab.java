package tsi.core;

import tsi.items.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TSITab extends CreativeTabs{

	public TSITab(int par1, String par2Str) {
		super(par1, par2Str);
	}

    @SideOnly(Side.CLIENT)
    //Texture in the Creative Tab
    public ItemStack getIconItemStack()
    {
        return new ItemStack(ModItems.tumericRoot);
    }
}
