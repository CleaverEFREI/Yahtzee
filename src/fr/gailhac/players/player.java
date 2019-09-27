package fr.gailhac.players;

import fr.gailhac.grid.memory;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class player {

    public static void IniHelp() {

        boolean Help = false;
        while (!Help) {
            if (help()) {
                print();
                if (rules()) {
                    printrules();
                }
            } else Help = true;
        }

    }

    @NotNull
    public static int[] score(int nbplayer, int[][] mem) {
        int[] memScore = memory.iniMemScore(nbplayer);
        for (int j = 0; j < nbplayer; j++) {
            int score = memory.score(mem, j);
            memScore[j] = score;
            System.out.println("Player" + (j + 1) + " have " + score + " pts");
        }
        return memScore;
    }

    public static int score(int nbplayer, int[][] mem, int player) {
        int j = player - 1;
        int[] memScore = memory.iniMemScore(nbplayer);
        int score = memory.score(mem, j);
        memScore[j] = score;
        return score;
    }
    // Request how many player i have in game:

    public static int request() {
        System.out.println("How many players ?");
        Scanner s = new Scanner(System.in);
        int player = 1;
        try {
            player = s.nextInt();
        } catch (Exception e) {
            System.out.println("Something went wrong.\n");
            System.out.println("Initializing for 1 player\n");
        }
        return player;
    }

    private static boolean help() {
        System.out.println("Do you need help with the game ?");
        return ScanHR2();
    }

    private static boolean rules() {
        System.out.println("Do you need help with the rules ?");
        return ScanHR2();
    }

    private static boolean ScanHR2() {
        System.out.println("(y/n)");
        Scanner s = new Scanner(System.in);
        char help;
        help = s.next().charAt(0);
        return help == 'y';
    }

    private static void print() {
        System.out.println("To initialize the game, enter the number of players in the game.\n" +
                "Player 1 start to play, and his first throw will be displayed.\n" +
                "To select the dice to be restarted, first indicate the number of dice you want to restart. Then indicate the numbers of the dice to be rolled (from 1 to 5) as follows: \n" +
                "1 3 4\n" +
                "Or else\n" +
                "1\n" +
                "3\n" +
                "4\n" +
                "Once all the throws have been made, select the move you want to make (1 to 13), the moves already made are no longer displayed.\n" +
                "For more information on Yahtzee rules, type \"y\"\n" +
                "to the next question");
    }

    private static void printrules() {
        System.out.println("Yahtzee Rules\n" +
                "The objective of YAHTZEE is to get as many points as possible by rolling five dice and getting certain combinations of dice.\n" +
                "\n" +
                "Gameplay\n" +
                "In each turn a player may throw the dice up to three times. A player doesn't have to roll all five dice on the second and third throw of a round, he may put as many dice as he wants to the side and only throw the ones that don't have the numbers he's trying to get. For example, a player throws and gets 1,3,3,4,6. He decides he want to try for the large straight, 1,2,3,4,5. So, he puts 1,3,4 to the side and only throws 3 and 6 again, hoping to get 2 and 5.\n" +
                "\n" +
                "In this game you click on the dice you want to keep. They will be moved down and will not be thrown the next time you press the 'Roll Dice' button. If you decide after the second throw in a turn that you don't want to keep the same dice before the third throw then you can click them again and they will move back to the table and be thrown in the third throw.\n" +
                "\n" +
                "Upper section combinations\n" +
                "Ones: Get as many ones as possible.\n" +
                "Twos: Get as many twos as possible.\n" +
                "Threes: Get as many threes as possible.\n" +
                "Fours: Get as many fours as possible.\n" +
                "Fives: Get as many fives as possible.\n" +
                "Sixes: Get as many sixes as possible.\n" +
                "For the six combinations above the score for each of them is the sum of dice of the right kind. E.g. if you get 1,3,3,3,5 and you choose Threes you will get 3*3 = 9 points. The sum of all the above combinations is calculated and if it is 63 or more, the player will get a bonus of 35 points. On average a player needs three of each to reach 63, but it is not required to get three of each exactly, it is perfectly OK to have five sixes, and zero ones for example, as long as the sum is 63 or more the bonus will be awarded.\n" +
                "\n" +
                "Lower section combinations\n" +
                "Three of a kind: Get three dice with the same number. Points are the sum all dice (not just the three of a kind).\n" +
                "Four of a kind: Get four dice with the same number. Points are the sum all dice (not just the four of a kind).\n" +
                "Full house: Get three of a kind and a pair, e.g. 1,1,3,3,3 or 3,3,3,6,6. Scores 25 points.\n" +
                "Small straight: Get four sequential dice, 1,2,3,4 or 2,3,4,5 or 3,4,5,6. Scores 30 points.\n" +
                "Large straight: Get five sequential dice, 1,2,3,4,5 or 2,3,4,5,6. Scores 40 points.\n" +
                "Chance: You can put anything into chance, it's basically like a garbage can when you don't have anything else you can use the dice for. The score is simply the sum of the dice.\n" +
                "YAHTZEE: Five of a kind. Scores 50 points.");
    }

}
