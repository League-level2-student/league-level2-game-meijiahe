import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer frameDraw;
Timer blockSpawn;
Paddle paddle = new Paddle(50,50,60,10);
ObjectManager objectmanager = new ObjectManager(paddle);
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Font titleFont = new Font ("Arial", Font.PLAIN, 48);
Font smallTitleFont = new Font ("Arial", Font.PLAIN, 20);
Font middleTitleFont = new Font ("Arial", Font.PLAIN, 30);
@Override
public void paintComponent(Graphics g) {
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}
}
void updateMenuState() {  
}
void updateGameState() {  
	objectmanager.update();
	if (paddle.isActive==true) { 
	}
	else {
		currentState = END;
	}
}
void updateEndState()  {  
	 
}
	private void drawEndState(Graphics g) {
	// TODO Auto-generated method stub
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Game Over", 151, 100);
		 g.setFont(smallTitleFont);
		 g.drawString("You killed"+objectmanager.getScore()+" enemies", 150, 400);
		 g.setFont(middleTitleFont);
		 g.drawString("Press ENTER to start", 100, 600);
}
	private void drawGameState(Graphics g) {
	// TODO Auto-generated method stub
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		 objectmanager.draw(g);
}
	private void drawMenuState(Graphics g) {
	// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		 g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.RED);
		 g.drawString("BREAKOUT", 22, 100);
		 g.setFont(smallTitleFont);
		 g.drawString("Press ENTER to start", 150, 400);
		 g.setFont(middleTitleFont);
		 g.drawString("Press SPACE for instructions", 50, 600);
}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
