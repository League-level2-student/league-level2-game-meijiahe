import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
public static Paddle paddle;
Projectile ball;
public static int score=0;
Random random = new Random();
public static ArrayList<Block> blocks = new ArrayList<Block>();
ObjectManager (Paddle paddle , Projectile ball){
	  this.paddle=paddle;
	  this.ball=ball;
	  setupBlock();
}
void setupBlock () {
	for (int i=0;i<12;i++) {
for (int i1=0; i1<7;i1++) {
	Block block =new Block(i*45,i1*45,40,40);
	addBlock(block);
}
	}
}


public void addBlock(Block blockk) {
	  blocks.add(blockk);
}
void update(){
	 for (int i=0;i<blocks.size();i++) {
		blocks.get(i).update(); 
	 }
		
		 purgeObjects();
		 paddle.update();
		 ball.update();
		 checkCollision();
 }
void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
  for (int i=0;i<blocks.size();i++) {
	  blocks.get(i).draw(g);
  }
  paddle.draw(g);
ball.draw(g);
	  g.drawString(score+"",breakout.WIDTH-50, 20);
	}

void purgeObjects() {
	for (int i=blocks.size()-1;i>=0;i--) {
		  if (blocks.get(i).isActive==false) {
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

	void checkCollision() {
		for (int i=0;i<blocks.size();i++) {
			if (paddle.collisionBox.intersects(ball.collisionBox)) {
				//ball.bounce();
			}
			
			if (ball.collisionBox.intersects(blocks.get(i).collisionBox)) {
				score++;
				blocks.get(i).isActive=false;
				//ball.bounce();
			}
			
		}
	}
	
}
