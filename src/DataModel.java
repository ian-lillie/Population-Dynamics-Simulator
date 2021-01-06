import processing.core.PApplet;
import sun.security.tools.keytool.Main;

public class DataModel implements Model {
	
	//column between 1000 and 1300 and 0 to 850 in height
	
	PApplet parent;
	
	public DataModel(PApplet p) {
		parent = p;
	}
	
	public void dataModelDisabled() {
		parent.fill(255, 0, 0);
		//if
		
		if(parent.mouseY > 650 && parent.mouseY < 750 && parent.mousePressed == true && Simulation.enabledClicked == false) {
			Simulation.enabled = false;
			Simulation.enabledClicked = true;
		}
	}
	
	public void dataModelEnabled() {
		parent.fill(0, 255, 0);
		
		if(parent.mouseY > 50 && parent.mouseY < 80 && parent.mousePressed == true) {
			Simulation.r = Simulation.r + .01f;
		}
		
		if(parent.mouseY > 120 && parent.mouseY < 150 && parent.mousePressed == true) {
			Simulation.r = Simulation.r -.01f;
		}
		
		if(parent.mouseY > 200 && parent.mouseY < 230 && parent.mousePressed == true) {
			Simulation.currentN = Simulation.currentN + 100f;
		}
		
		if(parent.mouseY > 270 && parent.mouseY < 300 && parent.mousePressed == true) {
			Simulation.currentN = Simulation.currentN - 100f;
		}
		
		if(parent.mouseY > 350 && parent.mouseY < 380 && parent.mousePressed == true) {
			Simulation.K = Simulation.K + 100f;
		}
		
		if(parent.mouseY > 420 && parent.mouseY < 450 && parent.mousePressed == true) {
			Simulation.K = Simulation.K - 100f;
		}
		
		if(parent.mouseY > 500 && parent.mouseY < 530 && parent.mousePressed == true) {
			Simulation.timeStep = Simulation.timeStep + .1f;
		}
		
		if(parent.mouseY > 570 && parent.mouseY < 600 && parent.mousePressed == true) {
			Simulation.timeStep = Simulation.timeStep - .1f;
		}
		
		if(parent.mouseY > 650 && parent.mouseY < 750 && parent.mousePressed == true && Simulation.enabledClicked == false) {
			Simulation.enabled = true;
			Simulation.enabledClicked = true;
		}
	}
	
	public void drawData() {
		
		parent.triangle(1100, 80, 1150, 50, 1200, 80);
		parent.triangle(1100, 120, 1150, 150, 1200, 120);
		
		parent.triangle(1100, 230, 1150, 200, 1200, 230);
		parent.triangle(1100, 270, 1150, 300, 1200, 270);
		
		parent.triangle(1100, 380, 1150, 350, 1200, 380);
		parent.triangle(1100, 420, 1150, 450, 1200, 420);
		
		parent.triangle(1100, 530, 1150, 500, 1200, 530);
		parent.triangle(1100, 570, 1150, 600, 1200, 570);
		
		parent.rect(1100, 650, 100, 100);
		
		parent.fill(255);
		parent.textSize(20);
		parent.textAlign(parent.CENTER);
		
		parent.text("R Value: " + ((float)PApplet.round(Simulation.r * 100)), 1150, 100);
		parent.text("Population: " + Simulation.currentN, 1150, 250);
		parent.text("Carrying Capacity: " + Simulation.K, 1150, 400);
		parent.text("Time Step " + Simulation.timeStep, 1150, 550);
		parent.text("Current Time: " + Simulation.currentTime, 1150, 825);
		
		parent.textSize(15);
		
		
		
		
		
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
