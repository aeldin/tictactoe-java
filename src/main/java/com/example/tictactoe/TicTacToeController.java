package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToeController {

    @FXML
    public Label activePlayer;
    @FXML
    public Button nextGameButton;
    @FXML
    public Button resetButton;
    @FXML
    public Label outcomeLabel;


    private Model model = new Model();

    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;

    private int currentPlayer;


    public Model getModel() {
        return model;
    }

    public void initialize() {
        activePlayer.setText(String.valueOf(currentPlayer));

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
                String winner = (model.getBoard()[i][0] == model.imageX) ? "Player X" : "Player O";
                updateScoreAndDisplayMessage(winner);
                return;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (model.getBoard()[0][j] == model.getBoard()[1][j] && model.getBoard()[1][j] == model.getBoard()[2][j] && model.getBoard()[0][j] != model.imageBlank) {
                String winner = (model.getBoard()[0][j] == model.imageX) ? "Player X" : "Player O";
                updateScoreAndDisplayMessage(winner);
                return;
            }
        }

        // Check diagonals
        if (model.getBoard()[0][0] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][2] && model.getBoard()[0][0] != model.imageBlank) {
            String winner = (model.getBoard()[0][0] == model.imageX) ? "Player X" : "Player O";
            updateScoreAndDisplayMessage(winner);
            return;
        }

        if (model.getBoard()[0][2] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][0] && model.getBoard()[0][2] != model.imageBlank) {
            String winner = (model.getBoard()[0][2] == model.imageX) ? "Player X" : "Player O";
            updateScoreAndDisplayMessage(winner);
        }

        checkForDraw();

    }

    private void updateScoreAndDisplayMessage(String winner) {
        // Update the score based on the winner
        if (winner.equals("Player X")) {
            int playerScore = Integer.parseInt(model.getPlayerScore().split(" ")[2]);
            playerScore++;
            model.setPlayerScore("X = " + playerScore + " poäng");
        } else {
            int computerScore = Integer.parseInt(model.getComputerScore().split(" ")[2]);
            computerScore++;
            model.setComputerScore("O = " + computerScore + " poäng");
        }

        // Display the win message
        displayWinMessage(winner);
    }

    private void displayWinMessage(String winner) {
        outcomeLabel.setText(winner + " wins!");


    }

    public void checkForDraw() {
        Image[][] board = model.getBoard();
        boolean isDraw = true;

        // Check if all cells are filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == model.imageBlank) {
                    isDraw = false;
                    break;
                }
            }
        }

        if (isDraw) {
            outcomeLabel.setText("It's a draw!");

        }
    }

    @FXML
    public void resetButtonClicked() {
        // Reset scores
        model.setPlayerScore("X = 0 poäng");
        model.setComputerScore("O = 0 poäng");

        clearBoardState();

        currentPlayer = new Random().nextInt(2) == 0 ? PLAYER_ONE : PLAYER_TWO;
        activePlayer.setText(String.valueOf(currentPlayer));
    }

    @FXML
    public void nextButtonClicked(){
        clearBoardState();
        currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
        activePlayer.setText(String.valueOf(currentPlayer));
    }

    private void clearBoardState() {
        outcomeLabel.setText("");
        model.setFirst(model.getImageBlank());
        model.setSecond(model.getImageBlank());
        model.setThird(model.getImageBlank());
        model.setFourth(model.getImageBlank());
        model.setFifth(model.getImageBlank());
        model.setSixth(model.getImageBlank());
        model.setSeventh(model.getImageBlank());
        model.setEighth(model.getImageBlank());
        model.setNinth(model.getImageBlank());

        // Reset the board array
        model.setBoard(new Image[][]{
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()},
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()},
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()}
        });
    }




}

