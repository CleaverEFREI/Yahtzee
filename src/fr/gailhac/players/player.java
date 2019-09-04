package fr.gailhac.players;

import java.util.Scanner;

public class player {

    public static int request() {
        System.out.println("How many players ?");
        Scanner s = new Scanner(System.in);
        int player;
        player = s.nextInt();
        return player;
    }
}
