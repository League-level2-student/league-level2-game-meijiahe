import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class ChangeColorBlock extends Block{
	Random random = new Random();
	Random n = new Random();
	
	Color [] c= {Color.red, Color.orange, Color.yellow, Color.green,  Color.blue,Color.magenta, Color.white};
	ChangeColorBlock(int x, int y, int width, int height, int health) {
		
		super(x, y, width, height, health);
		
	}
	void takeDamage() {
		super.takeDamage();
		System.out.println("Changecolor Block");
//		if (Projectile.color == Color.YELLOW) {
//			Projectile.color=Color.GREEN;
//		}
//		else {
		Projectile.color = c[n.nextInt(c.length)];
		//}
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
