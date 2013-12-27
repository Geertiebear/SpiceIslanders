package tsi.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import tsi.core.TSILogger;
import tsi.network.TSIPacket.ProtocolException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class TSIPacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		try{
			EntityPlayer ePlayer = (EntityPlayer) player;
			ByteArrayDataInput in = ByteStreams.newDataInput(packet.data);
			int packetId = in.readUnsignedByte();
			TSIPacket tsiPacket = TSIPacket.constructPacket(packetId);
			tsiPacket.read(in);
			tsiPacket.execute(ePlayer, ePlayer.worldObj.isRemote ? Side.CLIENT : Side.SERVER);
			//TSILogger.logDebug("Received!");
		} catch (ProtocolException e){
			if (player instanceof EntityPlayerMP){
				((EntityPlayerMP) player).playerNetServerHandler.kickPlayerFromServer("Protocol Exception!");
				TSILogger.logError("Player" + ((EntityPlayer) player).username + "caused a protocol exception!");
			}
			} catch (ReflectiveOperationException e){
				throw new RuntimeException("Unexpected Reflection exception during Packet construction!", e);
			}
	}
}
