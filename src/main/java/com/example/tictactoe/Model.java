package com.example.tictactoe;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public Image imageX;
    public Image imageO;
    public Image imageBlank;

    public List<String> legalMoves;


    private ObjectProperty<Image> first;
    private ObjectProperty<Image> second;
    private ObjectProperty<Image> third;
    private ObjectProperty<Image> fourth;
    private ObjectProperty<Image> fifth;
    private ObjectProperty<Image> sixth;
    private ObjectProperty<Image> seventh;
    private ObjectProperty<Image> eighth;
    private ObjectProperty<Image> ninth;


    private StringProperty playerScoreBoard = new SimpleStringProperty("X = 0 poäng");

    private StringProperty computerScoreBoard = new SimpleStringProperty("O = 0 poäng");

    private int playerScore;
    private int computerScore;


    public Image[][] board;

    public Model(Image imageX, Image imageO, Image imageBlank)
    {
        this.imageX = imageX;
        this.imageO = imageO;
        this.imageBlank = imageBlank;
        first = new SimpleObjectProperty<>(this.imageBlank);
        second = new SimpleObjectProperty<>(this.imageBlank);
        third = new SimpleObjectProperty<>(this.imageBlank);
        fourth = new SimpleObjectProperty<>(this.imageBlank);
        fifth = new SimpleObjectProperty<>(this.imageBlank);
        sixth = new SimpleObjectProperty<>(this.imageBlank);
        seventh = new SimpleObjectProperty<>(this.imageBlank);
        eighth = new SimpleObjectProperty<>(this.imageBlank);
        ninth = new SimpleObjectProperty<>(this.imageBlank);
        this.playerScore = 0;
        this.computerScore = 0;
        this.board = new Image[][]{
                {first.get(), second.get(), third.get()},
                {fourth.get(), fifth.get(), sixth.get()},
                {seventh.get(), eighth.get(), ninth.get()}
        };
    }

    public Model() {
        imageX = new Image(getClass().getResource("images/X.png").toExternalForm());
        imageO = new Image(getClass().getResource("images/O.png").toExternalForm());
        imageBlank = new Image(getClass().getResource("images/Blank.png").toExternalForm());
        first = new SimpleObjectProperty<>(imageBlank);
        second = new SimpleObjectProperty<>(imageBlank);
        third = new SimpleObjectProperty<>(imageBlank);
        fourth = new SimpleObjectProperty<>(imageBlank);
        fifth = new SimpleObjectProperty<>(imageBlank);
        sixth = new SimpleObjectProperty<>(imageBlank);
        seventh = new SimpleObjectProperty<>(imageBlank);
        eighth = new SimpleObjectProperty<>(imageBlank);
        ninth = new SimpleObjectProperty<>(imageBlank);
        this.playerScore = 0;
        this.computerScore = 0;
        this.board = new Image[][]{
                {first.get(), second.get(), third.get()},
                {fourth.get(), fifth.get(), sixth.get()},
                {seventh.get(), eighth.get(), ninth.get()}
        };
    }

    public Image getFirst() {
        return first.get();
    }

    public ObjectProperty<Image> firstProperty() {
        return first;
    }

    public void setFirst(Image first) {
        this.first.set(first);
    }

    public Image getSecond() {
        return second.get();
    }

    public ObjectProperty<Image> secondProperty() {
        return second;
    }

    public void setSecond(Image second) {
        this.second.set(second);
    }

    public Image getThird() {
        return third.get();
    }

    public ObjectProperty<Image> thirdProperty() {
        return third;
    }

    public void setThird(Image third) {
        this.third.set(third);
    }

    public Image getFourth() {
        return fourth.get();
    }

    public ObjectProperty<Image> fourthProperty() {
        return fourth;
    }

    public void setFourth(Image fourth) {
        this.fourth.set(fourth);
    }

    public Image getFifth() {
        return fifth.get();
    }

    public ObjectProperty<Image> fifthProperty() {
        return fifth;
    }

    public void setFifth(Image fifth) {
        this.fifth.set(fifth);
    }

    public Image getSixth() {
        return sixth.get();
    }

    public ObjectProperty<Image> sixthProperty() {
        return sixth;
    }

    public void setSixth(Image sixth) {
        this.sixth.set(sixth);
    }

    public Image getSeventh() {
        return seventh.get();
    }

    public ObjectProperty<Image> seventhProperty() {
        return seventh;
    }

    public void setSeventh(Image seventh) {
        this.seventh.set(seventh);
    }

    public Image getEighth() {
        return eighth.get();
    }

    public ObjectProperty<Image> eighthProperty() {
        return eighth;
    }

    public void setEighth(Image eighth) {
        this.eighth.set(eighth);
    }

    public Image getNinth() {
        return ninth.get();
    }

    public ObjectProperty<Image> ninthProperty() {
        return ninth;
    }

    public void setNinth(Image ninth) {
        this.ninth.set(ninth);
    }


    public String getPlayerScoreBoard() {
        return playerScoreBoard.get();
    }

    public StringProperty playerScoreBoardProperty() {
        return playerScoreBoard;
    }

    public void setPlayerScoreBoard(String score) {
        this.playerScoreBoard.set(score);
    }

    public String getComputerScoreBoard() {
        return computerScoreBoard.get();
    }

    public StringProperty computerScoreBoardProperty() {
        return computerScoreBoard;
    }

    public void setComputerScoreBoard(String score) {
        this.computerScoreBoard.set(score);
    }

    public Image[][] getBoard() {
        return board;
    }

    public void setBoard(Image[][] board) {
        this.board = board;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public Image getImageBlank() {
        return imageBlank;
    }

    public int incrementAndGetPlayerScore() {
        return ++playerScore;
    }

    public int incrementAndGetComputerScore() {
        return ++computerScore;
    }

    public Image getImageX() {
        return imageX;
    }

    public void setImageX(Image imageX) {
        this.imageX = imageX;
    }

    public Image getImageO() {
        return imageO;
    }

    public void setImageO(Image imageO) {
        this.imageO = imageO;
    }

    void clear() {
        legalMoves = new ArrayList<>(List.of("topLeft", "topCenter", "topRight",
                "midLeft", "midCenter", "midRight",
                "bottomLeft", "bottomCenter", "bottomRight"));

        setFirst(getImageBlank());
        setSecond(getImageBlank());
        setThird(getImageBlank());
        setFourth(getImageBlank());
        setFifth(getImageBlank());
        setSixth(getImageBlank());
        setSeventh(getImageBlank());
        setEighth(getImageBlank());
        setNinth(getImageBlank());

        setBoard(new Image[][]{
                {getImageBlank(), getImageBlank(), getImageBlank()},
                {getImageBlank(), getImageBlank(), getImageBlank()},
                {getImageBlank(), getImageBlank(), getImageBlank()}
        });
    }

    public boolean updateBoardState(String imageViewId, Image image) {
        if (legalMoves.contains(imageViewId)) {
            switch (imageViewId) {
                case "topLeft" -> {
                    setFirst(image);
                    getBoard()[0][0] = image;
                }
                case "topCenter" -> {
                    setSecond(image);
                    getBoard()[0][1] = image;
                }
                case "topRight" -> {
                    setThird(image);
                    getBoard()[0][2] = image;
                }
                case "midLeft" -> {
                    setFourth(image);
                    getBoard()[1][0] = image;
                }
                case "midCenter" -> {
                    setFifth(image);
                    getBoard()[1][1] = image;
                }
                case "midRight" -> {
                    setSixth(image);
                    getBoard()[1][2] = image;
                }
                case "bottomLeft" -> {
                    setSeventh(image);
                    getBoard()[2][0] = image;
                }
                case "bottomCenter" -> {
                    setEighth(image);
                    getBoard()[2][1] = image;
                }
                case "bottomRight" -> {
                    setNinth(image);
                    getBoard()[2][2] = image;
                }
                default -> {
                    return false;

                }
            }
            return true;
        }
        return false;
    }

    boolean isDraw() {
        Image[][] board = getBoard();
        boolean isDraw = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == imageBlank) {
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw;
    }

    public String checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (getBoard()[i][0] == getBoard()[i][1] && getBoard()[i][1] == getBoard()[i][2] && getBoard()[i][0] != imageBlank) {
                return (getBoard()[i][0] == imageX) ? "Player X" : "Player O";
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (getBoard()[0][j] == getBoard()[1][j] && getBoard()[1][j] == getBoard()[2][j] && getBoard()[0][j] != imageBlank) {
                return (getBoard()[0][j] == imageX) ? "Player X" : "Player O";
            }
        }

        // Check diagonals
        if (getBoard()[0][0] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][2] && getBoard()[0][0] != imageBlank) {
            return (getBoard()[0][0] == imageX) ? "Player X" : "Player O";
        }

        if (getBoard()[0][2] == getBoard()[1][1] && getBoard()[1][1] == getBoard()[2][0] && getBoard()[0][2] != imageBlank) {
            return (getBoard()[0][2] == imageX) ? "Player X" : "Player O";
        }

        return null;
    }

    public String didSomebodyWin(TicTacToeController ticTacToeController) {
        String winner = checkForWinner();
        if (winner != null) {
            ticTacToeController.updateScoreAndDisplayMessage(winner);
        }
        return winner;
    }
}


