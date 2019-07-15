package com.cursor.wh7;

import java.io.*;
import java.util.*;
/**
 * Created by Vasyl Kachala on 11.07.2019.
 */
public class ExecutingMenuMethods {
    private static final String FILE = "src/resources/Songs.txt";
    BufferedReader reader = new BufferedReader(new FileReader(FILE));
    private static String line;
    private int s = 0;
    private int n = 0;

    public ExecutingMenuMethods() throws FileNotFoundException {
    }
    /**
     * Created method calculateTheTotalNumber Calculate the total number of s in the text
     * @throws IOException
     */
    public void calculateTheTotalNumber() throws IOException {
        while ((line = reader.readLine()) != null) {
            if (!(line.equals(""))) {
                String[] totalNumber = line.split("\\s+");
                s += totalNumber.length;
            }
        }
        System.out.println("Total number of s and file = " + s);
        reader.close();
        System.exit(0);
    }
    /**
     * Created method calculateSwearWordsLengthThree
     * Inappropriate s or s that are less than 3 characters long will not be taken into account
     * @throws IOException
     */
    public void calculateSwearWordsLengthThree() throws IOException {
        while ((line = reader.readLine()) != null) {
            if (line.contains("badly")) {
                continue;
            } else if (line.length() <= 2) {
                continue;
            } else if ((!line.equals(""))) {
                String[] totalNumber = line.split("\\s+");
                s += totalNumber.length;
            }
        }
        System.out.println("Total number of s and file = " + s);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    /**
     * Created method calculateWordsToExclude
     * Count the number of s that need to be deleted and write them in a separate array
     * @throws IOException
     */
    public void calculateWordsToExclude() throws IOException {
        ArrayList<String> wordsArray = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            if (line.contains("badly") || (line.length() <= 2)) {
                n++;
            }
            String b = line;
            String s[] = b.split(" ");
            int i;
            for (i = 0; i < s.length; i++) {
                if (s[i].equals("badly") || (s[i].length() <= 2)) {
                    wordsArray.add(s[i]);
                }
            }
            this.s = n;
        }
        System.out.println(wordsArray);
        System.out.println("Number of all deleted s and add in ArrayList " + s);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Created method sortTheMostRepeatedWords  See the most common s.
     * Added sorting for convenience. From higher value to lowest value
     * @throws IOException
     */
    public void sortTheMostRepeatedWords() throws IOException {
        HashMap<String, Integer> wordsCounMap = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().split(" ");
            for (String word : words) {
                if (wordsCounMap.containsKey(word)) {
                    wordsCounMap.put(word, wordsCounMap.get(word) + 1);
                } else {
                    wordsCounMap.put(word, 1);
                }
            }
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = wordsCounMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);
        //Sorting the list in the decreasing order of values
        Collections.sort(list, (e1, e2) -> (e2.getValue().compareTo(e1.getValue())));
        System.out.println("Words that are repeated from the File :");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}




