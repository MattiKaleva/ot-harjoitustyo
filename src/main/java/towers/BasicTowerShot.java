package towers;

import enemies.BasicEnemy;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class BasicTowerShot {
    private Shape shotModel;
    private BasicEnemy target;

    public BasicTowerShot(BasicEnemy enemy, int x, int y) {
        this.shotModel = new Polygon(2, -2, 2, 2, -2, 2, -2, -2);
        this.shotModel.setTranslateX(x);
        this.shotModel.setTranslateY(y);
        this.target = enemy;
    }

    public Shape getShotModel() { return this.shotModel; }

    public void flyTowardsEnemy() {
      //  this.shotModel.setTranslateX(this.shotModel.getTranslateX()+1);
        this.shotModel.setTranslateY(this.shotModel.getTranslateY()-1);

    }

    public boolean collision(BasicEnemy enemy) {
        Shape impact = Shape.intersect(this.shotModel, enemy.getEnemy());
        return impact.getBoundsInLocal().getWidth() != -1;
    }
}
