import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	
	int x;
	int x1;
	int y;
	int y1;
	int width;
	int width1;
	int height;
	int height1;
	int speed = 0; 
	boolean isActive = true;
	Rectangle collisionBox;
	 
	GameObject(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		
		this.width=width;
		this.height=height;
		
		this.speed = 0;
		this.isActive = true;
		collisionBox = new Rectangle(x, y, width, height);
		 
	}
	
	void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);
	}
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
