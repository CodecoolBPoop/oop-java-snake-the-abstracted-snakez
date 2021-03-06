package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.enemies.Confucia;
import com.codecool.snake.entities.powerups.HeartPowerUp;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.powerups.SlowDownPowerUp;
import com.codecool.snake.entities.powerups.SpeedPowerUp;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GameLoop extends AnimationTimer {

    public Confucia confucia;
    long framecounter = 0;
    private Pane game;
    Random rand = new Random();
    int berrySpawnRate = rand.nextInt(601) + 300;
    int heartSpawnRate = rand.nextInt(601) + 300;
    int speedSpawnRate = rand.nextInt(901) + 300;
    int slowDownSpawnRate = rand.nextInt(901) + 600;

    GameLoop(Pane pane) {
        super();
        game = pane;
    }

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        framecounter += 1;
        if (framecounter % berrySpawnRate == 0) {
            new SimplePowerUp(game);
        }
        if (framecounter % heartSpawnRate == 0) {
            new HeartPowerUp(game);
        }
        if (framecounter % speedSpawnRate == 0) {
            new SpeedPowerUp(game);
        }
        if (framecounter % slowDownSpawnRate == 0) {
            new SlowDownPowerUp(game);
        }

        if (rand.nextInt(1000) == 500 && !Globals.IS_CONFUCIA_HERE) {
            confucia = new Confucia(Globals.PANE);
        }
        if (Globals.IS_CONFUCIA_HERE){
            if (rand.nextInt(500) == 250) {
                confucia.destroy();
            }

        }

        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable) gameObject;
                animObject.step();
            }
        }
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();
        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();
        if (MenuBar.server != null) {
            Globals.enemyHud.health(MenuBar.server.getEnemyHealth());
            //Globals.enemyHud.score(MenuBar.server.getEnemyScore());
        }
    }
}
