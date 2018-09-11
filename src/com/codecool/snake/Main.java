package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        MenuBar.addMenu(game, primaryStage);

        primaryStage.setTitle("Snake Game");
        primaryStage.show();
        game.start();

    }

}
