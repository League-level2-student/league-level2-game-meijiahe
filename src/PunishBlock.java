import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PunishBlock extends Block implements ActionListener {
	Timer punishtimer;
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
