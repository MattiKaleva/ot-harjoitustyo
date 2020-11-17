package towers;

import enemies.BasicEnemy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicTowerShotTest {
    @Test
    public void collisionDetectedCorrectly() {
        BasicEnemy enemy = new BasicEnemy();
        BasicTowerShot shot = new BasicTowerShot(enemy, enemy.getX(), enemy.getY());
        assertEquals(true, shot.collision(enemy));
    }
}
