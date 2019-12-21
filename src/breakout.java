import javax.swing.JFrame;

public class breakout {
	GamePanel gamepanel = new GamePanel();
	JFrame frame = new JFrame();
	final static int WIDTH= 500;
	final static int HEIGHT= 800;
public static void main(String[] args) {
	breakout breakouter = new breakout();
	breakouter.setup();
}

breakout(){
}
void setup() {
	frame.addKeyListener(gamepanel);
	frame.add(gamepanel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}

private void setDefaultCloseOperation(int exitOnClose) {
	// TODO Auto-generated method stub
	
}

}
