import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Paddle paddle;
int score=0;
ObjectManager (Paddle paddle){
	  this.paddle=paddle;
}
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
void addProjectile(Projectile projectile){
	  projectiles.add(projectile);
}
ArrayList<Block> blocks = new ArrayList<Block>();
Random random = new Random();
void addAlien() {
	  blocks.add(new Block(random.nextInt(breakout.WIDTH),0,50,50));
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public String getScore() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
