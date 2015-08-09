package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class Game {
    private Board board;
    private BufferedReader reader;
    private PrintStream printStream;
    private int activeUser;
    private boolean winnerFound;

    public Game(PrintStream printStream, BufferedReader reader, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.board = board;
        this.activeUser = 1;
        this.winnerFound = false;
    }

    public void start() {
        board.print();

        while (board.hasEmptySpace() && !winnerFound) {
            actOnInput(promptUserForMove(activeUser));
        }

        checkIfDraw();
    }

    public void checkIfDraw() {
        if (!winnerFound) {
            printStream.println("Game is a draw");
        }
    }

    public void actOnInput(String input) {
        if (!board.locationIsTaken(Integer.parseInt(input))) {
            board.move(activeUser, Integer.parseInt(input));
            winnerFound = checkWinnerFound();
            switchUser();
        }
        else {
            printStream.println("Location already taken");
        }
    }

    public void switchUser() {
        if (activeUser == 1) {
            activeUser++;
        }
        else {
            activeUser--;
        }
    }

    public boolean checkWinnerFound() {
        boolean winnerFound = false;
        if (board.getWinner() != 0) {
            printStream.println("Player " + board.getWinner() + " Wins!");
            winnerFound = true;
        }

        return winnerFound;
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
