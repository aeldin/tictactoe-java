package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeController {


    @FXML
    public Button nextGameButton;
    @FXML
    public Button resetButton;
    @FXML
    public Label outcomeLabel;


    private Model model = new Model();

    private static boolean weHaveAWinner;

    private List<String> legalMoves;


    public Model getModel() {
        return model;
    }

    public void initialize() {
        clearBoardState();
    }

    public void imageBlankClicked(MouseEvent mouseEvent) {
        if (!weHaveAWinner &&
                mouseEvent.getSource() instanceof ImageView imageView &&
                imageView.getImage() == model.imageBlank) {
            updateBoardState(imageView.getId(), model.imageX);
            legalMoves.remove(imageView.getId());


            weHaveAWinner = didSomebodyWin() != null;
            boolean isItADraw = isItADraw();
            if (!weHaveAWinner && isItADraw) {
                computerPlayer();
            }
        }
    }

    public String didSomebodyWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (model.getBoard()[i][0] == model.getBoard()[i][1] && model.getBoard()[i][1] == model.getBoard()[i][2] && model.getBoard()[i][0] != model.imageBlank) {
                String winner = (model.getBoard()[i][0] == model.imageX) ? "Player X" : "Player O";
                updateScoreAndDisplayMessage(winner);
                return winner;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (model.getBoard()[0][j] == model.getBoard()[1][j] && model.getBoard()[1][j] == model.getBoard()[2][j] && model.getBoard()[0][j] != model.imageBlank) {
                String winner = (model.getBoard()[0][j] == model.imageX) ? "Player X" : "Player O";
                updateScoreAndDisplayMessage(winner);
                return winner;
            }
        }

        // Check diagonals
        if (model.getBoard()[0][0] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][2] && model.getBoard()[0][0] != model.imageBlank) {
            String winner = (model.getBoard()[0][0] == model.imageX) ? "Player X" : "Player O";
            updateScoreAndDisplayMessage(winner);
            return winner;
        }

        if (model.getBoard()[0][2] == model.getBoard()[1][1] && model.getBoard()[1][1] == model.getBoard()[2][0] && model.getBoard()[0][2] != model.imageBlank) {
            String winner = (model.getBoard()[0][2] == model.imageX) ? "Player X" : "Player O";
            updateScoreAndDisplayMessage(winner);
            return winner;
        }

        return null;
    }

    private void updateScoreAndDisplayMessage(String winner) {
        if (winner.equals("Player X")) {
            int playerScore = model.incrementAndGetPlayerScore();
            model.setPlayerScoreBoard("X = " + playerScore + " poäng");
        } else {
            int computerScore = model.incrementAndGetComputerScore();
            model.setComputerScoreBoard("O = " + computerScore + " poäng");
        }
        displayWinMessage(winner);
    }

    private void displayWinMessage(String winner) {
        outcomeLabel.setText(winner + " wins!");


    }

    public boolean isItADraw() {
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
        return isDraw;
    }

    @FXML
    public void resetButtonClicked() {
        model.setPlayerScoreBoard("X = 0 poäng");
        model.setComputerScoreBoard("O = 0 poäng");
        model.setComputerScore(0);
        model.setPlayerScore(0);

        clearBoardState();

    }

    @FXML
    public void nextButtonClicked() {
        clearBoardState();

    }

    private void clearBoardState() {
        legalMoves = new ArrayList<>(List.of("topLeft", "topCenter", "topRight",
                "midLeft", "midCenter", "midRight",
                "bottomLeft", "bottomCenter", "bottomRight"));
        weHaveAWinner = false;
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

        model.setBoard(new Image[][]{
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()},
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()},
                {model.getImageBlank(), model.getImageBlank(), model.getImageBlank()}
        });
        Random random = new Random();
        boolean computerBegins = random.nextBoolean();
        if (computerBegins) {
            computerPlayer();
        }
    }

    public boolean updateBoardState(String imageViewId, Image image) {
        if (legalMoves.contains(imageViewId)) {
            switch (imageViewId) {
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
                    return false;

                }
            }
            return true;
        }
        return false;
    }

    private void computerPlayer() {
        Random random = new Random();
        int i = random.nextInt(legalMoves.size());
        updateBoardState(legalMoves.get(i), model.imageO);
        legalMoves.remove(i);
    }

}

