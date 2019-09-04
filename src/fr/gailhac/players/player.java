package fr.gailhac.players;

import java.util.Scanner;

public class player {

    // Request how many player i have in game:

    public static int request() {
        System.out.println("How many players ?");
        Scanner s = new Scanner(System.in);
        int player;
        player = s.nextInt();
        return player;
    }

}
