import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller implements KeyListener, ActionListener {
	Model model;
	View view;
	
	public Controller(View v) {
		model = new Model();
		view = v;
	}
	public Player getPlayer(){
		return model.getPlayer();
	}
	public obstacle getObstacle(int index) {
		return model.getObstacle(index);
	}
	public enemy getEnemy(int index) {
		return model.getEnemy(index);
	}
	public int getEnemyCount() {
		return model.getEnemyCount();
	}
	public int getObstacleCount() {
		return model.getObstacleCount();
	}
	public int getPlayerX() {
		return model.getPlayer().x;
	}
	
	public int getPlayerY() {
		return model.playerY;
	}
	
	public void move() {
		model.getPlayer().move();
		model.moveEnemies();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			model.getPlayer().keyPressed("down");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			model.getPlayer().keyPressed("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			model.getPlayer().keyPressed("left");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			model.getPlayer().keyPressed("right");
		}
		view.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			model.getPlayer().keyReleased("down");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			model.getPlayer().keyReleased("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			model.getPlayer().keyReleased("left");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			model.getPlayer().keyReleased("right");
		}
		view.repaint();


	}

	@Override
	public void keyTyped(KeyEvent e) {


	}
	public int getEnemyX(int index) {
		return model.getEnemyX(index);
	}
	public int getEnemyY(int index) {
		return model.getEnemyY(index);
	}


}
