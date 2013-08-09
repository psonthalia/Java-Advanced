import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class View extends JPanel {
	Controller control;
	
	public View() {
		control = new Controller(this);
		addKeyListener(control);
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				control.move();
				repaint();
				
			}
			
		}, 0, 50);
		
	}
	
	public void paintComponent(Graphics g) {
		paintBackground(g);
		//paintPlayer(g);
		control.getPlayer().paint(g);
		for (int x = 0; x < control.getEnemyCount(); x++) {
			//paintEnemy(g, control.getEnemyX(x), control.getEnemyY(x));
			control.getEnemy(x).paint(g);
		}
	}
	public void paintBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.black);
		for (int x = 0 ;  x < control.getObstacleCount() ; x++) {
			control.getObstacle(x).paint(g);
		}
	}
	public void paintPlayer(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(control.getPlayerX() - 10, control.getPlayerY() - 10, 20, 20);
	}
	public void paintEnemy(Graphics g, int x, int y) {
		g.setColor(Color.blue);
		g.fillOval(x - 8, x - 8, 10, 10);
	}
	
	public Dimension getSize() {
		return new Dimension(500, 522);
	}
	
}