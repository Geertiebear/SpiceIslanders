package tsi.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import tsi.core.TSIBase;
import tsi.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodPestle extends TSIItems {

	private Icon[] icons;
	public ItemWoodPestle(int par1) {
		super(par1);
		setCreativeTab(TSIBase.creativeTab);
	}
	}