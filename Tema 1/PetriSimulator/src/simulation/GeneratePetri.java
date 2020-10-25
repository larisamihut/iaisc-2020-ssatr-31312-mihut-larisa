package simulation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class GeneratePetri {

public static PetriNet generatePetriModel(String modelFile) throws Exception {
	String jsonPetri = new String(Files.readAllBytes(Paths.get(modelFile)));
	
	JSONObject json = new  JSONObject(jsonPetri);
	
	List<Place> list = new ArrayList<Place>();
	JSONArray array = json.getJSONArray("places");
	for (int i = 0; i<array.length(); i++) {
		list.add(new Place(array.getJSONObject(i).getInt("id"), array.optJSONObject(i).getInt("jeton")));
	}
	
	List<Transition> transList = new ArrayList<Transition>();
	JSONArray transArray = json.getJSONArray("transitions");
	
	for (int i = 0; i < transArray.length(); i++) {
        List<Integer> inputList = new ArrayList<Integer>();
        List<Integer> outputList = new ArrayList<Integer>();
        JSONObject tranz = transArray.getJSONObject(i);
        JSONArray inputs = tranz.getJSONArray("inputs");
        for (int j = 0; j < inputs.length(); j++) {
            inputList.add(inputs.getJSONObject(j).getInt("id"));
        }
        JSONArray outputs = tranz.getJSONArray("outputs");
        for (int k = 0; k < outputs.length(); k++) {
            outputList.add(outputs.getJSONObject(k).getInt("id"));
        }
        int tmin = tranz.getInt("tmin");
        int tmax = tranz.getInt("tmax");
        Transition transition = new Transition(inputList, outputList, tmin, tmax);
        transList.add(transition);
    }
	
	PetriNet petriNet = new PetriNet(list, transList);
	return petriNet;
}
}
