package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(System.out);
        ticTacToe.start();
    }
}