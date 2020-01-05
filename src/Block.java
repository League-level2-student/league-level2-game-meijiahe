
public class Block extends GameObject{
	Block(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=1;
	}
	void update(){
		y+=speed;
		super.update();
	}
}
