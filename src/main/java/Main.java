import enemies.BasicEnemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import scenes.*;
import towers.BasicTower;
import towers.BasicTowerShot;

import java.util.ArrayList;

public class Main extends Application {

    Stage window;
    Button button;
    ArrayList<BasicEnemy> enemies;
    ArrayList<BasicTowerShot> shots;
    Pane panel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        enemies = new ArrayList<>();
        shots = new ArrayList<>();
        panel = new Pane();
        panel.setPrefSize(600, 800);
        BasicTower tower = new BasicTower();
        createEnemy();
        panel.getChildren().add(tower.getTower());
        Scene scene = new Scene(panel);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Awesome TD");
        primaryStage.show();


        new AnimationTimer() {
            @Override
            public void handle(long now) {
//                for(BasicEnemy enemy : enemies) {
//                    // Check for closest enemy
//                }
                BasicTowerShot shot = tower.shoot(enemies.get(0));
                if (shot != null){
                    shots.add(shot);
                    panel.getChildren().add(shot.getShotModel());
                }
                ArrayList<BasicTowerShot> hitted = new ArrayList<>();
                shots.forEach(projectile -> {
                    projectile.flyTowardsEnemy();
                    if(projectile.collision(enemies.get(0))) {
                        hitted.add(projectile);
                        panel.getChildren().remove(projectile.getShotModel());
                    }
                });
                hitted.forEach(projetcile -> {
                    shots.remove(projetcile);
                });

            }
        }.start();

    }

    public void createEnemy() {
        BasicEnemy enemy = new BasicEnemy();
        enemies.add(enemy);
        panel.getChildren().add(enemy.getEnemy());
    }
}
