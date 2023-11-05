package com.example.tictactoe;

import javafx.scene.input.MouseEvent;

public class TicTacToeController {

    private Model model = new Model();

    public Model getModel(){
        return model;
    }
    public void initialize(){
    }

    public void imageBlankClicked(MouseEvent mouseEvent) {
        model.changeImage();
    }
}