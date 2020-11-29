/*
 * Egor Duvalov
 *
 * Copyright (c) 2020-2020 Moon Microsystems, Inc. All Rights Reserved.
 *
 * Blah blah blah
 */


package com.t_task;

import java.util.Scanner;

/**
 * The main menu of application
 */
public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        do {
            System.out.println("\n===============================\n");
            System.out.println("Hey there!" +
                    "\nChoose desired option from the list below");
            System.out.println(
                    "\n\t1. Add new User " +
                    "\n\t2. Edit User" +
                    "\n\t3. Delete User " +
                    "\n\t4. View current Users" +
                    "\n\t5. Save to file" +
                    "\n\t6. Exit");
            System.out.print("\nChoice: ");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    database.addNewUser();
                    break;
                case "2":
                    database.editUser(new UserNumber()
                            .getNumber(database.getSizeOfDatabase()));
                    break;
                case "3":
                    database.deleteUser(new UserNumber()
                            .getNumber(database.getSizeOfDatabase()));
                    break;
                case "4":
                    database.showDatabase();
                    break;
                case "5":
                    database.saveDatabaseToFile();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Choose one of provided options");
            }
        }
        while (true);
    }

}
