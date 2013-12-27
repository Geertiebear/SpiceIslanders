package tsi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import tsi.lib.Itemids;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	public static Block cottonCrop;
	public static Block tumericCrop;
	public static Block marble;
	public static void init(){
		cottonCrop = new BlockCottonCrop(Itemids.CottonCropsId).setUnlocalizedName("cottonCrop");
		tumericCrop = new BlockTumericCrop(Itemids.TumericCropId).setUnlocalizedName("tumeric");
		marble = new BlockMarble(Itemids.MarbleId, Material.rock).setUnlocalizedName("marble").setHardness(1.5F).setResistance(10.0F);
		
		
		LanguageRegistry.addName(cottonCrop, "Cotton Crop");
		GameRegistry.registerBlock(cottonCrop, "cottonCrop");
		LanguageRegistry.addName(tumericCrop, "Tumeric Crop");
		GameRegistry.registerBlock(tumericCrop, "tumericCrop");
		GameRegistry.registerBlock(marble);
		
		GameRegistry.addRecipe(new ItemStack(marble, 1), new Object[]{
			"SSS","SSS","SSS",'S', Block.stone
		});
	}
}
