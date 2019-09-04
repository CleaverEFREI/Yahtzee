package fr.gailhac.main;

import fr.gailhac.dices.relance;
import fr.gailhac.dices.roll;
import fr.gailhac.grid.check;
import fr.gailhac.grid.memory;
import fr.gailhac.players.player;

class Main {

    public static void main(String[] args) {

        int nbplayer = player.request();
        if (nbplayer <= 0) {
            return;
        }
        if (nbplayer > 10) {
            System.out.println("Too much for your skill, try less");
            return;
        }
        int[][] mem = memory.iniMem(nbplayer);
        boolean[][] membool = memory.iniMemBool(nbplayer);
        boolean done = false;
        while (!done) {
            for (int joueur = 1; joueur <= nbplayer; joueur++) {
                System.out.println("-------------------------");
                System.out.println("Player " + joueur + " :\n");
                byte[] dices = roll.main(5);
                for (int i = 0; i <= 1; i++) {
                    relance.main(dices);
                }
                int checkeur = -1;
                while (checkeur < 0) {
                    int selection = check.menu(dices, membool, nbplayer - 1);
                    checkeur = memory.edit(selection, mem, membool, joueur, dices);
                    //System.out.println(Arrays.deepToString(mem));
                    //System.out.println(Arrays.deepToString(membool));
                    if (checkeur <= 0) System.out.println("Error this was already used");
                }
            }

            for (int i = 0; i < 13; i++) {
                done = true;
                if (!membool[nbplayer - 1][i]) {
                    done = false;
                    break;
                }

            }
        }
        int[] memScore = memory.iniMemScore(nbplayer);
        for (int j = 0; j < nbplayer; j++) {
            int score = memory.score(mem, j);
            memScore[j] = score;
            System.out.println("Player" + (j + 1) + " have " + score + " pts");
        }

        int max = memory.max(memScore);

        for (int j = 0; j < nbplayer; j++) {
            if (memScore[j] == max) {
                System.out.println("Player" + (j + 1) + "win !");
            }
        }

    }
}
