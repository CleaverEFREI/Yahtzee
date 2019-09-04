package fr.gailhac.main;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class random {

    @NotNull
    public static Integer Int(int x) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(x) + 1;
    }
}