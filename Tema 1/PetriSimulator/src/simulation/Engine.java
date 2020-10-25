package simulation;

public class Engine extends Thread{

	private PetriNet pn;
	boolean active = true;
	
	public Engine(PetriNet pn) {
		this.pn = pn;
	}
	
	public void run() {
		int step = 0;
		while(!pn.canStop()) {
            step++;
            pn.go(step);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}

