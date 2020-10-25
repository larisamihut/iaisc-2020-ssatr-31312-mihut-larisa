package simulation;

import java.util.List;

public class Transition {

	private List<Integer> inputs;
	private List<Integer> outputs;
	private int tmin;
	private int tmax;
	private int time;
	
	public Transition(List<Integer> inputs, List<Integer> outputs, int tmin, int tmax) {
		this.setInputs(inputs);
		this.setOutputs(outputs);
		this.tmin = tmin;
		this.tmax = tmax;
		this.setTime(tmin + (int) (Math.random() * ((tmax - tmin) + 1)));
	}

	public List<Integer> getInputs() {
		return inputs;
	}

	public void setInputs(List<Integer> inputs) {
		this.inputs = inputs;
	}

	public List<Integer> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Integer> outputs) {
		this.outputs = outputs;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void minusTime() {
		this.time--;
	}
	
}
