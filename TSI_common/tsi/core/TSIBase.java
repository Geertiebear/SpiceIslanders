package tsi.core;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import tsi.blocks.ModBlocks;
import tsi.client.gui.GuiDiseaseBar;
import tsi.core.handler.TSIConnectionHandler;
import tsi.core.handler.TSICraftingHandler;
import tsi.core.handler.TSIEventHandler;
import tsi.core.handler.TSILocalizationHandler;
import tsi.crafting.MotarPestleRecipe;
import tsi.items.ModItems;
import tsi.lib.Strings;
import tsi.network.TSICommonProxy;
import tsi.network.TSIPacketHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Strings.modid, name = Strings.modname, version = Strings.version)
@NetworkMod(serverSideRequired = true, clientSideRequired = true,channels = "TSI", packetHandler = TSIPacketHandler.class )
public class TSIBase {
	public static CreativeTabs creativeTab = new TSITab(CreativeTabs.getNextID(), Strings.modid);
	
	@SidedProxy(clientSide = "tsi.network.TSIClientProxy", serverSide = "tsi.network.TSICommonProxy")
	public static TSICommonProxy proxy;
	@Init
	public void init(FMLInitializationEvent event){
		TSILogger.logDebug("Initializing The Spice Islanders mod...");
		GameRegistry.registerCraftingHandler(new TSICraftingHandler());
		NetworkRegistry.instance().registerConnectionHandler(new TSIConnectionHandler());
		MinecraftForge.EVENT_BUS.register(new TSIEventHandler());
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new GuiDiseaseBar(Minecraft.getMinecraft()));
		}
		ModBlocks.init();
		
		ModItems.init();
		
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.cottonSeeds), 20);
		MotarPestleRecipe.loadAllRecipes();
		
		TSILocalizationHandler.loadLanguages();
		TSILogger.logDebug("Intializing completed!");
	}
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		proxy.registerSoundHandler();
		proxy.registerDiseases();
		
	}

	
}