package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class Board {
    private PrintStream printStream;
    private final int MAX_SIZE = 3;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print() {
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
        printStream.println("-----");
        printStream.println(" | | ");
    }

    public void move(int activeUser, int square) {
        int[][] board = new int[MAX_SIZE][MAX_SIZE];
        int row = (square - 1) / 3;
        int column = (square % 3 == 0) ? 2 : (square % 3) - 1;
        String output = "";

        board[row][column] = activeUser;

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

}
