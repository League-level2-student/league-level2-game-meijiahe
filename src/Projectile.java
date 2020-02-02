import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
int speedx;
int speedy;
	Projectile (int x, int y, int width, int height){
		super(x, y, width, height);
		speed=10;
		speedx=speed;
		speedy=speed;
		
		
	}
	void update() {
		x+=speedx;
		y+=speedy;
		super.update();
		checkBoundary();
	}
void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillOval(x, y, width, height);
}


void bounce(){
	speedx=-speedx;
	speedy=-speedy;
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
}
