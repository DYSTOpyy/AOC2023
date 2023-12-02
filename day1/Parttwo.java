package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parttwo {

    public static void main(String[] args) {
        BufferedReader reader;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        // System.out.println(map.get("one"));
        int somme = 0, ajout = 0;

        try {
            reader = new BufferedReader(new FileReader("day1\\input.txt"));
            String line = reader.readLine(), test = "";
            ArrayList<Integer> nb = new ArrayList<Integer>();

            while (line != null) {
                test="";
                char[] c = line.toCharArray();
                for (int i = 0; i < c.length; i++) {

                    Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
                    String s = String.valueOf(c[i]);
                    Matcher matcher = pattern.matcher(s);
                    boolean matchFound = matcher.find();

                    if (matchFound) {

                        nb.add(Integer.parseInt(s));
                        test = "";

                    } else {
                        test += String.valueOf(c[i]);
                        for (String name : map.keySet())  
                            if (test.contains(name)) {
                                nb.add(map.get(name));
                                test = String.valueOf(test.toCharArray()[test.length()-1]);
                            }
                    }

                    
                    

                }
                ajout = nb.get(0) * 10 + nb.get(nb.size()-1);
                System.out.println(ajout);
                somme += ajout;

                nb.clear();
                line = reader.readLine();
            }
            System.out.println(somme);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

// si digit
// j'ajoute le digit
// vide le string
// sinon
// j'ajoute la lettre à mon string
// je cherche si contient un chiffre
// si oui
// ajout du chiffre
// vide le string