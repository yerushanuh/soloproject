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
    private static final String PLAYER_1_PROMPT_MESSAGE = "PLAYER 1\n" +
            "Make a move by entering a number between 1 to 9:";
    private TicTacToe ticTacToe;
    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        ticTacToe = new TicTacToe(printStream, reader, board);
    }

    @Test
    public void shouldDrawBoardWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("1");
        ticTacToe.start();
        verify(board).print();
    }

    @Test
    public void shouldPromptPlayerOneToMakeAMoveWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("1");
        ticTacToe.start();
        verify(printStream).println(contains(PLAYER_1_PROMPT_MESSAGE));
    }

    @Test
    public void shouldGetPlayerOnesMoveWhenPlayerOneEntersMove() throws IOException {
        when(reader.readLine()).thenReturn("1");
        ticTacToe.start();
        verify(reader).readLine();
    }

    @Test
    public void shouldDrawXWhenPlayerChoosesSquareToMove() throws IOException {
        when(reader.readLine()).thenReturn("4");
        ticTacToe.start();
        verify(board).move(4);
    }
}