import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class ChangeColorBlock extends Block{
	Random random = new Random();
	Random n = new Random();
	
	Color [] c= {new Color(237, 139, 100),new Color(194, 111, 78),new Color(166, 66, 27),new Color(143, 54, 20),new Color(128, 46, 15),new Color(110, 38, 11),new Color(128, 38, 5)};
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
	
}
