package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;

public class Firstday {
    public static void main(String[] args) {
        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("day1\\input.txt"));
			String line = reader.readLine();
            String temp = "";
            int somme = 0, ajout;

			while (line != null) {
                line = line.replaceAll("[^0-9]", "");
                char[] c = line.toCharArray();
                if (c.length == 1) {
                    temp += c[0];
                    temp += c[0];
                    ajout = Integer.parseInt(String.valueOf(temp)); 
                    somme += ajout;
                } else {
                    temp += c[0];
                    temp += c[c.length-1];
                    ajout = Integer.parseInt(String.valueOf(temp)); 
                    somme += ajout;
                }
                
                System.out.println(ajout);
				// read next line
				line = reader.readLine();
                temp = "";
			}

            System.err.println(somme);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        
    }
}