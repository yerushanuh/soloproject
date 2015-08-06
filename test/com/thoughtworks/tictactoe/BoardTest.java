package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by ynuh on 8/6/15.
 */
public class BoardTest {
    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawBoard() {
        board.print();
        verify(printStream, atLeastOnce()).println(contains("-----"));
    }

    @Test
    public void shouldDrawXOnBoardWhenPlayerMoves() {
        board.move(1, 4);
        verify(printStream, atLeastOnce()).println(contains(" | | "));
        verify(printStream).println(contains("X| | "));
    }

    @Test
    public void shouldDrawAllMovesMadeSinceStartOfGameWhenDrawingBoard() {
        board.move(1, 1);
        board.move(2, 2);
        verify(printStream, atLeastOnce()).println(contains("X|O| "));
    }
}