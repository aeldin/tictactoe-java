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
                case "topLeft" -> {
                    model.setFirst(image);
                    model.getBoard()[0][0] = image;
                }
                case "topCenter" -> {
                    model.setSecond(image);
                    model.getBoard()[0][1] = image;
                }
                case "topRight" -> {
                    model.setThird(image);
                    model.getBoard()[0][2] = image;
                }
                case "midLeft" -> {
                    model.setFourth(image);
                    model.getBoard()[1][0] = image;
                }
                case "midCenter" -> {
                    model.setFifth(image);
                    model.getBoard()[1][1] = image;
                }
                case "midRight" -> {
                    model.setSixth(image);
                    model.getBoard()[1][2] = image;
                }
                case "bottomLeft" -> {
                    model.setSeventh(image);
                    model.getBoard()[2][0] = image;
                }
                case "bottomCenter" -> {
                    model.setEighth(image);
                    model.getBoard()[2][1] = image;
                }
                case "bottomRight" -> {
                    model.setNinth(image);
                    model.getBoard()[2][2] = image;
                }
                default -> {
                    return;
                }
            }
            activePlayer.setText(String.valueOf(currentPlayer == PLAYER_ONE ? PLAYER_TWO : PLAYER_ONE));
            checkForWin();
        }
    }

    public void checkForWin() {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (model.getBoard()[i][0] == model.getBoard()[i][1] && model.getBoard()[i][1] == model.getBoard()[i][2] && model.getBoard()[i][0] != model.imageBlank) {
                // Player X or O has won, update score and display a message
                if (model.getBoard()[i][0] == model.imageX) {
                    int playerScore = Integer.parseInt(model.getPlayerScore().split(" ")[2]);
                    playerScore++;
                    model.setPlayerScore("X = " + playerScore + " poäng");
                } else {
                    int computerScore = Integer.parseInt(model.getComputerScore().split(" ")[2]);
                    computerScore++;
                    model.setComputerScore("O = " + computerScore + " poäng");
                }
                displayWinMessage(model.getBoard()[i][0]);
                return;
            }
        }

// Check columns
        for (int j = 0; j < 3; j++) {
            if (model.getBoard()[0][j] == model.getBoard()[1][j] && model.getBoard()[1][j] == model.getBoard()[2][j] && model.getBoard()[0][j] != model.imageBlank) {
                // Player X or O has won, update score and display a message
                if (model.getBoard()[0][j] == model.imageX) {
                    int playerScore = Integer.parseInt(model.getPlayerScore().split(" ")[2]);
                    playerScore++;
                    model.setPlayerScore("X = " + playerScore + " poäng");
                } else {
                    int computerScore = Integer.parseInt(model.getComputerScore().split(" ")[2]);
                    computerScore++;
                    model.setComputerScore("O = " + computerScore + " poäng");
                }
                displayWinMessage(model.getBoard()[0][j]);
                return;
            }
        }

// Check diagonals
        if (model.getBoard()[0][0] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][2] && model.getBoard()[0][0] != model.imageBlank) {
            // Player X or O has won, update score and display a message
            if (model.getBoard()[0][0] == model.imageX) {
                int playerScore = Integer.parseInt(model.getPlayerScore().split(" ")[2]);
                playerScore++;
                model.setPlayerScore("X = " + playerScore + " poäng");
            } else {
                int computerScore = Integer.parseInt(model.getComputerScore().split(" ")[2]);
                computerScore++;
                model.setComputerScore("O = " + computerScore + " poäng");
            }
            displayWinMessage(model.getBoard()[0][0]);
            return;
        }

        if (model.getBoard()[0][2] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][0] && model.getBoard()[0][2] != model.imageBlank) {
            // Player X or O has won, update score and display a message
            if (model.getBoard()[0][2] == model.imageX) {
                int playerScore = Integer.parseInt(model.getPlayerScore().split(" ")[2]);
                playerScore++;
                model.setPlayerScore("X = " + playerScore + " poäng");
            } else {
                int computerScore = Integer.parseInt(model.getComputerScore().split(" ")[2]);
                computerScore++;
                model.setComputerScore("O = " + computerScore + " poäng");
            }
            displayWinMessage(model.getBoard()[0][2]);
        }

    }
    private void displayWinMessage(Image winnerImage) {
        // Display a message indicating the winner (X or O)
        if (winnerImage == model.imageX) {
            activePlayer.setText("Player X wins!");
        } else {
            activePlayer.setText("Player O wins!");
        }
        // You can also disable further moves or take other actions here.
    }

}

