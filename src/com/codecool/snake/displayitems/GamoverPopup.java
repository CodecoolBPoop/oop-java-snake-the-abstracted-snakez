package com.codecool.snake.displayitems;

import com.codecool.snake.Globals;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class GamoverPopup {

  public void gameOverWindow() {
    VBox modal = new VBox();
    modal.setAlignment(Pos.CENTER);
    modal.getChildren().add(new Label("Your score: "));
    Scene modalScene = new Scene(modal, 300, 200);

    Stage modalWindow = new Stage();
    modalWindow.setScene(modalScene);
    modalWindow.setTitle("Game Over!");
    modalWindow.initModality(Modality.WINDOW_MODAL);
    modalWindow.initOwner(Globals.primaryStage);
    modalWindow.show();
    //if (!modalWindow.isFocused()) modalWindow.requestFocus();
  }

}
