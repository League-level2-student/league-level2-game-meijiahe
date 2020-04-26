import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject{
	
	Color colors=Color.YELLOW;
	int health;
	Color [] c= {new Color(255,0,0),new Color(100,200,50),new Color(70,40,100),new Color(0,100,60)};
	
	Block(int x,  int y,  int width, int height,int health) {
		super(x, y, width, height);
		speed=1;
		this.health=health;
	}
	
	void draw(Graphics g) {
		if (health<c.length) {
			g.setColor(c[health]);
		}
		else {
			g.setColor(Color.GRAY);
		}
	    	g.fillRect(x, y, width, height);
	}
	
	void takeDamage() {
		if (health==1) {
			health=0;
			isActive=false;
		}
		else {
			health--;
		}
		System.out.println("health :" + health);
	}
	
	
	void update(){
		
		super.update();
	}
}
