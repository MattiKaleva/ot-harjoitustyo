package towers;

import enemies.BasicEnemy;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class BasicTower {
    private Polygon character;
    private int cooldown = 0;

    public BasicTower() {
        this.character = new Polygon(10, -10, 10, 10, -10, 10, -10, -10);
        this.character.setTranslateX(300);
        this.character.setTranslateY(400);
    }

    public Polygon getTower(){return character;}

    public BasicTowerShot shoot(BasicEnemy enemy) {
        if(cooldown>0) {
            cooldown -= 1;
            return null;
        }
        BasicTowerShot shot = new BasicTowerShot(enemy, (int)this.character.getTranslateX(), (int)this.character.getTranslateY());
        cooldown = 50;
        return shot;
    }


}
