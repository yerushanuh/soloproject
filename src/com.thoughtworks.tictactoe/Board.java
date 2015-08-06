package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class Board {
    private PrintStream printStream;
    private final int MAX_SIZE = 3;
    private int[][] board;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        board = new int[MAX_SIZE][MAX_SIZE];
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

        print();
    }

}
