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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		health++;
	}

}
