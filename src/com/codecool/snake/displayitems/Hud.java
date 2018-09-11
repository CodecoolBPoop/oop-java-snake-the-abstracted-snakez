package com.codecool.snake.displayitems;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.R;

public class Hud extends Application {
  private Label healthBar;

  private HBox hbox = new HBox();

  Hud() {
    //hbox.getStyleClass().add("hbox");
    this.getChildren().add(hbox);
    addHealthBar();

  }

  public void health(int health) {
    healthBar.setText(String.valueOf(health));
  }

  //public void score(double score) { scoreBar.setText(String.valueOf((int) score));  }


  private void addHealthBar() {
    healthBar = new Label();
    //healthBar.getStyleClass().add("bar");
    //healthBar.getStyleClass().add("health");
    hbox.getChildren().add(healthBar);
  }



}
