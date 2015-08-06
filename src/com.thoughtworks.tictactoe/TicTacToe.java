package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class TicTacToe {
    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;
    private int activeUser;

    public TicTacToe(PrintStream printStream, BufferedReader reader, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.board = board;
        this.activeUser = 1;
    }

    public void start() {
        boolean isAbleToContinueGame = true;
        String input;

        board.print();

        while (isAbleToContinueGame) {
            input = promptUserForMove(activeUser);
            board.move(activeUser, Integer.parseInt(input));

            if (activeUser == 1) {
                activeUser++;
            }
            else {
                activeUser--;
            }
        }
    }

    public String promptUserForMove(int activeUser) {
        String input = "";
        printStream.println("PLAYER " + activeUser + "\nMake a move by entering a number between 1 to 9:");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
