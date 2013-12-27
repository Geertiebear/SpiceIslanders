package tsi.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.network.packet.NetHandler;
import net.minecraft.util.ChatMessageComponent;

import tsi.lib.Strings;

public class TSIUpdate {

	public static void isUpDateAvailable(NetHandler net) throws IOException, MalformedURLException{
		TSILogger.logDebug("Checking mod version...");
		BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL
				("https://raw.github.com/Minecraft-The-Spice-Islanders-Mod/Code-For-The-Mod/master/version/version.txt").openStream()));
		String newVersion = versionFile.readLine();
		String clientVersion = Strings.version;
		//TSILogger.logDebug(newVersion);
		//TSILogger.logDebug(clientVersion);
		if (!clientVersion.equals(newVersion)){
			TSILogger.logDebug("New version available!");
			net.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromText(Strings.updateMessage));
		} else{
			TSILogger.logDebug("Mod uptodate!");	
		}
	}
}
