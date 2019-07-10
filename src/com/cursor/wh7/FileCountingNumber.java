package com.cursor.wh7;

import java.io.*;


public class FileCountingNumber {
    File file = new File("src\\com\\cursor\\wh7\\Songs.txt");
    FileInputStream fileStream = new FileInputStream(file);
    InputStreamReader input = new InputStreamReader(fileStream);
    BufferedReader reader = new BufferedReader(input);

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
        String words;
        int swearWordsLengthThree = 0;
        while ((words = reader.readLine()) != null) {
            if (words.contains("badly")) {
                continue;
            }
            if (3 >= words.length()) {
                continue;
            }
            if (!(words.equals(""))) {
                String[] totalNumber = words.split("\\s+");
                swearWordsLengthThree += totalNumber.length;
            }
        }
        System.out.println("Total number of words and file = " + swearWordsLengthThree);
        reader.close();
        System.exit(0);

    }
//        File file = new File("src\\com\\cursor\\wh7\\Songs.txt");
//        try(Scanner sc = new Scanner(new FileInputStream(file))){
//            int count=0;
//            while(sc.hasNext()){
//                sc.next();
//                count++;
//            }
//            System.out.println("Number of words: " + count);
//        }

}
