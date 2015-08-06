package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe ticTacToe = new TicTacToe(System.out, reader);
        ticTacToe.start();
    }
}