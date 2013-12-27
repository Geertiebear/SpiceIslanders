package tsi.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

public abstract class TSIPacket {
	
	public static final String channel = "TSI";
	
	private static final BiMap<Integer, Class<? extends TSIPacket>> packets;
	
	static{
		ImmutableBiMap.Builder<Integer, Class<? extends TSIPacket>> builder = ImmutableBiMap.builder();
		
		builder.put(Integer.valueOf(1), TSIPacketSound.class);
		
		packets = builder.build();
	}
	public static TSIPacket constructPacket (int packetId) throws ProtocolException, ReflectiveOperationException{
		Class<? extends TSIPacket> clazz = packets.get(Integer.valueOf(packetId));
		if (clazz == null){
			throw new ProtocolException("Unkown packet id! D;");
		} else{
			return clazz.newInstance();
		}
	}
	public final int getPacketId(){
		if(packets.inverse().containsKey(getClass())){
			return packets.inverse().get(getClass()).intValue();
		} else{
			throw new RuntimeException("Packet" + getClass().getSimpleName() + "is missing mapping! Geert you have been stupid again!");
		}
	}
	public final Packet makePacket(){
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeByte(getPacketId());
		write(out);
		return PacketDispatcher.getPacket(channel, out.toByteArray());
	}

	public abstract void write(ByteArrayDataOutput out);
	
	public abstract void read (ByteArrayDataInput in) throws ProtocolException;
	
	public abstract void execute (EntityPlayer player, Side side) throws ProtocolException;

	public static class ProtocolException extends Exception{
		public ProtocolException (){
			
		}
		public ProtocolException(String message, Throwable cause){
			super(message, cause);
		}
		public ProtocolException (String message){
			super(message);
		}
		public ProtocolException(Throwable cause){
			super(cause);
		}
	}
}
