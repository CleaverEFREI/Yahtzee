package fr.gailhac.dices;


import fr.gailhac.main.random;
import org.jetbrains.annotations.NotNull;

public class roll {

    // Overcharge main :

    // For full reroll or first time :

    @NotNull
    public static byte[] main(int dice) {
        byte[] D = new byte[]{};
        for (int i = 0; i < dice; i++) {
            int rng = random.Int(6);
            D = addToArray(D, rng);
        }

        return D;

    }

    // For not full reroll :

    static void main(@NotNull byte[] D, @NotNull byte[] num) {

        for (byte b : num) {
            if (b - 1 < D.length) {

                int rng = random.Int(6);
                replaceArray(D, b - 1, rng);
                //System.out.println("New dices :"+ Arrays.toString(D));

            }
        }

    }

    // Replace in array

    private static void replaceArray(@NotNull byte[] D, int nb, int rng) {

        for (int i = 0; i < D.length; i++) {
            if (i == nb) {
                D[nb] = (byte) rng;
                break;
            }
        }
    }

    // Add in array

    @NotNull
    private static byte[] addToArray(@NotNull byte[] initialArray, int newValue) {

        byte[] newArray = new byte[initialArray.length + 1];
        System.arraycopy(initialArray, 0, newArray, 0, initialArray.length);
        newArray[newArray.length - 1] = (byte) newValue;
        return newArray;
    }
}
