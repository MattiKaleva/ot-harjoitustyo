package enemies;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class BasicEnemy {
    private Shape character;
    private int coordX;
    private int coordY;

    public BasicEnemy() {
        this.character = new Circle(300, 200, 5);
        this.coordX = 300;
        this.coordY = 200;
    }

    public Shape getEnemy() {
        return this.character;
    }

    public int getX() {return this.coordX;}
    public int getY() {return this.coordY;}
}
