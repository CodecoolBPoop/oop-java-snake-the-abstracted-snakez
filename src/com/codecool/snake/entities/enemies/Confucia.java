package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Confucia extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int damage = 10;

    public Confucia(Pane pane, double snakeX, double snakeY) {
        super(pane);

        setImage(Globals.confucia);
        pane.getChildren().add(this);
        Random rnd = new Random();
        setX(possiblePlace(snakeX, rnd, Globals.WINDOW_WIDTH));
        setY(possiblePlace(snakeY, rnd, Globals.WINDOW_HEIGHT));

;
    }

    private double possiblePlace(double snakeCoord, Random rnd, double windowDimension) {
        boolean isCoordOk = false;
        double randomDouble = snakeCoord;
        while (!isCoordOk) {
            randomDouble = rnd.nextDouble() * windowDimension;
            if (randomDouble < snakeCoord+Globals.SPAWN_DISTANCE_FROM_HERO &&
                    randomDouble > snakeCoord-Globals.SPAWN_DISTANCE_FROM_HERO) {
                continue;
            }
            isCoordOk = true;
        }
        return randomDouble;
    }


    @Override
    public void step() { }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        //destroy();
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }

    @Override
    public void destroy() {
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }
}

