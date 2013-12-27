package tsi.network;

import net.minecraft.entity.player.EntityPlayer;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;

public class TSIPacketSound extends TSIPacket{

	public String soundName;
	public double x,y,z;
	public float volume, pitch;
	
	public TSIPacketSound(){}
	
	public TSIPacketSound (String soundName, double x, double y, double z, float volume, float pitch){
		this.soundName = soundName;
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.volume = volume;
	}
	
	@Override
	public void write(ByteArrayDataOutput out) {
		out.writeUTF(soundName);
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(z);
		out.writeFloat(volume);
		out.writeFloat(pitch);
	}

	@Override
	public void read(ByteArrayDataInput in) throws ProtocolException {
        soundName = in.readUTF();
        x = in.readDouble();
        y = in.readDouble();
        z = in.readDouble();
        volume = in.readFloat();
        pitch = in.readFloat();
	}

	@Override
	public void execute(EntityPlayer player, Side side) throws ProtocolException {
		FMLClientHandler.instance().getClient().sndManager.playSound(soundName, (float) x, (float) y, (float) z, volume, pitch);
	}

}
