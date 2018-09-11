package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SlowDownPowerUp extends GameEntity implements Interactable {

    public SlowDownPowerUp(Pane pane) {
        super(pane);
        setImage(Globals.powerupPillBox);
        pane.getChildren().add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        if (!snakeHead.isSnakeTooSlow()) {
            snakeHead.changeSpeed(-0.33f);
            snakeHead.addPart(1);
        }
        System.out.println("speed is:" + snakeHead.getSpeed());
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got slow down power-up :)";
    }
}
