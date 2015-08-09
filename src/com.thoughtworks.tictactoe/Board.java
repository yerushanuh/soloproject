package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class Board {
    private PrintStream printStream;
    private final int MAX_SIZE = 3;
    private int[][] board;
    private int occupiedSpace;
    private int winner;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.board = new int[MAX_SIZE][MAX_SIZE];
        this.occupiedSpace = 0;
        this.winner = 0;
    }

    public void print() {
        String output = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch(board[i][j]) {
                    case 1:
                        output += "X";
                        break;
                    case 2:
                        output += "O";
                        break;
                    default:
                        output += " ";
                        break;
                }

                if (j < MAX_SIZE - 1) {
                    output += "|";
                }
            }
            if (i < MAX_SIZE - 1) {
                output += "\n-----\n";
            }
        }

        printStream.println(output);
    }

    public void move(int activeUser, int square) {
        int row = (square - 1) / 3;
        int column = (square % 3 == 0) ? 2 : (square % 3) - 1;

        board[row][column] = activeUser;
        occupiedSpace++;

        print();

        if (checkWin()) {
            this.winner = activeUser;
        }
    }

    private boolean checkWin() {
        boolean winnerFound = false;

        for (int j = 0; j < board.length; j++) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                winnerFound = true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                winnerFound = true;
            }
        }

        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            winnerFound = true;
        }

        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            winnerFound = true;
        }

        return winnerFound;
    }

    public boolean hasEmptySpace() {
        return !(occupiedSpace == 9);
    }

    public boolean locationIsTaken(int square) {
        int row = (square - 1) / 3;
        int column = (square % 3 == 0) ? 2 : (square % 3) - 1;

        return (board[row][column] != 0);
    }

    public int getWinner() {
        return winner;
    }
}
