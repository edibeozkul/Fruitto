package main.ui;
import processing.core.PApplet;

public class UI {
	PApplet parent;
	
	public UI(PApplet parent){
		this.parent=parent;
	}
	
	public void render() {
		parent.push();
		parent.pop();
	}
}
