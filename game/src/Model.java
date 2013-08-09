import java.util.ArrayList;


public class Model {
	int playerX = 250, playerY = 250;
	int playerXV, playerYV;
	int level = 1;
	
	Player player;
	ArrayList <enemy> enemies;
	ArrayList <obstacle> obstacles;
	
	public Model() {
		player = new Player(250, 250);
		enemies = new ArrayList <enemy> ();
		obstacles = new ArrayList <obstacle> ();
		
		enemies = new ArrayList <enemy> ();
		enemies.add(new enemy(100, 50));
		enemies.add(new enemy(400, 250));
		enemies.add(new enemy(450, 100));
		
		obstacles.add(new obstacle(0, 0, 100, 100));
		obstacles.add(new obstacle(0, 200, 50, 300));
	}
	public Player getPlayer() {
		return player;
	}
	public enemy getEnemy(int index) {
		return enemies.get(index);
	}
	public obstacle getObstacle(int index) {
		return obstacles.get(index);
	}

	public int getEnemyCount() {
		return enemies.size();
	}
	
	public int getObstacleCount() {
		return obstacles.size();
	}
	
	public int getEnemyX(int index) {
		return enemies.get(index).x;
	}
	public int getEnemyY(int index) {
		return enemies.get(index).y;
	}
	public void setPosition(int x, int y) {
		playerX = x;
		playerY = y;
	}

	public void movePlayer() {
		playerX = playerX + playerXV;
		if (playerX > 490) {
			playerX = 490;
		}
		if (playerX < 10) {
			playerX = 10;
		}
		playerY = playerY + playerYV;
		if (playerY > 490) {
			playerY = 490;
		}
		if (playerY < 10) {
			playerY = 10;
		}
		
	}

	public void moveEnemies() {
		for (int i = 0 ; i < enemies.size() ; i++) {
			
		}
		
	}
} 
