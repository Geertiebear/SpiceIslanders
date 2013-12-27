package tsi.core.handler;

import tsi.core.helper.LocalizationHelper;
import tsi.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TSILocalizationHandler {
	public static void loadLanguages(){
		for (String LocationFile: Localizations.localizations){
			LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.Locale(LocationFile), LocalizationHelper.isXML(LocationFile));
			LanguageRegistry.instance().addStringLocalization("itemGroup.TSI", "The Spice Islanders");
		}
	}

}
