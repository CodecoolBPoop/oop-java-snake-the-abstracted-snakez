package com.codecool.snake.displayitems;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class Hud extends FlowPane {
  private HBox hbox = new HBox();
  private Label healthBar;

  public void addHud() {
    this.getChildren().add(hbox);
    addHealthBar();
  }

  private void addHealthBar() {
    healthBar = new Label();
    healthBar.setText("TEXT");
    hbox.getChildren().add(healthBar);
  }

}
