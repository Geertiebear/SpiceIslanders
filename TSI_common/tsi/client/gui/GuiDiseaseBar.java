package tsi.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import tsi.core.TSILogger;
import tsi.disease.player.ExtendedDiseasePlayer;

public class GuiDiseaseBar extends Gui{

	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation("tsi", "textures/gui/disease_bar.png");

	
	public GuiDiseaseBar (Minecraft mc){
		super();
		this.mc = mc;
	}
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event){
		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE){
			return;
		}
		ExtendedDiseasePlayer prop = ExtendedDiseasePlayer.get(this.mc.thePlayer);
		
		if(prop == null || prop.getMaxBacteria() == 0 ){
			//TSILogger.logDebug("Uhoh :( MaxBact:" + prop.getMaxBacteria());
			return;
		}
		//TSILogger.logDebug("Call GUI!");
		int xPos = 2;
		int yPos = 2;
		
		this.mc.getTextureManager().bindTexture(texturepath);

		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.drawTexturedModalRect(xPos, yPos, 0, 0, 51, 4);

		int diseasebarwidth = (int)(((float) prop.getCurrentBacteria() / prop.getMaxBacteria()) * 49);
		this.drawTexturedModalRect(xPos, yPos + 1, 0, 4, diseasebarwidth, 2);


	}
}
