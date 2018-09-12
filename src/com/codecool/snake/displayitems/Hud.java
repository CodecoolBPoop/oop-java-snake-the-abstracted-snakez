package com.codecool.snake.displayitems;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

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
  }

  public void score(int score) {
    scoreBar.setText("  || Score: " + String.valueOf(score));
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
