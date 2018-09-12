package com.codecool.snake;

import com.codecool.snake.displayitems.Hud;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Server.primaryStage = primaryStage;
        Game game = new Game();
        MenuBar.addMenu(game, primaryStage);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();
        game.start();
    }

    public void startMulti(Stage primaryStage){
        Game game = new Game();
        MenuBar.addMenu(game, primaryStage);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();

    }
}
