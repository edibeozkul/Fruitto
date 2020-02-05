package main.gameObject;
import javax.swing.plaf.ProgressBarUI;
import java.applet.Applet;
import javax.swing.JOptionPane;
import main.Fruitto;
import main.utils.BoxCollider;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Fruit extends GameObject 
{
	float speed;
	float cooldownMax = 200.0f;
	float cooldownMin = 50.0f;
	float leftTime;
	public float damage=1;
	
	 public Fruit(PApplet parent, String tag, PImage img, float x, float y, float speed){
		 super(parent, tag, new PVector(x,y),img,2);
		    this.speed = speed;
		    collider=new BoxCollider(parent, pos, new PVector(img.width, img.height));
			leftTime = parent.random(cooldownMin, cooldownMax);

		  }
	 @Override
	
	 public void update() 
	 {
		leftTime -= Fruitto.deltaTime;
		
		if (pos.y < parent.height) 
		{
			pos.y += speed * Fruitto.deltaTime;
		      if (pos.y > parent.height)
		      {
		    	  pos.y=parent.height/1f;
			  }
		      
		}		
			collider.moveCollider(pos);
			
			for(Fruit f:Fruitto.fruits) 
			{
				if(collider.isCollided(f.collider) && f.tag != tag)
				{
					health-=f.damage;
					f.health--;
					score++;
				}
			}
			move();
	 }
	
	 public void move() 
	 {
		
   		 if(pos.y<0) pos.y=0; 
		 else if(pos.y+img.height>parent.height) { pos.y=parent.height-img.height; pos.y=0; JOptionPane.showMessageDialog(null, "GAME OVER \n SCORE: " + Fruitto.player.score); System.exit(0); }
		 
	 }
	 
}