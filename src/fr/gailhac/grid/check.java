package fr.gailhac.grid;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class check {

    public static int menu(@NotNull byte[] d, boolean[][] bool, int player) {

        System.out.println("My dices : " + Arrays.toString(d));
        System.out.println("Choose one or more from these choices");
        System.out.println("-------------------------");
        if (!bool[player][0]) {
            System.out.println("1 - " + possibility.Aces(d) + " points for the aces");
        }
        if (!bool[player][1]) {
            System.out.println("2 - " + possibility.Twos(d) + " points for the twos");
        }
        if (!bool[player][2]) {
            System.out.println("3 - " + possibility.Threes(d) + " points for the threes");
        }
        if (!bool[player][3]) {
            System.out.println("4 - " + possibility.Fours(d) + " points for the fours");
        }
        if (!bool[player][4]) {
            System.out.println("5 - " + possibility.Fives(d) + " points for the fives");
        }
        if (!bool[player][5]) {
            System.out.println("6 - " + possibility.Sixes(d) + " points for the sixes");
        }
        if (!bool[player][6]) {
            System.out.println("7 - " + possibility.Brelan(d) + " points for the 3 of kind");
        }
        if (!bool[player][7]) {
            System.out.println("8 - " + possibility.Carre(d) + " points for the 4 of kind");
        }
        if (!bool[player][8]) {
            System.out.println("9 - " + possibility.Full(d) + " points for the full house");
        }
        if (!bool[player][9]) {
            System.out.println("10 - " + possibility.SmStraight(d) + " points for the low straight");
        }
        if (!bool[player][10]) {
            System.out.println("11 - " + possibility.LgStraight(d) + " points for the high straight ");
        }
        if (!bool[player][11]) {
            System.out.println("12 - " + possibility.Yahtzee(d) + " points for the Yahtzee");
        }
        if (!bool[player][12]) {
            System.out.println("13 - " + possibility.Chance(d) + " points for the chance");
        }
        Scanner s = new Scanner(System.in);
        int selection;
        System.out.println("Enter the elements you wan't to do:\n ");
        selection = s.nextInt();
        return selection;
    }
}