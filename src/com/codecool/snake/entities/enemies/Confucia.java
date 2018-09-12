package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import javafx.scene.layout.Pane;

public class Confucia extends GameEntity implements Animatable {


    public Confucia(Pane pane) {
        super(pane);

        setImage(Globals.confucia);
        pane.getChildren().add(this);
        setX(950);
        setY(450);
        Globals.IS_CONFUCIA_HERE = true;

    }

    @Override
    public void step() {}


    @Override
    public void destroy() {
        Globals.IS_CONFUCIA_HERE = false;
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }
}

