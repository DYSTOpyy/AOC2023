package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Secondday {
    static final int NB_RED = 12;
    static final int NB_GREEN = 13;
    static final int NB_BLUE = 14;

    public static void main(String[] args) {

        BufferedReader reader;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("red", 0);
        map.put("green", 1);
        map.put("blue", 2);
        int somme = 0;
        int nbGame;

        try {
            reader = new BufferedReader(new FileReader("day2\\input.txt"));
            String line = reader.readLine();
            while (line != null) {

                int[] gameMax = { 0, 0, 0 };

                // séparation game x / red,blue,green
                // System.out.println(line);
                String[] gameAndColors = line.split(":");
                for (String string : gameAndColors) {
                    string = string.trim();
                    // System.out.println(string);
                }

                nbGame = Integer.valueOf(gameAndColors[0].split(" ")[1]);

                // séparation entre chaque parties dans la game par le ;
                String[] parties = gameAndColors[1].split(";");
                for (int i = 0; i < parties.length; i++) {
                    parties[i] = parties[i].trim();
                    parties[i] = parties[i].replaceAll(",", "");
                    // System.out.println(str2[i]);
                }

                // séparation entre couleurs et chiffres par " "
                String[][] valueAndColor = new String[parties.length][6];
                for (int i = 0; i < parties.length; i++) {
                    valueAndColor[i] = parties[i].split(" ");

                    int value = -1, indice;

                    // déterminer le max de l'ensemble des parties
                    for (int j = 0; j < valueAndColor[i].length; j++) {

                        if (j % 2 == 0) {
                            value = Integer.valueOf(valueAndColor[i][j]);
                        } else {
                            if (value != -1) {
                                indice = map.get(valueAndColor[i][j]);
                                if (gameMax[indice] < value) {
                                    gameMax[indice] = value;
                                }
                            } else {
                                System.err.println("ALERTE VALUE A -1");
                            }

                        }
                    }
                }

                // ---------------- PARTIE 1
                // if (gameMax[0] <= NB_RED && gameMax[1] <= NB_GREEN && gameMax[2] <= NB_BLUE) {
                //     somme += nbGame;
                //     System.out.println("OUI : " + String.valueOf(nbGame));
                // }

                // ---------------- PARTIE 2
                somme += gameMax[1] * gameMax[2] * gameMax[0];

                line = reader.readLine();

                // fin while
            }

            System.out.println(String.valueOf(somme));

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
