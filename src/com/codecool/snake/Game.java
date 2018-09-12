package com.codecool.snake;

import com.codecool.snake.displayitems.Hud;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.HeartPowerUp;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.powerups.SlowDownPowerUp;
import com.codecool.snake.entities.powerups.SpeedPowerUp;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.objects.Global;

public class Game extends Pane{

    public Game() {
        new SnakeHead(this, 500, 500);

        new SimpleEnemy(this, Globals.SNAKE_HEAD_X, Globals.SNAKE_HEAD_Y);
        new SimpleEnemy(this, Globals.SNAKE_HEAD_X, Globals.SNAKE_HEAD_Y);
        new SimpleEnemy(this, Globals.SNAKE_HEAD_X, Globals.SNAKE_HEAD_Y);
        new SimpleEnemy(this, Globals.SNAKE_HEAD_X, Globals.SNAKE_HEAD_Y);

        new SimplePowerUp(this);
        new SimplePowerUp(this);
        new SimplePowerUp(this);
        new SimplePowerUp(this);
      
        new HeartPowerUp(this);
        new SlowDownPowerUp(this);
        new SpeedPowerUp(this);
        getChildren().add(Globals.myHud);
        getChildren().add(Globals.enemyHud);
        Globals.enemyHud.setAlignment(Pos.CENTER_RIGHT);
    }



    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.gameLoop = new GameLoop(this);
        Globals.gameLoop.start();
    }
}
