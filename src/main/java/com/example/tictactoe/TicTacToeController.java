package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.List;

public class TicTacToeController {

    @FXML
    public Label activePlayer;
    private Model model = new Model();

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;


    public Model getModel() {
        return model;
    }

    public void initialize() {
        activePlayer.setText(String.valueOf(PLAYER_ONE));

    }

    public void imageBlankClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView imageView &&
                imageView.getImage() == model.imageBlank) {
            int currentPlayer = Integer.parseInt(activePlayer.getText());
            Image image = currentPlayer == PLAYER_ONE ? model.imageX : model.imageO;
            switch (imageView.getId()) {
                case "topLeft" -> model.setFirst(image);
                case "topCenter" -> model.setSecond(image);
                case "topRight" -> model.setThird(image);
                case "midLeft" -> model.setFourth(image);
                case "midCenter" -> model.setFifth(image);
                case "midRight" -> model.setSixth(image);
                case "bottomLeft" -> model.setSeventh(image);
                case "bottomCenter" -> model.setEighth(image);
                case "bottomRight" -> model.setNinth(image);
                default -> {
                    return;
                }
            }
            activePlayer.setText(String.valueOf(currentPlayer == PLAYER_ONE ? PLAYER_TWO : PLAYER_ONE));
        }
    }



}

