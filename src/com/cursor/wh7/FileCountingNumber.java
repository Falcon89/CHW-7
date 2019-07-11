package com.cursor.wh7;

import java.io.*;
import java.util.*;


public class FileCountingNumber {
    private static final String FILE = "Songs.txt";
    BufferedReader reader = new BufferedReader(new FileReader(FILE));

    public FileCountingNumber() throws FileNotFoundException {
    }

    public void calculateTheTotalNumber() throws IOException {

        String lineCalculate;
        int calculateNumber = 0;
        while ((lineCalculate = reader.readLine()) != null) {
            if (!(lineCalculate.equals(""))) {
                String[] totalNumber = lineCalculate.split("\\s+");
                calculateNumber += totalNumber.length;
            }
        }
        System.out.println("Total number of words and file = " + calculateNumber);
        reader.close();
        System.exit(0);
    }

    public void calculateSwearWordsLengthThree() throws IOException {
        String lineCalculate;
        int swearWordsLengthThree = 0;
        while ((lineCalculate = reader.readLine()) != null) {

            if (lineCalculate.contains("badly")) {
                continue;
            } else if (lineCalculate.length() <= 2) {
                continue;
            } else if ((!lineCalculate.equals(""))) {
                String[] totalNumber = lineCalculate.split("\\s+");
                swearWordsLengthThree += totalNumber.length;
            }
        }
        System.out.println("Total number of words and file = " + swearWordsLengthThree);
        reader.close();
        System.exit(0);

    }

    public void calculateWordsToExclude() throws IOException {
        ArrayList<String> wordsArray = new ArrayList<String>();
        String lineCalculateTWO2;
        int searchBadly = 0;
        int lengthMinThree = 0;
        int calcWords = 0;
        while ((lineCalculateTWO2 = reader.readLine()) != null) {
            if (lineCalculateTWO2.contains("badly") || (lineCalculateTWO2.length() <= 2)) {
                searchBadly++;
            }
            String b = lineCalculateTWO2;
            String s[] = b.split(" ");
            int i;
            for (i = 0; i < s.length; i++) {
                if (s[i].equals("badly") || (s[i].length() <= 2)) {
                    wordsArray.add(s[i]);
                }
            }
            calcWords = searchBadly + lengthMinThree;
        }
        System.out.println(wordsArray);
        System.out.println("Number of all deleted words and add in ArrayList" + calcWords);
        reader.close();
        System.exit(0);
    }

    public static void calculateTheMostWords2() {

    }


    private static String[] w = null;
    private static int[] r = null;

    public void calculateTheMostWords() throws IOException {


        try {
            System.out.println("Enter 'n' value :: ");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            w = new String[n];
            r = new int[n];
//            FileReader fr = new FileReader("src\\com\\cursor\\wh7\\Songs.txt");
//            BufferedReader br = new BufferedReader(fr);
            String text = "";
            String sz = null;
            while ((sz = reader.readLine()) != null) {
                text = text.concat(sz);
            }
            String[] words = text.split(" ");
            String[] uniqueLabels;
            int count = 0;
            uniqueLabels = getUniqLabels(words);
            for (int j = 0; j < n; j++) {
                r[j] = 0;
            }
            for (String l : uniqueLabels) {
                if ("".equals(l) || null == l) {
                    break;
                }
                for (String s : words) {
                    if (l.equals(s)) {
                        count++;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (count > r[i]) {
                        r[i] = count;
                        w[i] = l;
                        break;
                    }
                }
                count = 0;
            }
            display(n);
        } catch (Exception e) {
            System.err.println("ERR " + e.getMessage());
        }
    }

    public static void display(int n) {
        for (int k = 0; k < n; k++) {
            System.out.println("Label :: " + w[k] + "\tCount :: " + r[k]);
        }
    }

    private static String[] getUniqLabels(String[] keys) {
        String[] uniqueKeys = new String[keys.length];
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for (int i = 1; i < keys.length; i++) {
            for (int j = 0; j <= uniqueKeyIndex; j++) {
                if (keys[i].equals(uniqueKeys[j])) {
                    keyAlreadyExists = true;
                }
            }
            if (!keyAlreadyExists) {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }
}


