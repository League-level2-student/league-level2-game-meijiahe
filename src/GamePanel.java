import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer frameDraw;
	Timer blockSpawn;
	
	Paddle paddle = new Paddle(200,650,140,10);
	public static Projectile ball = new Projectile(200,460,50,50);
	ObjectManager objectmanager;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	
	final int INSTRUCTION = 200;
	final int GAMEOVER = 100;
	
	int currentState = MENU;
	Font titleFont = new Font ("Arial", Font.PLAIN, 48);
	Font smallTitleFont = new Font ("Arial", Font.PLAIN, 20);
	Font middleTitleFont = new Font ("Arial", Font.PLAIN, 30);

	GamePanel(){
		frameDraw = new Timer (1000/60, this);
		frameDraw.start();
		objectmanager = new ObjectManager(paddle,ball);
		  if (needImage) {
			    loadImage ("unnamed.jpg");
			}
	}
	 void loadImage(String imageFile) {
		    if (needImage) {
		        try {
		        	 System.out.println("It work!");
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			    gotImage = true;
			    
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        needImage = false;
		    }
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
			
		}else if(currentState == INSTRUCTION) {
			drawInstructionState(g);
		}
	}
	
	void updateMenuState() {  
		currentState = MENU;
	}
	
	void updateGameState() {
		
		objectmanager.update();
		
		if (paddle.isActive == true) { 
//	System.out.println("paddle active??????????????????");
		}
	
	else if (objectmanager.ball.checkDropOut()) {
		
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
	
	
	void updateInstructionState()  {  
		currentState = INSTRUCTION;
	}
	
	void updateRestartState()  {  
		System.out.println("after drop ou, updateRestartState");
		currentState = GAMEOVER;
		ball.setPosition(200,460);
		ball.resetSpeed();
		objectmanager.clearBlocks();
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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		 objectmanager.draw(g);
	}
	

	
	
	private void drawMenuState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		if (gotImage) {
			g.drawImage(image, 0, 0, breakout.WIDTH, breakout.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		}
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("BREAKOUT", 30, 100);
		g.setFont(middleTitleFont);
		g.drawString("Press ENTER to start", 40, 320);
		g.setFont(middleTitleFont);
		g.drawString("Press SPACE for instructions", 50, 600);
	}
	

	private void drawInstructionState(Graphics g) {
		// TODO Auto-generated method stub
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.BLUE);
			g.drawString("BREAKOUT", 30, 100);
			g.setFont(smallTitleFont);
			g.drawString("Move the paddle using left OR right key to play!", 40, 280);
			g.drawString("Try to kill all blocks without letting " , 40, 320);
			g.drawString("the ball drop out of the screen.", 40, 340);
			g.setFont(middleTitleFont);
			g.drawString("Press SPACE return to the MENU", 50, 600);
		}
	
	private void drawRestartState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 22, 100);
		g.setFont(smallTitleFont);
		g.drawString("Press ENTER to restart!", 120, 340);
		
		g.drawString("Press SPACE to back to the menu", 120, 500);
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = INSTRUCTION;
			} else if (currentState == INSTRUCTION ){
				currentState = MENU;
			} else if (currentState == GAMEOVER ) {
				currentState=MENU;
			}
			
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    
			if (currentState == END) {
				
		        currentState = MENU;
		        paddle = new Paddle(200,650,140,10);
		        ball = new Projectile(200,460,50,50);
		        objectmanager = new ObjectManager(paddle,ball);
		        System.out.println("current state == END when press enter key");
		        
		    } else if (currentState == GAMEOVER) {
		    	paddle = new Paddle(200,650,140,10);
		        ball = new Projectile(200,460,50,50);
		        objectmanager = new ObjectManager(paddle,ball);
		    	//System.out.println("current game state = GAMEOVER: " + currentState);
		    	currentState = GAME;
		    	//startGame();//
		    	
		    }
		    else if (currentState == MENU) {
		    	startGame();
		    	
		    	currentState = GAME;
		    }
			
		    else{
		    	
		        if (currentState == GAME) {
		        	startGame();
		        	
		        }
		        
		   }
		} 
		
		if (e.getKeyCode()==KeyEvent.VK_Q) {
			currentState = GAME;
		   objectmanager.gotolevel2();
		   //updateGameState();
		}
		if (e.getKeyCode()==KeyEvent.VK_W) {
			currentState = GAME;
			  objectmanager.gotolevel3();
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
			//System.out.println("In GamePanel.java, actionPerformed currentState = MENU");
		    
		}else if(currentState == GAME){
			
		    updateGameState();
		    
		    if (objectmanager.ball.checkDropOut()) {
				
				System.out.println("In GamePanel.java, actionPerformed: ball drops out");
				currentState = GAMEOVER;
				
			}
		    
		}else if(currentState == END){
			// when finish level 1
			
		    updateEndState();
		    
		}else if (currentState == GAMEOVER) {
			
			updateRestartState();
			
		}else if (currentState == INSTRUCTION) {
			updateInstructionState();
		}
		
		repaint();
		
	}

}
