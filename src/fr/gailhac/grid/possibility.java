package fr.gailhac.grid;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class possibility {

    // Script for calculate

    @Contract(pure = true)
    private static int test(@NotNull byte[] x, int n) {
        int cpt = 0;

        for (byte b : x) {
            if (b == n) {
                cpt++;
            }
        }
        switch (cpt) {
            case 0:
                return 0;
            case 1:
                return n;
            case 2:
                return n * 2;
            case 3:
                return n * 3;
            case 4:
                return n * 4;
            case 5:
                return n * 5;
        }
        return 0;
    }

    @Contract(pure = true)
    private static int sim(@NotNull byte[] x, int nb) {

        int count = 0;

        for (byte b : x) {
            if (nb == b) count++;
        }
        return count;
    }

    @Contract(pure = true)
    private static int somme(@NotNull byte[] x, int n) {
        int somme = 0;
        for (byte b : x) {
            if (sim(x, b) >= n) {
                for (byte c : x) {
                    somme += c;
                }
                return somme;
            }
        }
        return 0;
    }

    @Contract(pure = true)
    private static int total(@NotNull byte[] x) {

        int somme = 0;
        for (byte b : x) {
            somme += b;
        }

        return somme;
    }

    // All possibility of my grid

    @Contract(pure = true)
    static int Aces(@NotNull byte[] x) {

        return test(x, 1);
    }

    @Contract(pure = true)
    static int Twos(@NotNull byte[] x) {

        return test(x, 2);
    }

    @Contract(pure = true)
    static int Threes(@NotNull byte[] x) {

        return test(x, 3);
    }

    @Contract(pure = true)
    static int Fours(@NotNull byte[] x) {

        return test(x, 4);
    }

    @Contract(pure = true)
    static int Fives(@NotNull byte[] x) {

        return test(x, 5);
    }

    @Contract(pure = true)
    static int Sixes(@NotNull byte[] x) {

        return test(x, 6);
    }

    @Contract(pure = true)
    static int Brelan(@NotNull byte[] x) {
        int n = 3;
        return somme(x, n);
    }

    @Contract(pure = true)
    static int Carre(@NotNull byte[] x) {
        int n = 4;
        return somme(x, n);
    }

    static int Full(@NotNull byte[] x) {

        int save;

        for (byte b : x) {
            if (sim(x, b) >= 2) {
                save = b;
                for (byte b2 : x) {
                    if (sim(x, b2) >= 3) {
                        if (b2 != save) return 25;
                    }
                }
            }
        }

        return 0;

    }

    @Contract(pure = true)
    static int SmStraight(@NotNull byte[] x) {
        int valid3 = 0;
        int valid4 = 0;
        for (byte b : x) {
            if (b == 3) {
                valid3++;
            }
            if (b == 4) {
                valid4++;
            }
        }
        if (valid3 >= 1 && valid4 >= 1) {
            for (byte b : x) {
                if (b == 2) {
                    for (byte b2 : x) {
                        if (b2 == 1) {
                            return 30;
                        }
                        if (b2 == 5) {
                            return 30;
                        }
                    }
                }
                if (b == 5) {
                    for (byte b2 : x) {
                        if (b2 == 2) {
                            return 30;
                        }
                        if (b2 == 6) {
                            return 30;
                        }
                    }
                }
            }
        }
        return 0;
    }

    static int LgStraight(@NotNull byte[] x) {

        if (sim(x, 1) == 1 ^ sim(x, 6) == 1) {
            for (int i = 1; i <= 6; i++) {
                if (sim(x, i) > 1) {
                    return 0;
                }
            }
            return 40;
        }
        return 0;
    }

    @Contract(pure = true)
    static int Yahtzee(@NotNull byte[] x) {

        for (byte b : x) {
            if (sim(x, b) >= 5) {
                return 50;
            }
        }
        return 0;
    }

    @Contract(pure = true)
    static int Chance(@NotNull byte[] x) {
        return total(x);
    }

}
