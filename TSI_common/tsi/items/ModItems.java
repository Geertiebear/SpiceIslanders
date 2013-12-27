package tsi.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import tsi.blocks.ModBlocks;
import tsi.core.TSIBase;
import tsi.lib.Itemids;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item NAT;
	public static Item cotton;
	public static Item uCotton;
	public static Item cottonSeeds;
	public static Item tumericSeeds;
	public static Item tumericRoot;
	public static Item woodMotar;
	public static Item stoneMotar;
	public static Item marbleMotar;
	public static Item mageMotar;
	public static Item woodPestle;
	public static Item stonePestle;
	public static Item marblePestle;
	public static Item magePestle;
	public static Item woodMotarPestle;
	public static Item stoneMotarPestle;
	public static Item marbleMotarPestle;
	public static Item mageMotarPestle;
	
	public static void init(){
		//Item initialization
		NAT = new ItemNAT(Itemids.NATid).setUnlocalizedName("NAT");
		cotton = new ItemCotton(Itemids.cottonId).setUnlocalizedName("cotton");
		uCotton = new ItemUCotton(Itemids.uCottonId).setUnlocalizedName("uCotton");
		cottonSeeds = new ItemSeeds(Itemids.cottonSeedsId, ModBlocks.cottonCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("cottonSeeds").setCreativeTab(TSIBase.creativeTab).setTextureName("tsi:cottonSeeds");
		tumericRoot = new ItemSeeds(Itemids.tumericRoot, ModBlocks.tumericCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("tumericRoot").setCreativeTab(TSIBase.creativeTab).setTextureName("tsi:tumericRoot");
		woodMotar = new ItemWoodMotar(Itemids.woodMotar).setUnlocalizedName("woodMotar");
		stoneMotar = new ItemStoneMotar(Itemids.stoneMotar).setUnlocalizedName("stoneMotar");
		marbleMotar = new ItemMarbleMotar(Itemids.marbleMotar).setUnlocalizedName("marbleMotar");
		mageMotar = new ItemMageMotar(Itemids.mageMotar).setUnlocalizedName("mageMotar");
		woodPestle = new ItemWoodPestle(Itemids.woodPestle).setUnlocalizedName("pestle0");
		stonePestle = new ItemStonePestle(Itemids.stonePestle).setUnlocalizedName("pestle1");
		marblePestle = new ItemMarblePestle(Itemids.marblePestle).setUnlocalizedName("pestle2");
		magePestle = new ItemMagePestle(Itemids.magePestle).setUnlocalizedName("pestle3");
		woodMotarPestle = new ItemWoodMotarPestle(Itemids.woodMotarPestle).setUnlocalizedName("woodMotarPestle");
		stoneMotarPestle = new ItemStoneMotarPestle(Itemids.stoneMotarPestle).setUnlocalizedName("stoneMotarPestle");
		marbleMotarPestle = new ItemMarbleMotarPestle(Itemids.marbleMotarPestle).setUnlocalizedName("marbleMotarPestle");
		mageMotarPestle = new ItemMageMotarPestle(Itemids.mageMotarPestle).setUnlocalizedName("mageMotarPestle");
		
		
		
		//Recipes for items
		for(int i = 0; i < NAT.getMaxDamage(); i++){

			ItemStack itemstack2 = new ItemStack(uCotton);
			GameRegistry.addShapelessRecipe(new ItemStack(cotton, 1, i - 1), new Object [] { new ItemStack(NAT, 1, i), itemstack2, itemstack2});
			}
		GameRegistry.addRecipe(new ItemStack(NAT, 1), new Object[]{
			"  S", " I ", "   ", 'S', Item.silk, 'I', Item.ingotIron
		});
		//GameRegistry.addShapelessRecipe(new ItemStack(cottonSeeds, 1), new ItemStack(uCotton), new ItemStack(Item.seeds));
		
		//LanguageRegistry.addName(uCotton, "Unrefined Cotton");
		//LanguageRegistry.addName(NAT, "Needle and Thread");
		//LanguageRegistry.addName(cotton, "Cotton");
		//LanguageRegistry.addName(cottonSeeds, "Cotton Seeds");
	}
	
	

}
