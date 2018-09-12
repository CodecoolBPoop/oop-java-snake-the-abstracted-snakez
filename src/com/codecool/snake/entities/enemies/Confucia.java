package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;

public class Confucia extends GameEntity {

    public Confucia(Pane pane) {
        super(pane);

        setImage(Globals.confucia);
        pane.getChildren().add(this);
        setX(800);
        setY(400);
        Globals.IS_CONFUCIA_HERE = true;
    }

    @Override
    public void destroy() {
        Globals.IS_CONFUCIA_HERE = false;
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }
}

