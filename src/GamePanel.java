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
	Paddle paddle = new Paddle(200,550,140,10);
	Projectile ball = new Projectile(200,460,50,50);
	ObjectManager objectmanager;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	final int GAMEOVER = 100;
	
	int currentState = MENU;
	Font titleFont = new Font ("Arial", Font.PLAIN, 48);
	Font smallTitleFont = new Font ("Arial", Font.PLAIN, 20);
	Font middleTitleFont = new Font ("Arial", Font.PLAIN, 30);

	GamePanel(){
		frameDraw = new Timer (1000/60, this);
		frameDraw.start();
		objectmanager = new ObjectManager(paddle,ball);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
			
			drawMenuState(g);
			
		}else if(currentState == GAME){
			
			drawGameState(g);
			
		}else if(currentState == END){
			
			drawEndState(g);
			
		}else if (currentState == GAMEOVER) {
			
			drawRestartState(g);
			
		}
	}
	
	void updateMenuState() {  
	}
	
	void updateGameState() {
		
		objectmanager.update();
		
		if (paddle.isActive == true) { 
		
		}
		else if (ball.checkDropOut()) {
			
			System.out.println("In GamePanel.java: ball drops out");
			currentState = GAMEOVER;
			
		}
		else {
			currentState = END;
			
		}
	}
	
	void updateEndState()  {  
		currentState = END;
	}
	
	void updateRestartState()  {  
		currentState = GAMEOVER;
		ball.setPosition(200,460);
		objectmanager.setupBlock();
		paddle.setPosition(200, 550);
		objectmanager.setScore(0);
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
	
	private void drawRestartState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("Game Over", 22, 100);
		g.setFont(smallTitleFont);
		g.drawString("Press ENTER to restart", 150, 400);
		//g.setFont(middleTitleFont);
		//g.drawString("Press SPACE for instructions", 50, 600);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			
			
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    
			if (currentState == END) {
				
		        currentState = MENU;
		        paddle = new Paddle(250,700,80,10);
		        ball = new Projectile(200,650,50,50);
		        objectmanager = new ObjectManager(paddle,ball);
		        System.out.println("current state == END when press enter key");
		        
		    } else if (currentState == GAMEOVER) {
		    	
		    	System.out.println("current game state = GAMEOVER: " + currentState);
		    	currentState = GAME;
		    	startGame();
		    	
		    }
		    else {
		    	
		    	System.out.println("current state START when press enter key");
		    	currentState++;
		    	
		        if (currentState == GAME) {
		        	startGame();
		        	
		        }
		        
//		        if (GAME==END) {
//		        	blockSpawn.stop();
//		        	System.out.println(" in timer block, current game state " + currentState);
//		        }
		    }
		} 
		
		if (e.getKeyCode()==KeyEvent.VK_Q) {
		   objectmanager.gotolevel2();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    
		    paddle.right();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    
		    paddle.left();
		}
		
	}
	
	void startGame() {
		// TODO Auto-generated method stub
		blockSpawn = new Timer(1000 , objectmanager);
		blockSpawn.start();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    
			updateMenuState();
		    
		}else if(currentState == GAME){
			
		    updateGameState();
		    
		    if (ball.checkDropOut()) {
				
				System.out.println("In GamePanel.java, actionPerformed: ball drops out");
				currentState = GAMEOVER;
				updateRestartState();
			}
		    
		}else if(currentState == END){
			// when finish level 1
			
		    updateEndState();
		    
		}else if (currentState == GAMEOVER) {
			
			updateRestartState();
		}
		repaint();
		
	}

}
