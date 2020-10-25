package simulation;

import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("result.txt");
        writer.print("");
        writer.close();
        Engine e = new Engine(GeneratePetri.generatePetriModel("Petri_temporizata.json"));
        e.start();
    }
}
