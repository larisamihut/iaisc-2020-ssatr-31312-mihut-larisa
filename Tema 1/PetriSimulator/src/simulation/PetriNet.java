package simulation;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class PetriNet {

	public List<Place> Places;
	public List<Transition> Transitions;
	
	public PetriNet(List<Place> places, List<Transition> transitions) {
		this.Places = places;
		this.Transitions = transitions;
	}
	
	public void go(int step) {
		if (step == 1) {
			writePetri(step);
		}else {
			boolean execute = false;
			for (Transition t : Transitions) {
				List<Integer> inputs = t.getInputs();
				List<Integer> outputs = t.getOutputs();
				int count = 0;
				for (int input : inputs) {
					if (CheckPlaces(input)) {
						count++;
					}
				}
				if (count == inputs.size()) {
					if (execute == false) {
						if (t.getTime() == 0) {
							for (int input : inputs) {
								MinusInputs(input);
							}
							for (int output : outputs) {
								PlusOutputs(output);
							}
							writePetri(step);
							execute = true;
						} else {
							t.minusTime();
						}
					}
				}
			}
		}
	}

	private boolean PlusOutputs(int output) {
		// TODO Auto-generated method stub
		for (Place p : Places) {
			if (p.getId() == output) {
				p.plusJeton();
			}
		}
		return false;
	}

	private void MinusInputs(int input) {
		// TODO Auto-generated method stub
		for (Place p : Places) {
			if (p.getId() == input && p.getJeton() > 0) {
				p.minusJeton();
			}
		}
	}

	private boolean CheckPlaces(int input) {
		// TODO Auto-generated method stub
		for (Place p : Places) {
            if (p.getId() == input && p.getJeton() > 0) {
                return true;
            }
        }
		return false;
	}

	private void writePetri(int step) {
		// TODO Auto-generated method stub
		String result = "Result" + step + ":[ ";
		for (Place p : Places) {
			result = result + p.getJeton() + " ";
		}
		result = result + "]\n";
		System.out.println(result);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt", true))) {

            bw.write(result);

        } catch (IOException e) {

            e.printStackTrace();

        }
		
	}
	
	 public boolean canStop() {
		 return false;
	 }
	
}
