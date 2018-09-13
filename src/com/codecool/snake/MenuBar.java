package com.codecool.snake;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuBar {

    private static final double WINDOW_WIDTH = Globals.WINDOW_WIDTH;
    private static final double WINDOW_HEIGHT = Globals.WINDOW_HEIGHT;
    public static Server server;


    public static void addMenu(Game game, Stage primaryStage) {
        BorderPane root = new BorderPane(game);
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        Background background = new Background(new BackgroundImage(Globals.backgroundImage,
                BackgroundRepeat.ROUND,
                BackgroundRepeat.ROUND,
                BackgroundPosition.CENTER,
                bSize));
        root.setBackground(background);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.setRoot(root);
        javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("Multiplayer");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(ActionEvent -> Platform.exit());
        newMenuItem.setOnAction(e ->
        {
            primaryStage.close();
            Globals.gameLoop.stop();
            Globals.oldGameObjects.clear();
            Globals.newGameObjects.clear();
            Globals.gameObjects.clear();
            Globals.setScore(0);
            server = new Server();
            server.startServer();

        });

        fileMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(), exitMenuItem);

        menuBar.getMenus().addAll(fileMenu);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
