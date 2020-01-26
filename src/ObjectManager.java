import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Paddle paddle;
Projectile ball;
int score=0;
Random random = new Random();
ArrayList<Block> blocks = new ArrayList<Block>();
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ObjectManager (Paddle paddle , Projectile ball){
	  this.paddle=paddle;
	  this.ball=ball;
	  setupBlock();
}
void setupBlock () {
	for (int i=0;i<5;i++) {
for (int i1=0; i1<4;i1++) {
	Block block =new Block(i*45,i1*45,40,40);
	addBlock(block);
}
	}
}
void addProjectile(Projectile projectile){
	  projectiles.add(projectile);
}

public void addBlock(Block blockk) {
	  blocks.add(blockk);
}
void update(){
	 for (int i=0;i<blocks.size();i++) {
		blocks.get(i).update(); 
	 }
		 for (int i=0;i<projectiles.size();i++) {
			projectiles.get(i).update(); 
		 }
		 checkCollision();
		 purgeObjects();
		 paddle.update();
 }
void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, breakout.WIDTH, breakout.HEIGHT);
  for (int i=0;i<blocks.size();i++) {
	  blocks.get(i).draw(g);
  }
  paddle.draw(g);
	  for (int i=0;i<projectiles.size();i++) {
		  projectiles.get(i).draw(g);
	  }
	}

void purgeObjects() {
	for (int i=blocks.size()-1;i>=0;i--) {
		  if (blocks.get(i).isActive==false) {
			  blocks.remove(i);
		  }
	  }
	  for (int i=projectiles.size()-1;i>=0;i--) {
		  if (projectiles.get(i).isActive==false) {
			  projectiles.remove(i);
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
			if (paddle.collisionBox.intersects(blocks.get(i).collisionBox)) {
				paddle.isActive=false;
				blocks.get(i).isActive=false;
			}
			for (int k=0;k<projectiles.size();k++) {
			if (projectiles.get(k).collisionBox.intersects(blocks.get(i).collisionBox)) {
				score++;
				blocks.get(i).isActive=false;
			}
			}
		}
	}
	
}
