package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class TicTacToeController {


    @FXML
    public Button nextGameButton;
    @FXML
    public Button resetButton;
    @FXML
    public Label outcomeLabel;


    Model model = new Model();

    private static boolean weHaveAWinner;


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
            model.updateBoardState(imageView.getId(), model.imageX);
            model.legalMoves.remove(imageView.getId());


            weHaveAWinner = model.didSomebodyWin(this) != null;
            boolean isItADraw = isItADraw();
            if (!weHaveAWinner && !isItADraw) {
                computerPlayer();
                weHaveAWinner = model.didSomebodyWin(this) != null;
                isItADraw();
            }
        }
    }

    void updateScoreAndDisplayMessage(String winner) {
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
        boolean isDraw = model.isDraw();

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
        weHaveAWinner = false;
        outcomeLabel.setText("");
        model.clear();
        Random random = new Random();
        boolean computerBegins = random.nextBoolean();
        if (computerBegins) {
            computerPlayer();
        }
    }

    private void computerPlayer() {
        Random random = new Random();
        int i = random.nextInt(model.legalMoves.size());
        model.updateBoardState(model.legalMoves.get(i), model.imageO);
        model.legalMoves.remove(i);
    }

}

