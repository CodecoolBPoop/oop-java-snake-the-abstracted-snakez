package com.codecool.snake.entities.snakes;

import com.codecool.snake.MenuBar;
import com.codecool.snake.Server;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.objects.Global;

import java.io.DataOutputStream;
import java.io.IOException;

public class SnakeHead extends GameEntity implements Animatable {

    public static final boolean thisIsSnake = true;
    private static float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    private int health;
    private int maxHealth;
    private static boolean connected;
    public static DataOutputStream dos;

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);

        setX(xc);
        setY(yc);
        health = 100;
        maxHealth = 150;
        Globals.myHud.health(health);
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);

        addPart(4);
//      Globals.hud.score(Globals.score);
    }

    public void step() {
        double dir = getRotate();
        if (Globals.IS_CONFUCIA_HERE) {
            if (Globals.leftKeyDown) {
                dir = dir + turnRate;
            }
            if (Globals.rightKeyDown) {
                dir = dir - turnRate;
            }
        } else {

                if (Globals.leftKeyDown) {
                    dir = dir - turnRate;
                }
                if (Globals.rightKeyDown) {
                    dir = dir + turnRate;
                }
            }

        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        Globals.SNAKE_HEAD_X = getX();
        Globals.SNAKE_HEAD_Y = getY();
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    designSnake();
                    if (MenuBar.server != null) {
                        connected = MenuBar.server.getConnected();
                    }
                    if(connected){
                        MenuBar.server.sendHealth(this);
                        MenuBar.server.sendScore(this);
                    }
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || health <= 0) {
            System.out.println("Game Over");

            Globals.gameLoop.stop();

            Globals.popup.gameOverWindow();
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
        Globals.score += numParts;
        System.out.println(Globals.score);
        Globals.myHud.score(Globals.score);
    }

    public void changeHealth(int diff) {
        health += diff;
        System.out.println("Healt is " + health);;
        Globals.myHud.health(health);
    }

    public void changeSpeed(float diff) {
        speed += diff;
    }

    public static float getSpeed() {
        return speed;
    }

    public boolean isSnakeTooFast(){
        return speed >= 3.5f;
    }

    public boolean isSnakeTooSlow(){
        return speed <= 0.7f;
    }

    public boolean reachedMaxHealth(){
        return health >= maxHealth;
    }

    public int getHealth() {
        return health;
    }

    private void designSnake() {
        int score = Globals.getScore();
        if (score >= 12 & score < 20) {
            setImage(Globals.snakeHead1);
            Globals.snakeBody = Globals.snakeBody1;
        } else if (score >= 20 & score < 28) {
            setImage(Globals.snakeHead2);
            Globals.snakeBody = Globals.snakeBody2;
        } else if (score >= 28 & score < 36) {
            setImage(Globals.snakeHead3);
            Globals.snakeBody = Globals.snakeBody3;
        } else if (score >= 36 & score < 44) {
            setImage(Globals.snakeHead4);
            Globals.snakeBody = Globals.snakeBody4;
        } else if (score >= 44 & score < 52) {
            setImage(Globals.snakeHead5);
            Globals.snakeBody = Globals.snakeBody5;
        } else if (score >= 52) {
            setImage(Globals.snakeHead6);
            Globals.snakeBody = Globals.snakeBody6;
        }
    }

}
