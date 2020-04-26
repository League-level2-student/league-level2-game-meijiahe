import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class RehealingBlock extends Block implements ActionListener{
Timer healingtimer;
	RehealingBlock(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		healingtimer=new Timer(10000, this);
		healingtimer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		health++;
	}

}
