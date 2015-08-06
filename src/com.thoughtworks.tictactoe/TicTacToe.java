package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class TicTacToe {
    private PrintStream printStream;

    public TicTacToe(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printBoard();
    }

    public void printBoard() {
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
    }

    public void promptUserForMove() {
    }
}
