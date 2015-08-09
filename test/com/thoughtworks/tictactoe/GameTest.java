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
public class GameTest {
    private static final String PLAYER_1_PROMPT_MESSAGE = "PLAYER 1\n" +
            "Make a move by entering a number between 1 to 9:";
    private static final String PLAYER_2_PROMPT_MESSAGE = "PLAYER 2\n" +
            "Make a move by entering a number between 1 to 9:";
    private static final String LOCATION_TAKEN_MESSAGE = "Location already taken";
    private static final String DRAW_MESSAGE = "Game is a draw";
    private static final String WIN_MESSAGE_PLAYER_1 = "Player 1 Wins!";
    private Game game;
    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        game = new Game(printStream, reader, board);
    }

    @Test
    public void shouldInitiateEmptyBoardWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("1");
        game.start();
        verify(board).print();
    }

    @Test
    public void shouldPromptPlayerOneToMakeAMoveWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.hasEmptySpace()).thenReturn(true, false);
        game.start();
        verify(printStream).println(contains(PLAYER_1_PROMPT_MESSAGE));
    }

    @Test
    public void shouldGetPlayerOnesMoveWhenPlayerOneEntersMove() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(board.hasEmptySpace()).thenReturn(true, false);
        game.start();
        verify(reader, atLeastOnce()).readLine();
    }

    @Test
    public void shouldUpdateBoardWhenPlayerChoosesSquareToMove() throws IOException {
        when(reader.readLine()).thenReturn("4");
        when(board.hasEmptySpace()).thenReturn(true, true, false);
        game.start();
        verify(board).move(1, 4);
    }

    @Test
    public void shouldPromptPlayerTwoToMakeAMoveWhenPlayerOnesTurnIsComplete() throws IOException {
        when(reader.readLine()).thenReturn("1", "2");
        when(board.hasEmptySpace()).thenReturn(true, true, false);
        game.start();
        verify(printStream, atLeastOnce()).println(contains(PLAYER_2_PROMPT_MESSAGE));
    }

    @Test
    public void shouldPromptPlayersToEnterMoveUntilBoardIsFilled() throws IOException {
        when(reader.readLine()).thenReturn("1", "2", "3", "4", "5", "6", "7", "8", "9");
        when(board.hasEmptySpace()).thenReturn(true, true, true, true, true, true, true, true, true, false);
        game.start();
        verify(printStream, times(5)).println("PLAYER 1\nMake a move by entering a number between 1 to 9:");
    }

    @Test
    public void shouldPromptUserToEnterAnotherMoveIfLocationIsAlreadyTaken() throws IOException {
        when(reader.readLine()).thenReturn("1", "1", "2");
        when(board.hasEmptySpace()).thenReturn(true, true, true, false);
        when(board.locationIsTaken(1)).thenReturn(false, true, false, false);
        game.start();
        verify(printStream).println(LOCATION_TAKEN_MESSAGE);
    }

    @Test
    public void shouldDetectWinIfPlayerHasThreeInARow() throws IOException {
        when(board.getWinner()).thenReturn(1);
        game.checkWinnerFound();
        verify(printStream, atLeastOnce()).println(contains(WIN_MESSAGE_PLAYER_1));
    }
}