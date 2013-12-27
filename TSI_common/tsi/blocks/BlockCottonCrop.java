package tsi.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import tsi.items.ModItems;
import tsi.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCottonCrop extends Block {

	private Icon[] icons;
	
	private int idDropped;
	
	public BlockCottonCrop(int id) {
		super(id, Material.plants);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setTickRandomly(true);
		this.setStepSound(soundGrassFootstep);
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
        if (par2 < 0 || par2 > 4)
        {
            par2 = 4;
        }

        return this.icons[par2];
    }
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockMetadata(x, y, z) == 4) {
            return;
        }

        if (world.getBlockLightValue(x, y + 1, z) < 9) {
            return;
        }

        if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 1000) != 0) {
            return;
        }
        int metadata = world.getBlockMetadata(x, y, z);
        world.setBlockMetadataWithNotify(x, y, z, ++metadata , 2);
    }
    @Override
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		icons = new Icon[5];
    	
		for(int i = 0; i < icons.length; i++){
			icons[i] = icon.registerIcon(Strings.modid.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "_" + i);
		}
	}
    @Override
    public int idDropped(int par1, Random par2Random, int par3){
    	if (par1 == 4){
    		idDropped = ModItems.uCotton.itemID;
    		return ModItems.uCotton.itemID;
    	} else {
    		idDropped = ModItems.cottonSeeds.itemID;
    		return ModItems.cottonSeeds.itemID;
    	}
    }

    @Override
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return ModItems.cottonSeeds.itemID;
    }
    @Override
    public int quantityDropped(Random rand){
    	if (idDropped == ModItems.uCotton.itemID){
    		return rand.nextInt(2) + 6;
    	} else {
    		return rand.nextInt(2) + 1;
    	}
    }
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

        if (metadata >= 4)
        {
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(ModItems.cottonSeeds, 2, 0));
                }
            }
        }

        return ret;
    }
    }