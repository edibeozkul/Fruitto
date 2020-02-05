package main;
import main.ui.*;
import java.util.ArrayList;
import main.gameObject.Fruit;
import main.gameObject.Player;
import main.utils.NewFruit;
import processing.core.PApplet;
import processing.core.PImage;

public class Fruitto extends PApplet {
	public static void main(String [] args) 
	{
		PApplet.main("main.Fruitto");
	}
	
	public void settings() {
		size(1200,800);
	}

	public static final String tag_player="player";
	public static final String tag_fruit="fruit";
 
	public static PImage playerImage, fruitImage;
	public static PImage bg;
	public static float deltaTime;
	public static Player player;
    public static ArrayList<Fruit>fruits;
	public static NewFruit newFruit;
	public static InGameUI inGameUI;
	 
	 
	public void setup() {
	  size(1200, 800);
	  bg= loadImage("C:/Users/edibe/Desktop/Fruitto/res/bg1.png");
	  playerImage  = loadImage("C:/Users/edibe/Desktop/Fruitto/res/player.png");
	  fruitImage = loadImage("C:/Users/edibe/Desktop/Fruitto/res/fruit.png");
	  player= new Player(this, tag_player,playerImage, width/2-playerImage.width/2, height-playerImage.height, 10f);
	  fruits=new ArrayList<Fruit>();
	  newFruit = new NewFruit(this, 2000, 1000);
	  inGameUI = new InGameUI(this);
	  t1=millis();
	}

	float t1, t2;
	public static boolean[] keys=new boolean[2] ;

	public void keyPressed()
	{
	  if(key=='A' || key =='a') keys[0]=true;
	  if(key=='d' || key=='D') keys[1]=true;
	 
	  
	}
	
	public void keyReleased()
	{
	  if( key=='A' || key=='a' ) keys[0]=false;
	  if( key=='d' || key =='D') keys[1]=false;
	 
	}
	
	public void draw() 
	{
		background(358574);
		t2 = millis();
		deltaTime = (t2-t1);
		wrap(bg, -500, -500, width, height);
		player.update();
		
		for (int i=fruits.size() -1; i>=0; i--) 
		{
			if(fruits.get(i).health<=0) fruits.remove(i);
			else fruits.get(i).update();
			
		}
		
		newFruit.update();
		
		for(Fruit f:fruits)  
			f.render();
				player.render();
		inGameUI.render(); 
		
		t1 = millis();
	
	}

	void wrap(PImage img, float x1, float y1, float x2, float y2)
	{
	  for(float x=x1; x<x2; x+=img.width)
	  { 
	    for(float y=y1; y<y2; y+=img.height)
	    {
	    image(img, x,y);
	    }
	  }
	}

}
