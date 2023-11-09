package com.example.tictactoe;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Model {

    public Image imageX;
    public Image imageO;
    public Image imageBlank;


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
        this.board = new Image[][] {
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
}


