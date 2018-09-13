package com.codecool.snake.displayitems;

import com.codecool.snake.Globals;
import com.codecool.snake.Main;
import com.codecool.snake.Server;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;



public class GamoverPopup {
  public static Stage primaryStage;

  public void gameOverWindow(String string) {
    VBox popUp = new VBox();
    popUp.setAlignment(Pos.CENTER);
    popUp.getChildren().add(new Label(string));
    popUp.getChildren().add(new Label("Your score: " + Globals.score));

    Button exitGame = new Button("Exit Game");

    exitGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        Platform.exit();
      }
    });


    popUp.getChildren().addAll(exitGame);
    Scene modalScene = new Scene(popUp, 300, 200);

    Stage modalWindow = new Stage();
    modalWindow.setScene(modalScene);
    modalWindow.setTitle("Game Over!");
    modalWindow.initModality(Modality.WINDOW_MODAL);
    modalWindow.initOwner(Globals.primaryStage);
    modalWindow.show();

  }

}
