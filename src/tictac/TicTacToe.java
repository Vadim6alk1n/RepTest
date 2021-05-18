package tictac;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static String[] bd;
    static String turn;

    static void drawBoard()
    {
        System.out.println("*************");
        System.out.println("* " + bd[0] + " * " + bd[1] + " * " + bd[2] + " *");
        System.out.println("*************");
        System.out.println("* " + bd[3] + " * " + bd[4] + " * " + bd[5] + " *");
        System.out.println("*************");
        System.out.println("* " + bd[6] + " * " + bd[7] + " * " + bd[8] + " *");
        System.out.println("*************");
    }

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line;
            switch (a) {
                case 0: line = bd[0] + bd[1] + bd[2]; break;
                case 1: line = bd[3] + bd[4] + bd[5]; break;
                case 2: line = bd[6] + bd[7] + bd[8]; break;
                case 3: line = bd[0] + bd[3] + bd[6]; break;
                case 4: line = bd[1] + bd[4] + bd[7]; break;
                case 5: line = bd[2] + bd[5] + bd[8]; break;
                case 6: line = bd[0] + bd[4] + bd[8]; break;
                case 7: line = bd[2] + bd[4] + bd[6]; break;
                default: line = null;
            };

            if (line.equals("XXX")) {
                return "X";
            }

            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(bd).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        System.out.println(turn + "turn:");
        return null;
    }

        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);
            bd = new String[9];
            turn = "X";
            String winner = null;

            for (int a = 0; a < 9; a++) {
                bd[a] = String.valueOf(a + 1);
            }

            drawBoard();

            System.out.println("X turn");

            while (winner == null) {
                int numInput;

                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println(
                                "Invalid number; re-enter:");
                        continue;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println(
                            "Invalid number; re-enter:");
                    continue;
                }
                if (bd[numInput - 1].equals(
                        String.valueOf(numInput))) {
                    bd[numInput - 1] = turn;

                    if (turn.equals("X")) {
                        turn = "O";
                    }else{
                        turn = "X";
                    }

                    drawBoard();
                    winner = checkWinner();
                }else{
                    System.out.println(
                            "Wrong place; re-enter:");
                }
            }

            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Draw");
            }else{
                System.out.println("Winner is:" + winner);
            }
        }
    }

