package main.ui;

import main.Fruitto;
import processing.core.PApplet;

public class InGameUI extends UI
	{
	public InGameUI(PApplet parent) {
	super(parent);
	}
	
	@Override
	
	public void render() {
		
		parent.push();
		parent.fill(255);
		parent.textSize(32);
		parent.textAlign(parent.LEFT, parent.TOP);
		parent.text("Score: "+ Fruitto.player.score,0,0);
		parent.pop();
		
	}
}
