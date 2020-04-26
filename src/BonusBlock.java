import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BonusBlock extends Block implements ActionListener{
	Timer bonustimer;
	Color [] c= {new Color(237, 234, 138),new Color(230, 226, 103),new Color(224, 220, 83),new Color(201, 198, 64),new Color(181, 178, 43),new Color(161, 158, 27),new Color(140, 138, 20)};
	BonusBlock(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		bonustimer=new Timer(10000, this);
bonustimer.start();
	}
	
	void takeDamage() {
		super.takeDamage();
		//super.health += 10;
		System.out.println("Bonus Block!");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
