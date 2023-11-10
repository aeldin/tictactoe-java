package com.example.tictactoe;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeControllerTest {


    @Test
    void didSomebodyWin() {

        Model model = new Model(Mockito.mock(Image.class),Mockito.mock(Image.class),Mockito.mock(Image.class));
        model.clear();


        model.updateBoardState("topLeft", model.getImageX());
        model.updateBoardState("topCenter", model.getImageX());
        model.updateBoardState("topRight", model.getImageX());

        String winner = model.checkForWinner();

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("midLeft", model.getImageX());
        model.updateBoardState("midCenter", model.getImageX());
        model.updateBoardState("midRight", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("bottomLeft", model.getImageX());
        model.updateBoardState("bottomCenter", model.getImageX());
        model.updateBoardState("bottomRight", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("topLeft", model.getImageX());
        model.updateBoardState("midLeft", model.getImageX());
        model.updateBoardState("bottomLeft", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("topCenter", model.getImageX());
        model.updateBoardState("midCenter", model.getImageX());
        model.updateBoardState("bottomCenter", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("topRight", model.getImageX());
        model.updateBoardState("midRight", model.getImageX());
        model.updateBoardState("bottomRight", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("topLeft", model.getImageX());
        model.updateBoardState("midCenter", model.getImageX());
        model.updateBoardState("bottomRight", model.getImageX());

        assertNotNull(winner);
        assertEquals("Player X", winner);

        model.clear();

        model.updateBoardState("topRight", model.getImageX());
        model.updateBoardState("midCenter", model.getImageX());
        model.updateBoardState("bottomLeft", model.getImageX());


        assertNotNull(winner);
        assertEquals("Player X", winner);





        model.updateBoardState("topLeft", model.getImageO());
        model.updateBoardState("topCenter", model.getImageO());
        model.updateBoardState("topRight", model.getImageO());


        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("midLeft", model.getImageO());
        model.updateBoardState("midCenter", model.getImageO());
        model.updateBoardState("midRight", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("bottomLeft", model.getImageO());
        model.updateBoardState("bottomCenter", model.getImageO());
        model.updateBoardState("bottomRight", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("topLeft", model.getImageO());
        model.updateBoardState("midLeft", model.getImageO());
        model.updateBoardState("bottomLeft", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("topCenter", model.getImageO());
        model.updateBoardState("midCenter", model.getImageO());
        model.updateBoardState("bottomCenter", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("topRight", model.getImageO());
        model.updateBoardState("midRight", model.getImageO());
        model.updateBoardState("bottomRight", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("topLeft", model.getImageO());
        model.updateBoardState("midCenter", model.getImageO());
        model.updateBoardState("bottomRight", model.getImageO());

        assertNotNull(winner);
        assertEquals("Player O", winner);

        model.clear();

        model.updateBoardState("topRight", model.getImageO());
        model.updateBoardState("midCenter", model.getImageO());
        model.updateBoardState("bottomLeft", model.getImageO());


        assertNotNull(winner);
        assertEquals("Player O", winner);

    }

    @Test
    void isItADraw() {
        Model model = new Model(Mockito.mock(Image.class),Mockito.mock(Image.class),Mockito.mock(Image.class));
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

        // Test updating a blank cell with Player X image
        assertTrue(model.updateBoardState("topLeft", model.getImageX()));
        assertEquals(model.getImageX(), model.getFirst());

        // Test updating a non-blank cell, which should return false
        assertTrue(model.updateBoardState("topLeft", model.getImageO()));
        assertEquals(model.getImageO(), model.getFirst()); // Check that the cell remains unchanged

        // Test updating another cell with Player O image
        assertTrue(model.updateBoardState("midCenter", model.getImageO()));
        assertEquals(model.getImageO(), model.getFifth());

    }
}