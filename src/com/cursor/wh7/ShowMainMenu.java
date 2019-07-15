package com.cursor.wh7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ShowMainMenu {
    /**
     * Created method printInfo described options
     * @throws IOException
     */
    public static void printInfo() {
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
    public static void switchUtils(){
        ExecutingMenuMethods executingMenuMethods = null;
        try {
            executingMenuMethods = new ExecutingMenuMethods();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        int switchCase = scanner.nextInt();
        switch (switchCase) {
            case 1:
                try {
                    executingMenuMethods.calculateTheTotalNumber();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("*************Program End*************");
                break;
            case 2:
                try {
                    executingMenuMethods.calculateSwearWordsLengthThree();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("*************Program End*************");
                break;
            case 3:
                try {
                    executingMenuMethods.calculateWordsToExclude();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("*************Program End*************");
                break;
            case 4:
                try {
                    executingMenuMethods.sortTheMostRepeatedWords();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Error case");
                break;
        }
    }
}


