package main.utils;
import main.Fruitto;
import main.gameObject.Fruit;
import processing.core.PApplet;

public class NewFruit {
	
	public PApplet parent;
	public float max,min;
	public float leftTime;

		public NewFruit(PApplet parent, float max, float min) {
		this.parent=parent;
		this.max=max;
		this.min=min;
		leftTime=parent.random(min,max);
	}
	
	public void update()
	{
		leftTime-=Fruitto.deltaTime;
		
		if(leftTime<=0) 
		{
			Fruit fruit=new Fruit(parent, Fruitto.tag_fruit, Fruitto.fruitImage,   
			parent.random(parent.width), -Fruitto.fruitImage.height, 0.5f);
			Fruitto.fruits.add(fruit);
			leftTime=parent.random(min,max);
			
		}
	}
}
