package com.codecool.snake.displayitems;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Hud extends FlowPane {
  private HBox hbox = new HBox();
  private Label healthBar;
  private Label scoreBar;

  public Hud() {
    this.getChildren().add(hbox);
    addHealthBar();
    addScoreBar();
  }

  public void health(int health) {
    healthBar.setText("HEALTH: " + String.valueOf(health));
    healthBar.setFont(Font.font("Trebuchet MS", 20));
    healthBar.setTextFill(Color.RED);
  }

  public void score(int score) {
    scoreBar.setText("  || Score: " + String.valueOf(score));
    scoreBar.setFont(Font.font("Trebuchet MS", 20));
    scoreBar.setTextFill(Color.DARKBLUE);
  }

  private void addHealthBar() {
    healthBar = new Label();
    hbox.getChildren().add(healthBar);
  }

  private void addScoreBar() {
    scoreBar = new Label();
    hbox.getChildren().add(scoreBar);
  }
}
