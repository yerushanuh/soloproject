package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by ynuh on 8/6/15.
 */
public class Board {
    private PrintStream printStream;

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

    public void move(int square) {
        int row = (square - 1) / 3;

        for (int i = 0; i < row; i++) {
            printStream.println(" | | ");
        }

        switch(square % 3){
            case 1:
                printStream.println("X| | ");
                break;
            case 2:
                printStream.println("|X| ");
                break;
            case 0:
                printStream.println(" | |X");
                break;
            default:
                break;
        }

        for (int i = 0; i < 3 - row - 1; i++) {
            printStream.println(" | | ");
        }
    }
}
