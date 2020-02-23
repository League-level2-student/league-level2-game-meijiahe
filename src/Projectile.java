import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
int speedx;
int speedy;
int collide;
	Projectile (int x, int y, int width, int height){
		super(x, y, width, height);
		speed=7;
		speedx=speed;
		speedy=speed;
		
		
	}
	void update() {
		speed=10+ObjectManager.score/10;
		checkBoundary();
		if (checkCollision(x+speedx,y+speedy)) {
			bounce(collide);
		}
		else {
			x+=speedx;
		y+=speedy;
		}
		super.update();
		
	}
void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillOval(x, y, width, height);
	super.draw(g);
}
void timer () {
	//Timer time = new Timer();
}

void bounce(int direct){
	if (direct==0||direct==2) {
		speedx=-speedx;
	}
	if (direct==1||direct==2) {
		speedy=-speedy;
	}
}
void checkBoundary() {
	if (x > breakout.WIDTH-width) {
		speedx=-speed;
	}
	if(x<0) {
		speedx=speed;
	}
	if(y>breakout.HEIGHT) {
		speedy=-speed;
	}
	if(y<-height) {
		speedy=speed;
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
			ObjectManager.blocks.get(i).takeDamage();
			int bx = ObjectManager.blocks.get(i).x+ObjectManager.blocks.get(i).width/2;
			int by=ObjectManager.blocks.get(i).y+ObjectManager.blocks.get(i).width/2;
			int xDif=Math.abs(rect.x-bx);
			int yDif=Math.abs(rect.y-by);
			if (xDif>yDif) {
				collide=0;
			}
			else {
				collide=1;
				
			}
			return true;
		}
	
	}
	return false;
}
void teleportToPaddle () {
	this.x=ObjectManager.paddle.x+ObjectManager.paddle.width/2;
	this.y=ObjectManager.paddle.y-height-10;
}
}
