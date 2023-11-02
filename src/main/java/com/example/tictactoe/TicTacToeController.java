package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class TicTacToeController {

    public Label welcomeText;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    ArrayList<Button> buttons;
    public Label xCounter;
    public Label yCounter;

    private int playerTurn = 0;



    private Model model = new Model();

    public Model getModel(){
        return model;

    }
    public void initialize(){
        welcomeText.textProperty().bind(model.messageProperty());


    }

    @FXML
    protected void onHelloButtonAction() {

        model.setMessage("Welcome to Tic-Tac-Toe!");
    }


    public void onLabelClicked(MouseEvent mouseEvent) {

    }

}