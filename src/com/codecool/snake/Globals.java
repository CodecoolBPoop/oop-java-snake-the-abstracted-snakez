package com.codecool.snake;

import com.codecool.snake.displayitems.Hud;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.displayitems.GamoverPopup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1200;
    public static final double WINDOW_HEIGHT = 700;


    public static double SNAKE_HEAD_X = 500;
    public static double SNAKE_HEAD_Y = 500;
    public static Pane PANE;
    public static boolean IS_CONFUCIA_HERE;



    public static final double SPAWN_DISTANCE_FROM_HERO = 50;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image simpleEnemy = new Image("bird_enemy.png");
    public static Image confucia  = new Image("confucia2.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image powerupHeart = new Image("powerup_heart.png");
    public static Image powerupInjection = new Image("powerup_injection.png");
    public static Image powerupPillBox = new Image("powerup_pillbox.png");
    public static Image sorImage = new Image("mouth.png");

    public static Image backgroundImage = new Image("background1.jpg");
    public static Image scoreBackground = new Image("score_bg.jpg");

    //Snake Sprites
    public static Image snakeHead1 = new Image("snake_head1.png");
    public static Image snakeHead2 = new Image("snake_head2.png");
    public static Image snakeHead3 = new Image("snake_head3.png");
    public static Image snakeHead4 = new Image("snake_head4.png");
    public static Image snakeHead5 = new Image("snake_head5.png");
    public static Image snakeHead6 = new Image("snake_head6.png");
    public static Image snakeBody1 = new Image("snake_body1.png");
    public static Image snakeBody2 = new Image("snake_body2.png");
    public static Image snakeBody3 = new Image("snake_body3.png");
    public static Image snakeBody4 = new Image("snake_body4.png");
    public static Image snakeBody5 = new Image("snake_body5.png");
    public static Image snakeBody6 = new Image("snake_body6.png");
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
