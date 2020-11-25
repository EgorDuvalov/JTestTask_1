/*
 * Egor Duvalov
 *
 * Copyright (c) 2020-2020 Moon Microsystems, Inc. All Rights Reserved.
 *
 * Blah blah blah
 */


package com.t_task;

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
            String choice;
            choice = new InputChecker().getChoice(6);
            switch (choice) {
                case "1":
                    database.addNewUser();
                    break;
                case "2":
                    database.editUser(new InputChecker().getNumber(database.getSizeOfDatabase()));
                    break;
                case "3":
                    database.deleteUser(new InputChecker().getNumber(database.getSizeOfDatabase()));
                    break;
                case "4":
                    database.showDatabase();
                    break;
                case "5":
                    database.saveDatabaseToFile();
                    break;
                default:
                    return;
            }
        }
        while (true);
    }

}
