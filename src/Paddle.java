import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Paddle extends GameObject{
	
	Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 50;
	}

	void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		super.draw(g);
	}
	
	public void right() {
		if (x + width < breakout.WIDTH) {
			x += speed;
		}
	}

	public void left() {
		if (x > 0)
			x -= speed;
	}
	
	void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}

	private void loadImage(String string) {
		// TODO Auto-generated method stub
		
	}
	public Projectile getProjectile() {
		// TODO Auto-generated method stub
		return null;
	}
}
