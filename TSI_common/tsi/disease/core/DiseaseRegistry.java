package tsi.disease.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiseaseRegistry {

	public static final Map<IDisease, String> diseaseNameMap = new HashMap<IDisease, String>();
	public static final Map<String, IDisease> diseaseMap = new HashMap<String, IDisease>();
	public static final Map<Integer, IDisease > diseaseIDMap = new HashMap<Integer, IDisease>();
	public static final List<IDisease> diseaseList = new ArrayList<IDisease>();
	
	public static void registerDisease(IDisease disease, String name){
		diseaseNameMap.put(disease, name);
		diseaseMap.put(name, disease);
		diseaseIDMap.put(disease.ID(), disease);
		diseaseList.add(disease);
	}
	public static String getName(IDisease disease){
		return diseaseNameMap.get(disease);
	}
	public static IDisease getDiseaseByName(String name){
		return diseaseMap.get(name);
	}
	public static int NoDisease(){
		return diseaseList.size();
	}
	public static IDisease DiseaseByID(int ID){
		return diseaseIDMap.get(ID);
	}
}
