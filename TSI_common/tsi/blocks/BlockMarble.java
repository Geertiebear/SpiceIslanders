package tsi.blocks;

import tsi.core.TSIBase;
import tsi.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMarble extends Block {

	public BlockMarble(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setStepSound(soundStoneFootstep);
		setCreativeTab(TSIBase.creativeTab);
	}

	@Override
	public void registerIcons(IconRegister register){
		this.blockIcon = register.registerIcon(Strings.modid.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}
}
