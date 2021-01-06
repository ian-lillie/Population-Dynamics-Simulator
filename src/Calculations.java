import processing.core.PApplet;

public class Calculations{
	
	PApplet parent;
	
	public static void runIteration() {
		
		float rN = Simulation.r * Simulation.currentN;
		float NdivK = Simulation.currentN/Simulation.K;
		Simulation.currentRateChange = rN * (1 - NdivK);
		
		Simulation.currentN = Simulation.currentN + (Simulation.currentRateChange * Simulation.timeStep);
		
		Simulation.currentTime = Simulation.currentTime + Simulation.timeStep;
		
	}

}
