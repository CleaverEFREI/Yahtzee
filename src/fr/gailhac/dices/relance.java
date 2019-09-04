package fr.gailhac.dices;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class relance {

    // Reroll script

    public static void main(@NotNull byte[] D) {
        byte[] num;
        out.println("My dices : " + Arrays.toString(D));
        num = menu();
        roll.main(D, num);
        if(num.length == 5){
            roll.main(5);
        }
    }

    // Menu for reroll choice

    @NotNull
    private static byte[] menu() {

        Scanner s = new Scanner(in);
        int n = -1;
        while (n < 0 || n > 5) {
            out.print("\nEnter no. of dices you want to reroll:\n ");
            n = s.nextInt();
            if (n < 0 || n > 5) out.println("Error");
        }
        if (n == 5){
            return new byte[]{1, 2, 3, 4, 5};
        }
        out.println("\n-------------------------");
        out.println("1 - Reroll First Dice");
        out.println("2 - Reroll Second Dice");
        out.println("3 - Reroll Third Dice");
        out.println("4 - Reroll Fourth Dice");
        out.println("5 - Reroll Fifth Dice");
        byte[] selection = new byte[n];
        out.println("Enter the numbers of the dices you want to reroll:\n ");
        for (int i = 0; i < n; i++) {
            selection[i] = (byte) s.nextInt();
        }
        return selection;
    }
}
