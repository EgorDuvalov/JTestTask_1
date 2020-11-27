package com.t_task;

import java.util.Scanner;

/**
 * Contains info about users
 * and methods of interaction
 */
public class User {
    private String name;
    private String surname;
    private String email;
    private String[] roles;
    private String[] phones;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String[] getRoles() {
        return roles;
    }

    public String[] getPhones() {
        return phones;
    }

    /**Methods with String param. are used for default ini. of users*/
    public void setName() {
        System.out.print("Name: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setSurname() {
        System.out.print("Surname: ");
        Scanner input = new Scanner(System.in);
        surname = input.nextLine();
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail() {

        System.out.print("Email: ");
        Scanner input = new Scanner(System.in);
        String email;
        boolean is_Correct = false;

        do {
            email = input.nextLine();
            String correctMailForm = "\\b[A-Za-z0-9._]+@[A-Za-z]+\\.[A-Za-z]{2,4}\\b";
            if (email.matches(correctMailForm)) {
                is_Correct = true;
            } else {
                System.out.println("Wrong email format");
                System.out.print("Email: ");
            }
        } while (!is_Correct);

        this.email = email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public void setRoles() {
        System.out.print("Use commas to divide roles \nRoles: ");
        Scanner input = new Scanner(System.in);
        String[] roles;
        do {
            String str = input.nextLine();
            roles = str.split(",\\s?");
            if (roles.length > 3) {
                System.out.println("Number of roles must be 3 or less");
                System.out.print("Roles: ");
            }
        } while (roles.length > 3);
        this.roles = roles;
    }

    protected void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void setPhones() {
        System.out.print("Phone number format: 375** *******" +
                "\nUse commas to divide numbers" +
                "\nPhones: ");
        String[] phones;
        Scanner input = new Scanner(System.in);
        boolean is_Correct = true;
        do {
            String numbers = input.nextLine();
            phones = numbers.split(",\\s?");
            if (phones.length > 3) {
                System.out.print("Number of phones must be 3 or less" +
                        "\nPhones: ");
                is_Correct = false;
            } else {
                for (String Phone : phones) {
                    is_Correct = Phone.matches("375\\d\\d\\s\\d\\d\\d\\d\\d\\d\\d");
                    if (!is_Correct) {
                        System.out.println("Wrong phone number format");
                        System.out.print("Phones: ");
                        break;
                    }
                }
            }
        } while (!is_Correct);
        this.phones = phones;
    }

    protected void setPhones(String[] phones) {
        this.phones = phones;
    }


}
