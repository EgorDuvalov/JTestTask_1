package com.t_task;

import java.util.Scanner;

/**
 * Asking for correct input 'til gets it
 */
class InputChecker {
    /**Returns number of one of provided points*/
    public String getChoice(int amountOfPoints) {
        Scanner input = new Scanner(System.in);
        boolean isFound = false;
        String finalChoice = null;
        do {
            System.out.print("\nChoice: ");
            String choice = input.next();
            for (int i = 1; i <= amountOfPoints; i++) {
                if (Integer.toString(i).equals(choice)) {
                    isFound = true;
                    finalChoice = choice;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Choose number 1-" + amountOfPoints);
            }
        } while (!isFound);
        return finalChoice;
    }

    /**Returns number of User, application wants to interact with*/
    public Integer getNumber(int size){
        Scanner input = new Scanner(System.in);
        boolean isFound = false;
        String finalNum = null;
        do {
            System.out.print("\nNumber of User: ");
            String number = input.next();
            for (int i = 1; i <= size; i++) {
                if (Integer.toString(i).equals(number)) {
                    isFound = true;
                    finalNum = number;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No User with this number");
            }
        } while (!isFound);
        return Integer.parseInt(finalNum);
    }
}