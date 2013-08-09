import java.awt.Graphics;


public class obstacle {
	int x, y;
	int width, height;

	public obstacle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void paint(Graphics g) {
		g.fillRect(x,  y,  width, height);
}
} 
