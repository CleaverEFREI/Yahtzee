package fr.gailhac.grid;

import org.jetbrains.annotations.NotNull;

class possibility {

    // Script for calculate

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

    private static int sim(@NotNull byte[] x, int nb) {

        int count = 0;

        for (byte b : x) {
            if (nb == b) count++;
        }
        return count;
    }

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

    private static int total(@NotNull byte[] x) {

        int somme = 0;
        for (byte b : x) {
            somme += b;
        }

        return somme;
    }

    // All posibility of my grid

    static int Aces(@NotNull byte[] x) {

        return test(x, 1);
    }

    static int Twos(@NotNull byte[] x) {

        return test(x, 2);
    }

    static int Threes(@NotNull byte[] x) {

        return test(x, 3);
    }

    static int Fours(@NotNull byte[] x) {

        return test(x, 4);
    }

    static int Fives(@NotNull byte[] x) {

        return test(x, 5);
    }

    static int Sixes(@NotNull byte[] x) {

        return test(x, 6);
    }

    static int Brelan(@NotNull byte[] x) {
        int n = 3;
        return somme(x, n);
    }

    static int Carre(@NotNull byte[] x) {
        int n = 4;
        return somme(x, n);
    }

    static int Full(@NotNull byte[] x) {

        int save = -1;

        for (byte b : x) {
            if (sim(x, b) >= 3) {
                save = b;
            }
            if (sim(x, b) >= 2) {
                if (b != save && save != -1) return 25;
            }
        }
        return 0;

    }

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
            for (int i = 0; i < x.length; i++) {
                if (sim(x, i) > 1) {
                    return 0;
                }
            }
            return 40;
        }
        return 0;
    }

    static int Yahtzee(@NotNull byte[] x) {

        for (byte b : x) {
            if (sim(x, b) >= 5) {
                return 50;
            }
        }
        return 0;
    }

    static int Chance(@NotNull byte[] x) {
        return total(x);
    }

}
