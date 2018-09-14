package com.codecool.snake.displayitems;

import com.codecool.snake.Globals;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Hud extends FlowPane {
  private VBox vbox = new VBox();
  private Label healthBar;
  private Label scoreBar;
  private String identifier;
  BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
  Background background = new Background(new BackgroundImage(Globals.scoreBackground,
          BackgroundRepeat.ROUND,
          BackgroundRepeat.ROUND,
          BackgroundPosition.CENTER, bSize));

  public Hud(String identifier) {
    this.identifier = identifier;
    vbox.setBackground(background);
    this.getChildren().add(vbox);
    addHealthBar();
    addScoreBar();
  }

  public void health(int health) {
    healthBar.setText("  " + identifier + " HEALTH: " + String.valueOf(health));
    healthBar.setFont(Font.font("Trebuchet MS", 15));
    healthBar.setTextFill(Color.RED);
  }

  public void score(int score) {
    scoreBar.setText("  " + identifier +" SCORE: " + String.valueOf(score));
    scoreBar.setFont(Font.font("Trebuchet MS", 15));
    scoreBar.setTextFill(Color.DARKBLUE);
  }

  private void addHealthBar() {
    healthBar = new Label();
    vbox.setPadding(new Insets(0, 20, 0, 0));
    vbox.setSpacing(10);
    vbox.getChildren().add(healthBar);
  }

  private void addScoreBar() {
    scoreBar = new Label();
    vbox.getChildren().add(scoreBar);
  }

}
