package com.codecool.snake.displayitems;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.R;

public class Hud extends FlowPane {
  private Label healthBar;
  private Label scoreBar;
  private HBox hbox = new HBox();

  Hud() {
    hbox.getStyleClass().add("hbox");
    this.getChildren().add(hbox);
    addHealthBar();
    addScoreBar();
  }

  public void health(int health) {
    healthBar.setText(String.valueOf(health));
  }

  public void score(double score) {
    scoreBar.setText(String.valueOf((int) score));
  }


  private void addHealthBar() {
    healthBar = new Label();
    //healthBar.getStyleClass().add("bar");
    //healthBar.getStyleClass().add("health");
    hbox.getChildren().add(healthBar);
  }

  private void addScoreBar() {
    scoreBar = new Label();
    //scoreBar.getStyleClass().add("bar");
    //scoreBar.getStyleClass().add("score");
    hbox.getChildren().add(scoreBar);
  }

}
