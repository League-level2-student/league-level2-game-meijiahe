import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObjectManager implements ActionListener {
	public static Paddle paddle;
	Projectile ball;
	int currentlevel = 1;
	public static int score = 0;
	Random random = new Random();
	Random n = new Random();
	private GamePanel g;
	public static ArrayList<Block> blocks = new ArrayList<Block>();

	ObjectManager(Paddle paddle, Projectile ball) {
		this.paddle = paddle;
		this.ball = ball;
		setupBlock();
	}
	
	void setScore(int x) {
		score = x;
	}
	
	void clearBlocks()
	{
		blocks = new ArrayList<Block>();
	}
	void setupBlock() {
		for (int i = 0; i < 12; i++) {
			for (int i1 = 0; i1 < 7; i1++) {
				int hp=2;
				Block block = new Block(i * 45, i1 * 45, 40, 40, hp);
				if(i==n.nextInt(12)) {
					block=new RehealingBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				
				if (i==n.nextInt(12)) {
					block=new ChangeColorBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				addBlock(block);
			}
		}
	}
	void setupBlock2() {
		System.out.println("in level 2 right now");
		ball=new Projectile(200,460,50,50);
		ball.speed=9;
		for (int i = 0; i < 12; i++) {
			
			for (int i1 = 0; i1 < 7; i1++) {
				int hp=4;
				Block block = new Block(i * 45, i1 * 45, 40, 40, hp);
				if(i==n.nextInt(12)) {
					block=new RehealingBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				if(i==n.nextInt(12)) {
					block=new BonusBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				
				if(i==n.nextInt(12)) {
					block=new PunishBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				addBlock(block);
			}
		}
	}
	void setupBlock3() {
		System.out.println("in level 3 right now");
		ball=new Projectile(200,460,50,50);
		ball.speed=9;
		for (int i = 0; i < 12; i++) {
			
			for (int i1 = 0; i1 < 7; i1++) {
				int hp=4;
				Block block = new Block(i * 45, i1 * 45, 40, 40, hp);
				if(i==n.nextInt(10)) {
					block=new RehealingBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				if(i==n.nextInt(6)) {
					block=new BonusBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				
				if(i==n.nextInt(12)) {
					block=new PunishBlock(i * 45, i1 * 45, 40, 40, hp);
				}
				addBlock(block);
			}
		}
	}

	public void addBlock(Block blockk) {
		blocks.add(blockk);
	}

	void update() {
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).update();
		}
		
		if(checkifwin() && currentlevel==1) {
			gotolevel2();
		}
		if(checkifwin()&&currentlevel==2) {
			gotolevel3();
		}
		
		purgeObjects();
		paddle.update();
		ball.update();
	}
	boolean checkifwin() {
		if (blocks.size()==0) {
			return true;
		}
		boolean onlyifpunishbleft=true;
		for (int i=0;i<blocks.size();i++){
			if (!(blocks.get(i) instanceof PunishBlock)) {
				onlyifpunishbleft=false;
			}
		}
		if (onlyifpunishbleft==false) {
			return false;
		}
		else {
			return true;
		}
	}
	public void gotolevel2() {
		currentlevel++;
		ball.x=400;
		ball.y=600;
		setupBlock2();
	}
	public void gotolevel3() {
		currentlevel++;
		ball.x=400;
		ball.y=600;
		setupBlock3();
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < blocks.size(); i++) {
			blocks.get(i).draw(g);
		}
		
		paddle.draw(g);
		ball.draw(g);
		
		g.setColor(Color.YELLOW);
		g.drawString(score + "", breakout.WIDTH - 50, 20);
	}

	void purgeObjects() {
		for (int i = blocks.size() - 1; i >= 0; i--) {
			if (blocks.get(i).isActive == false) {
				blocks.remove(i);
			}
		}

	}
	

	public int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
