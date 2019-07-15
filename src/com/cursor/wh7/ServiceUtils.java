package com.cursor.wh7;

import java.io.IOException;
import java.util.Scanner;

public class ServiceUtils {
    /**
     * Created method caseUtils described options
     * @throws IOException
     */
    public static void caseUtils() throws IOException {
        System.out.println("*************Songs Option*************");
        System.out.println("1 Calculate the total number of s in the text");
        System.out.println("2 Inappropriate s or s that are less than 3 characters long will not be taken into account");
        System.out.println("3 Calculate the number of s that need to be excluded");
        System.out.println("4 All the most common (repeated) s in decreasing order");
        System.out.println("*************End Songs Option*************");
        switchUtils();
    }
    /**
     * Created method switchUtils described switch
     * @throws IOException
     */
    public static void switchUtils() throws IOException {
        ExecutingMenuMethods executingMenuMethods = new ExecutingMenuMethods();
        Scanner scanner = new Scanner(System.in);
        int switchCase = scanner.nextInt();
        switch (switchCase) {
            case 1:
                executingMenuMethods.calculateTheTotalNumber();
                System.out.println("*************Program End*************");
                break;
            case 2:
                executingMenuMethods.calculateSwearWordsLengthThree();
                System.out.println("*************Program End*************");
                break;
            case 3:
                executingMenuMethods.calculateWordsToExclude();
                System.out.println("*************Program End*************");
                break;
            case 4:
                executingMenuMethods.sortTheMostRepeatedWords();
                break;
            default:
                System.out.println("Error case");
                break;
        }
    }
}


