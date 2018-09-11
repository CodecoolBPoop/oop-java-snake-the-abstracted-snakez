package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HeartPowerUp extends GameEntity implements Interactable {

    public HeartPowerUp(Pane pane) {
        super(pane);
        setImage(Globals.powerupHeart);
        pane.getChildren().add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        if (!snakeHead.reachedMaxHealth()) {
            snakeHead.changeHealth(10);
        }
        System.out.println("health is:" + snakeHead.getHealth());
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got heart power-up :)";
    }
}
