import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class RehealingBlock extends Block implements ActionListener{
Timer healingtimer;

Color [] c= {new Color(62, 235, 49),new Color(49, 199, 38),new Color(39, 166, 30),new Color(28, 140, 20),new Color(17, 110, 10),new Color(12, 84, 7),new Color(7, 61, 3)};
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
