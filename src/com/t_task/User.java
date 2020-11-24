package com.t_task;

import java.util.Scanner;

public class User {
    private String Name;
    private String Surname;
    private String Email;
    private String[] Roles;
    private String[] Phones;

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    public String[] getRoles() {
        return Roles;
    }

    public String[] getPhones() {
        return Phones;
    }

    public void setName() {
        System.out.print("Name: ");
        Scanner input = new Scanner(System.in);
        Name = input.nextLine();
    }

    public void setSurname() {
        System.out.print("Surname: ");
        Scanner input = new Scanner(System.in);
        Surname =input.nextLine();
    }

    public void setEmail() {
        System.out.print("Email: ");
        Scanner input = new Scanner(System.in);
        String Email;
        boolean is_Correct = false;
        do {
            Email = input.nextLine();
            if (Email.matches("\\b[A-Za-z0-9._]+@[A-Za-z]+\\.[A-Za-z]{2,4}\\b"))
                is_Correct = true;
            else {
                System.out.println("Wrong email format");
                System.out.print("Email: ");
            }
        } while (!is_Correct);
        this.Email=Email;
    }

    public void setRoles() {
        System.out.print("Use commas to divide roles \nRoles: ");
        Scanner input = new Scanner(System.in);
        String[] Roles;
        do {
            String str = input.nextLine();
            Roles = str.split(",\\s?");
            if (Roles.length > 3) {
                System.out.println("Number of roles must be 3 or less");
                System.out.print("Roles: ");
            }
        } while (Roles.length > 3);
        this.Roles=Roles;
    }

    public void setPhones() {
        System.out.print("Phone number format: 375** *******\nUse commas to divide numbers\nPhones: ");
        String[] Phones;
        Scanner input = new Scanner(System.in);
        boolean is_Correct=true;
        do {
            String numbers = input.nextLine();
            Phones = numbers.split(",\\s?");
            if (Phones.length > 3) {
                System.out.println("Number of phones must be 3 or less");
                System.out.print("Phones: ");
                is_Correct=false;
            }
            else{
                for (String Phone: Phones) {
                    is_Correct=Phone.matches("375\\d\\d\\s\\d\\d\\d\\d\\d\\d\\d");
                    if (!is_Correct) {
                        System.out.println("Wrong phone number format");
                        System.out.print("Phones: ");
                        break;
                    }
                }
            }
        } while (!is_Correct);
        this.Phones=Phones;
    }

    protected void setName(String name){
        Name=name;
    }

    protected void setSurname(String surname){
        Surname=surname;
    }

    protected void setEmail(String email){
        Email=email;
    }

    protected void setRoles(String[] roles) {Roles=roles;}

    protected void setPhones(String[] phones) {Phones=phones;}

}
