package com.cursor.wh7;

import java.util.Scanner;

public class AssemblyOfSongs {
    /**
     * Created by Vasyl Kachala on 10.07.2019.
     */
    public static void menuCase() {
        System.out.println("*************Songs Option*************");
        System.out.println("1 Calculate the total number of words in the text");
        System.out.println("2 Calculate the number of words that need to be excluded");
        System.out.println("3 Outcome N most frequently encountered words");
        System.out.println("*************End Songs Option*************");
        System.out.println("4 Exit");
        Scanner scanner = new Scanner(System.in);
        int switchCase = scanner.nextInt();
        do {
            switch (switchCase) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Error cse");
                    break;
            }
            scanner = new Scanner(System.in);
            switchCase = scanner.nextInt();
        }
        while (switchCase > 0 && switchCase < 4);
    }
}


