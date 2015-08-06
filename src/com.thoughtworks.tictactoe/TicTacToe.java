package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class TicTacToe {
    private BufferedReader reader;
    private PrintStream printStream;

    public TicTacToe(PrintStream printStream, BufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public void start() {
        String input;
        printBoard();
        input = promptUserForMove();
    }

    public void printBoard() {
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
    }

    public String promptUserForMove() {
        String input = "";
        printStream.println("PLAYER 1\nMake a move by entering a number between 1 to 9:");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
