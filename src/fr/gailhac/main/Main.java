package fr.gailhac.main;

import fr.gailhac.dices.relance;
import fr.gailhac.dices.roll;
import fr.gailhac.grid.check;
import fr.gailhac.grid.memory;
import fr.gailhac.players.player;

class Main {

    public static void main(String[] args) {

        // Help for player
        player.IniHelp();

        // Selection of n* player
        int nbplayer = player.request();
        if (nbplayer <= 0) {
            return;
        }
        if (nbplayer > 10) {
            System.out.println("Too much for your skill, try less");
            return;
        }

        // memory initial
        System.out.println("Let the game begin !");
        int[][] mem = memory.iniMem(nbplayer);
        boolean[][] membool = memory.iniMemBool(nbplayer);

        // init. finish test

        boolean done = false;
        while (!done) {

            // start game

            for (int joueur = 1; joueur <= nbplayer; joueur++) {
                System.out.println("\n\n-------------------------" +
                        "\nPlayer " + joueur + " :\n" +
                        "-------------------------" +
                        "\nPlayer score :        " + player.score(nbplayer, mem, joueur) +
                        "\n-------------------------" +
                        "\n");
                //roll dice

                byte[] dices = roll.main(5);
                for (int i = 0; i <= 1; i++) {
                    //reroll dice
                    relance.main(dices);
                }

                int checkeur = -1;
                while (checkeur < 0) {
                    // secure the selection
                    int selection = check.menu(dices, membool, joueur - 1);
                    checkeur = memory.edit(selection, mem, membool, joueur, dices);
                    if (checkeur <= 0) System.out.println("Error this was already used");
                }
            }

            // test if game is finish

            for (int i = 0; i < 13; i++) {
                done = true;
                if (!membool[nbplayer - 1][i]) {
                    done = false;
                    break;
                }

            }
        }

        // print score

        int[] memScore = player.score(nbplayer, mem);
        int max = memory.max(memScore);

        // print winner

        for (int j = 0; j < nbplayer; j++) {
            if (memScore[j] == max) {
                System.out.println("Player" + (j + 1) + "win !");
            }
        }

        //end

    }
}
