import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PunishBlock extends Block implements ActionListener {
	Timer punishtimer;
	Color [] c= {new Color(232, 93, 90),new Color(224, 64, 61),new Color(219, 49, 46),new Color(207, 34, 31),new Color(196, 25, 22),new Color(176, 20, 18),new Color(143, 17, 16)};
	PunishBlock(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		punishtimer=new Timer(10000, this);
		punishtimer.start();
	}
	
	
	void takeDamage() {
		super.takeDamage();
		//super.health += 10;
		System.out.println("Punish Block!");
	}
	

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		g.setColor(Color.GREEN);
		g.drawString("Danger!", x, y+10);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
