package tsi.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tsi.blocks.ModBlocks;
import tsi.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class MotarPestleRecipe {

	public static void loadWoodRecipe(){
		GameRegistry.addRecipe(new ItemStack(ModItems.woodMotar, 1), new Object[]{
			"   ", "M M", "MMM",'M', Block.wood
		});
		GameRegistry.addRecipe(new ItemStack(ModItems.woodPestle, 1), new Object[]{
			"  M"," M ","M  ",'M', Block.wood
		});
	}
	public static void loadStoneRecipe(){
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneMotar, 1), new Object[]{
			"   ", "M M", "MMM",'M', Block.stone
		});
		GameRegistry.addRecipe(new ItemStack(ModItems.stonePestle,1), new Object[]{
			"  M"," M ","M  ",'M', Block.stone
		});
	}
	public static void loadMarbleRecipe(){
		GameRegistry.addRecipe(new ItemStack(ModItems.marbleMotar , 1), new Object[]{
			"   ", "M M", "MMM",'M', ModBlocks.marble
		});
		GameRegistry.addRecipe(new ItemStack(ModItems.marblePestle,1), new Object[]{
			"  M"," M ","M  ",'M', ModBlocks.marble
		});
	}
	public static void loadMageRecipe(){
		GameRegistry.addRecipe(new ItemStack(ModItems.mageMotar, 1), new Object[]{
			"   ", "IEI","III",'E', Item.emerald,'I', Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(ModItems.magePestle,1), new Object[]{
			"  I"," I ","E  ",'E',Item.emerald,'I',Item.ingotIron
		});
	}
	public static void loadAllRecipes(){
		loadWoodRecipe();
		loadStoneRecipe();
		loadMarbleRecipe();
		loadMageRecipe();
	}
}
