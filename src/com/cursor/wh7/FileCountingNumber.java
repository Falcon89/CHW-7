package com.cursor.wh7;

import java.io.*;
import java.util.*;
/**
 * Created by Vasyl Kachala on 11.07.2019.
 */
public class FileCountingNumber {
    private static final String FILE = "src\\resources\\Songs.txt";
    BufferedReader reader = new BufferedReader(new FileReader(FILE));
    private static String lineCalc;
    int get = 0;
    int rs = 0;

    public FileCountingNumber() throws FileNotFoundException {
    }
    /**
     * Created method calculateTheTotalNumber Calculate the total number of get in the text
     * @throws IOException
     */
    public void calculateTheTotalNumber() throws IOException {
        while ((lineCalc = reader.readLine()) != null) {
            if (!(lineCalc.equals(""))) {
                String[] totalNumber = lineCalc.split("\\s+");
                get += totalNumber.length;
            }
        }
        System.out.println("Total number of get and file = " + get);
        reader.close();
        System.exit(0);
    }
    /**
     * Created method calculateSwearWordsLengthThree
     * Inappropriate get or get that are less than 3 characters long will not be taken into account
     * @throws IOException
     */
    public void calculateSwearWordsLengthThree() throws IOException {
        while ((lineCalc = reader.readLine()) != null) {
            if (lineCalc.contains("badly")) {
                continue;
            } else if (lineCalc.length() <= 2) {
                continue;
            } else if ((!lineCalc.equals(""))) {
                String[] totalNumber = lineCalc.split("\\s+");
                get += totalNumber.length;
            }
        }
        System.out.println("Total number of get and file = " + get);
        reader.close();
        System.exit(0);
    }
    /**
     * Created method calculateWordsToExclude
     * Count the number of get that need to be deleted and write them in a separate array
     * @throws IOException
     */
    public void calculateWordsToExclude() throws IOException {
        ArrayList<String> wordsArray = new ArrayList<String>();
        while ((lineCalc = reader.readLine()) != null) {
            if (lineCalc.contains("badly") || (lineCalc.length() <= 2)) {
                rs++;
            }
            String b = lineCalc;
            String s[] = b.split(" ");
            int i;
            for (i = 0; i < s.length; i++) {
                if (s[i].equals("badly") || (s[i].length() <= 2)) {
                    wordsArray.add(s[i]);
                }
            }
            get = rs;
        }
        System.out.println(wordsArray);
        System.out.println("Number of all deleted get and add in ArrayList " + get);
        reader.close();
        System.exit(0);
    }

    /**
     * Created method sortTheMostRepeatedWords  See the most common get.
     * Added sorting for convenience. From higher value to lowest value
     * @throws IOException
     */
    public void sortTheMostRepeatedWords() throws IOException {
        HashMap<String, Integer> wordsCounMap = new HashMap<>();
        while ((lineCalc = reader.readLine()) != null) {
            String[] words = lineCalc.toLowerCase().split(" ");
            for (String word : words) {
                if (wordsCounMap.containsKey(word)) {
                    wordsCounMap.put(word, wordsCounMap.get(word) + 1);
                } else {
                    wordsCounMap.put(word, 1);
                }
            }
            lineCalc = reader.readLine();
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




