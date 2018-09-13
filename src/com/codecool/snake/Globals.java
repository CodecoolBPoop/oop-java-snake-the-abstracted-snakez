package com.codecool.snake;

import com.codecool.snake.displayitems.Hud;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.displayitems.GamoverPopup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1600 ;
    public static final double WINDOW_HEIGHT = 1100;


    public static double SNAKE_HEAD_X = 500;
    public static double SNAKE_HEAD_Y = 500;
    public static Pane PANE;
    public static boolean IS_CONFUCIA_HERE;



    public static final double SPAWN_DISTANCE_FROM_HERO = 50;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image confucia  = new Image("confucia2.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image powerupHeart = new Image("powerup_heart.png");
    public static Image powerupInjection = new Image("powerup_injection.png");
    public static Image powerupPillBox = new Image("powerup_pillbox.png");
    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;

    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;
    public static GamoverPopup popup = new GamoverPopup();
    public static Hud myHud = new Hud("YOUR");
    public static Hud enemyHud = new Hud("ENEMIES");
    public static int score = 0; //moc should be returned with a method
    public static Stage primaryStage;


    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

    public static int getScore(){
        return score;
    }
}
