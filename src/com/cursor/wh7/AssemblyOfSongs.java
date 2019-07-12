package com.cursor.wh7;

import java.io.IOException;
import java.util.Scanner;

public class AssemblyOfSongs {
    /**
     * Created by Vasyl Kachala on 10.07.2019.
     */

    /**
     * Created method menuCase described options
     * @throws IOException
     */
    public static void menuCase() throws IOException {
        FileCountingNumber fileCountingNumber = new FileCountingNumber();
        System.out.println("*************Songs Option*************");
        System.out.println("1 Calculate the total number of words in the text");
        System.out.println("2 Inappropriate words or words that are less than 3 characters long will not be taken into account");
        System.out.println("3 Calculate the number of words that need to be excluded");
        System.out.println("4 All the most common (repeated) words in decreasing order");
        System.out.println("*************End Songs Option*************");
        System.out.println("5 Exit");
        Scanner scanner = new Scanner(System.in);
        int switchCase = scanner.nextInt();
        do {
            switch (switchCase) {
                case 1:
                    fileCountingNumber.calculateTheTotalNumber();
                    System.out.println("*************Program End*************");
                    break;
                case 2:
                    fileCountingNumber.calculateSwearWordsLengthThree();
                    System.out.println("*************Program End*************");
                    break;
                case 3:
                    fileCountingNumber.calculateWordsToExclude();
                    System.out.println("*************Program End*************");
                    break;
                case 4:
                    fileCountingNumber.sortTheMostRepeatedWords();
//                    fileCountingNumber.
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Error cse");
                    break;
            }
            scanner = new Scanner(System.in);
            switchCase = scanner.nextInt();
        }
        while (switchCase > 0 && switchCase < 5);
    }
}


