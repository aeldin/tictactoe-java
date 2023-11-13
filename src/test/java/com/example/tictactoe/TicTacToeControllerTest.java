package com.example.tictactoe;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeControllerTest {


    @Test
    void didSomebodyWin() {
        Model model = new Model(Mockito.mock(Image.class), Mockito.mock(Image.class), Mockito.mock(Image.class));
        model.clear();

        assertWinner(model, "Player X", "topLeft", "topCenter", "topRight");
        assertWinner(model, "Player X", "midLeft", "midCenter", "midRight");
        assertWinner(model, "Player X", "bottomLeft", "bottomCenter", "bottomRight");
        assertWinner(model, "Player X", "topLeft", "midLeft", "bottomLeft");
        assertWinner(model, "Player X", "topCenter", "midCenter", "bottomCenter");
        assertWinner(model, "Player X", "topRight", "midRight", "bottomRight");
        assertWinner(model, "Player X", "topLeft", "midCenter", "bottomRight");
        assertWinner(model, "Player X", "topRight", "midCenter", "bottomLeft");

        assertWinner(model, "Player O", "topLeft", "topCenter", "topRight");
        assertWinner(model, "Player O", "midLeft", "midCenter", "midRight");
        assertWinner(model, "Player O", "bottomLeft", "bottomCenter", "bottomRight");
        assertWinner(model, "Player O", "topLeft", "midLeft", "bottomLeft");
        assertWinner(model, "Player O", "topCenter", "midCenter", "bottomCenter");
        assertWinner(model, "Player O", "topRight", "midRight", "bottomRight");
        assertWinner(model, "Player O", "topLeft", "midCenter", "bottomRight");
        assertWinner(model, "Player O", "topRight", "midCenter", "bottomLeft");
    }

    private void assertWinner(Model model, String player, String... moves) {
        for (String move : moves) {
            model.updateBoardState(move, player.equals("Player X") ? model.getImageX() : model.getImageO());
        }

        String winner = model.checkForWinner();
        assertNotNull(winner);
        assertEquals(player, winner);

        model.clear();
    }

    @Test
    void isItADraw() {
        Model model = new Model(Mockito.mock(Image.class), Mockito.mock(Image.class), Mockito.mock(Image.class));
        model.clear();

        model.updateBoardState("topLeft", model.getImageX());
        model.updateBoardState("topCenter", model.getImageO());
        model.updateBoardState("topRight", model.getImageX());
        model.updateBoardState("midLeft", model.getImageX());
        model.updateBoardState("midCenter", model.getImageO());
        model.updateBoardState("midRight", model.getImageO());
        model.updateBoardState("bottomLeft", model.getImageO());
        model.updateBoardState("bottomCenter", model.getImageX());
        model.updateBoardState("bottomRight", model.getImageX());

        assertTrue(model.isDraw());
    }

    @Test
    void updateBoardState() {
        Model model = new Model(Mockito.mock(Image.class), Mockito.mock(Image.class), Mockito.mock(Image.class));
        model.clear();

        assertTrue(model.updateBoardState("topLeft", model.getImageX()));
        assertEquals(model.getImageX(), model.getFirst());
        model.legalMoves.remove("topLeft");


        assertFalse(model.updateBoardState("topLeft", model.getImageO()));
        assertEquals(model.getImageX(), model.getFirst());


        assertTrue(model.updateBoardState("midCenter", model.getImageO()));
        assertEquals(model.getImageO(), model.getFifth());

    }
}