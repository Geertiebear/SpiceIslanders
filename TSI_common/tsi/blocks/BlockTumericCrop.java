package tsi.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import tsi.items.ModItems;
import tsi.lib.Strings;

public class BlockTumericCrop extends Block{
	
	private Icon[] icons;

	public BlockTumericCrop(int par1) {
		super(par1, Material.plants);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setTickRandomly(true);
		this.setStepSound(soundGrassFootstep);
	}

	public static int seedItem(){
		return ModItems.tumericRoot.itemID;
	}
	public static int cropItem(){
		return ModItems.tumericRoot.itemID;
	}
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
    	//System.out.println("CALL!!");
        if (world.getBlockMetadata(x, y, z) == 2) {
            return;
        }

        if (world.getBlockLightValue(x, y + 1, z) < 9) {
            return;
        }

        if (random.nextInt(isFertile(world, x, y - 1, z) ? 1 : 1) != 0) {
            return;
        }
        int metadata = world.getBlockMetadata(x, y, z);
        world.setBlockMetadataWithNotify(x, y, z, ++metadata , 2);
    }
    @Override
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return seedItem();
    }
    @Override
    public int quantityDropped(Random rand){
    	return rand.nextInt(2)+1;
    }
    public int idDropped(int one, Random rand, int two){
    	if (one == 2){
    		return cropItem();
    	} else {
    	return -1;
    	}
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
    public int getRenderType() {
        return 6; // Magic number.
    }
    public boolean isOpaqueCube() {
        return false;
    }
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 2)
        {
            par2 = 2;
        }

        return this.icons[par2];
    }
    @Override
    public void registerIcons(IconRegister icon){
    	icons = new Icon[3];
    	for(int i = 0; i < icons.length; i++){
    		icons[i] = icon.registerIcon(Strings.modid.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "_" + i);
    	}
    }
}
