import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject{
	Color colors=Color.YELLOW;
	Block(int x,  int y,  int width, int height) {
		super(x, y, width, height);
		speed=1;
	}
	void draw(Graphics g) {
	    	g.setColor(colors);
	    	g.fillRect(x, y, width, height);
	}
	void update(){
		
		super.update();
	}
}
