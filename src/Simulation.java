import java.util.ArrayList;

import processing.core.*;

public class Simulation extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Simulation");
	}

	// global variable declarations

	public static float r = 0.04f;
	public static float currentN = 100f;
	public static float K = 10000f;
	public static float timeStep = 1;

	public static float currentRateChange;
	public static float currentTime;

	// Graph Model
	public ArrayList<GraphPoint> graphA = new ArrayList<GraphPoint>();
	public GraphModel graph = new GraphModel(graphA, this);

	// Data Screen
	public static boolean enabled = false;
	public static boolean enabledClicked = false;
	public DataModel data = new DataModel(this);

	
	//Settings
	public void settings() {
		size(1300, 850);
	}

	//Setup
	public void setup() {
		graph.initialize();

	}

	//Draw
	public void draw() {
		background(0);
		
		if(mousePressed == false) {
		enabledClicked = false;
		}

		if (!enabled) {
			disabled();
		}
		if (enabled) {
			enabled();
		}

	}
	
	//Configuring: Disabled Mode
	public void disabled() {
		data.dataModelEnabled();
		data.drawData();
		
		graph.drawModel();
        
	}

	//Running: Enabled Mode
	public void enabled() {
		Calculations.runIteration();

		graph.runModel();
		graph.drawModel();
		
		data.dataModelDisabled();
		data.drawData();
		

	}

}
