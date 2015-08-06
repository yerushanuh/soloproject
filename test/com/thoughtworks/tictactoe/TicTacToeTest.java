package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by ynuh on 8/6/15.
 */
public class TicTacToeTest {
    private TicTacToe ticTacToe;
    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        ticTacToe = new TicTacToe(printStream, reader);
    }

    @Test
    public void shouldDrawBoardWhenStarting() {
        ticTacToe.start();
        verify(printStream, times(3)).println(contains(" | | "));
        verify(printStream, times(2)).println(contains("-----"));
    }

    @Test
    public void shouldPromptPlayerOneToMakeAMoveWhenStarting() {
        ticTacToe.start();
        verify(printStream).println(contains("PLAYER 1\nMake a move by entering a number between 1 to 9:"));
    }

    @Test
    public void shouldGetPlayerOnesMoveWhenPlayerOneEntersMove() throws IOException {
        ticTacToe.start();
        verify(reader).readLine();
    }

//    @Test
//    public void shouldDrawXWhenPlayerChoosesSquareToMove() {
//        ticTacToe.start();
//        verify(printStream).println(contains("X"));
//    }

}