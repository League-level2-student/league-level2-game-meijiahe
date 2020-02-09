import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
int speedx;
int speedy;
int collide;
	Projectile (int x, int y, int width, int height){
		super(x, y, width, height);
		speed=10;
		speedx=speed;
		speedy=speed;
		
		
	}
	void update() {
		if (checkCollision(x+speedx,y+speedy)) {
			bounce(collide);
		}
		else {
			x+=speedx;
		y+=speedy;
		}
		super.update();
		checkBoundary();
	}
void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillOval(x, y, width, height);
	super.draw(g);
}


void bounce(int direct){
	if (direct==0||direct==2) {
		speedx=-speedx;
	}
	if (direct==1||direct==2) {
		speedy=-speedy;
	}
	
	speedx=-speedx;
	speedy=-speedy;
	System.out.println("hh");
}
void checkBoundary() {
	if (x < breakout.WIDTH) {
		speedx=-speedx;
	}
	if(x>0) {
		speedx=-speedx;
	}
	if(y<breakout.HEIGHT) {
		speedy=-speedy;
	}
	if(y>0) {
		speedy=-speedy;
	}
}
boolean checkCollision(int x,int y) {
	Rectangle rect=new Rectangle(x,y,width,height);
	for (int i=0;i<ObjectManager.blocks.size();i++) {
		if (ObjectManager.paddle.collisionBox.intersects(rect)) {
			collide=1;
			return true;
		}
		
		if (rect.intersects(ObjectManager.blocks.get(i).collisionBox)) {
			ObjectManager.score++;
			ObjectManager.blocks.get(i).isActive=false;
			collide=2;
			return true;
		}
	
	}
	return false;
}
}
