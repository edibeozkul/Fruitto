package main.gameObject;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;
import org.omg.CORBA.PUBLIC_MEMBER;
import main.Fruitto;
import main.utils.BoxCollider;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends GameObject
{
	  float coolDown=100;
	  float leftTime;
	  float speed;
	  public Player(PApplet parent,String tag, PImage img, float x, float y, float speed){
	  super(parent, tag, new PVector(x,y),img,5);
	    this.speed = speed;
	    collider=new BoxCollider(parent, pos, new PVector(img.width, img.height));
	   leftTime=0;
	  }

	  @Override
	  
	  public void update()
	  {
		  move();
		  if(leftTime>0) leftTime-=Fruitto.deltaTime;
		 
	  }
	 
	  public void move() 
	  {
    	 if(Fruitto.keys[0])  pos.x-=speed;
		 if(Fruitto.keys[1])  pos.x+=speed;
	
		  
		 if(pos.x<0) pos.x=0;
		  else if(pos.x+img.width>parent.width) pos.x=parent.width-img.width;

		 if(pos.y<0) pos.y=0;
		  else if(pos.y+img.height>parent.height) pos.y=parent.height-img.height;

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
	}
}
