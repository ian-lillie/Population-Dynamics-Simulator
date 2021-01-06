import java.util.ArrayList;

import processing.core.PApplet;

public class GraphModel {
	
	PApplet parent;
	
	private ArrayList<GraphPoint> points = new ArrayList<GraphPoint>();
	
	GraphModel(ArrayList<GraphPoint> points, PApplet p) {
		this.points = points;
		parent = p;
	}
	
	public void initialize() {
		points.add(new GraphPoint(Simulation.currentTime, Simulation.currentN));
	}
	
	public void runModel() {
		points.add(new GraphPoint(Simulation.currentTime, Simulation.currentN));
		
	}
	

	public void drawModel() {
		parent.stroke(255);
	    parent.line(100, 800, 900, 800); //time axis from 100 to 900 (LENGTH OF 800)
	    parent.line(100, 100, 100, 800); //value axis from 100 to 800 (HEIGHT OF 700)
	    
	    
	    float timeAxisDifference = defineTimeAxis();
	    float valueAxisDifference = defineValueAxis();
	    
	    axisLabels(timeAxisDifference, valueAxisDifference);
	    
	    parent.noFill();
	    parent.stroke(255, 0, 0);
	    
	    parent.beginShape();
	    for(int i = 0; i < points.size(); i ++) {
	      float xPosition = (points.get(i).getTime() / timeAxisDifference) * 800;
	      xPosition = xPosition + 100;
	      
	      float yPosition = -(points.get(i).getValue() / valueAxisDifference) * 700;
	      yPosition = 800 + yPosition;
	   
	      parent.curveVertex(xPosition, yPosition);
	    }
	    parent.endShape();
	}
	

	
	public float defineTimeAxis() {
		float timeLength = 0;
		for(int i = 0; i < points.size(); i++) {
			if(points.get(i).getTime() > timeLength) {
				timeLength = points.get(i).getTime();
			}
		}
		
		return timeLength;
		
	}
	
	public float defineValueAxis() {
		float valueLength = 0;
		for(int i = 0; i < points.size(); i++) {
			if(points.get(i).getValue() > valueLength) {
				valueLength = points.get(i).getValue();
			}
		}
		return valueLength;
		
	}
	
	public void axisLabels(float timeAxisDifference, float valueAxisDifference) {
		parent.textAlign(parent.CENTER);
		parent.text("Time Elapsed", 500, 830);
		   
	    parent.translate(30, 450);
	    parent.rotate((float) -(Math.PI/2));
	    parent.text("Population Size", 0, 0);
	    
	    parent.rotate((float) (Math.PI/2));
	    parent.translate(-30, -450);
	    
	    parent.line(500, 790, 500, 810);
	    parent.line(900, 790, 900, 810);
	    parent.text(timeAxisDifference/2, 500, 820);
	    parent.text(timeAxisDifference, 900, 820);
	    
	    parent.line(90, 450, 110, 450);
	    parent.line(90, 90, 110, 90);
	    parent.text(valueAxisDifference/2, 70, 450);
	    parent.text(valueAxisDifference, 70, 100);
	    
	    
	}

}
