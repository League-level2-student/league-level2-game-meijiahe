import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Paddle extends GameObject{
	
	Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 50;
	}
void draw(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
}
public void right() {
	if (x < breakout.WIDTH) {
		x += speed;
	}
}

public void left() {
	if (x > 0)
		x -= speed;
}

public void up() {
	if (y < breakout.HEIGHT) {
		y -= speed;
	}
}

public void down() {
	if (y > 0) {
		y += speed;
	}
}
	private void loadImage(String string) {
		// TODO Auto-generated method stub
		
	}
	public Projectile getProjectile() {
		// TODO Auto-generated method stub
		return null;
	}
}
