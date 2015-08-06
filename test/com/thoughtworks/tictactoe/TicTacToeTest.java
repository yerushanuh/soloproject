package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by ynuh on 8/6/15.
 */
public class TicTacToeTest {
    private PrintStream printStream;
    private TicTacToe ticTacToe;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        ticTacToe = new TicTacToe(printStream);
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
        //verify(ticTacToe).promptUserForMove();
    }

//    @Test
//    public void shouldDrawXWhenPlayerChoosesSquareToMove() {
//        ticTacToe.start();
//        verify(printStream).println(contains("X"));
//    }

}