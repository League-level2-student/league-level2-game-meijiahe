import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BonusBlock extends Block implements ActionListener{
	Timer bonustimer;
	BonusBlock(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		bonustimer=new Timer(10000, this);
bonustimer.start();
	}
	
	void takeDamage() {
		super.takeDamage();
		System.out.println("Bonus Block!");
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
