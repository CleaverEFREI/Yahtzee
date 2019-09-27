package fr.gailhac.grid;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class memory {

    // Init. memory :
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    public static int[][] iniMem(int Joueurs) {
        return new int[Joueurs][13];
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    public static boolean[][] iniMemBool(int Joueurs) {
        return new boolean[Joueurs][13];
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    public static int[] iniMemScore(int Joueurs) {
        return new int[Joueurs];
    }

    // Max / Edit / Score mem. test / modify.

    @Contract(pure = true)
    public static int max(@NotNull int[] t) {
        int maximum = t[0];   // start with the first value
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximum) {
                maximum = t[i];   // new maximum
            }
        }
        return maximum;
    }

    public static int edit(int s, int[][] tab, boolean[][] bool, int joueur, @NotNull byte[] dice) {
        joueur--;
        switch (s) {
            case 1:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Aces(dice);
                } else return -1;
                break;
            case 2:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Twos(dice);
                } else return -1;
                break;
            case 3:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Threes(dice);
                } else return -1;
                break;
            case 4:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Fours(dice);
                } else return -1;
                break;
            case 5:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Fives(dice);
                } else return -1;
                break;
            case 6:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Sixes(dice);
                } else return -1;
                break;
            case 7:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Brelan(dice);
                } else return -1;
                break;
            case 8:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Carre(dice);
                } else return -1;
                break;
            case 9:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Full(dice);
                } else return -1;
                break;
            case 10:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.SmStraight(dice);
                } else return -1;
                break;
            case 11:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.LgStraight(dice);
                } else return -1;
                break;
            case 12:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Yahtzee(dice);
                } else return -1;
                break;
            case 13:
                if (!bool[joueur][s - 1]) {
                    tab[joueur][s - 1] = possibility.Chance(dice);
                } else return -1;
                break;
            default:
                return -1;

        }
        bool[joueur][s - 1] = true;
        return 1;
    }

    @Contract(pure = true)
    public static int score(int[][] tab, int player) {
        int scr = 0;
        for (int j = 0; j <= 6; j++) {
            scr += tab[player][j];
        }
        if (scr >= 63) scr += 35;
        for (int j = 7; j < 13; j++) {
            scr += tab[player][j];
        }
        return scr;
    }
}
