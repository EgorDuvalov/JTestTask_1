package com.t_task;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Database {
    private final Vector<User> List = new Vector<>();

    public Database() {
        setDefaultList();
    }

    private void setDefaultList() {
        User Fst = new User();
        User Snd = new User();
        User Trd = new User();

        Fst.setName("Tony");
        Fst.setSurname("Stark");
        Fst.setEmail("t_stark@stark.inc");
        Fst.setRoles(new String[]{"Billionaire", "Playboy", "Philanthropist"});
        Fst.setPhones(new String[]{"37511 1111111", "37522 2222222", "37533 3333333"});

        Snd.setName("Steve");
        Snd.setSurname("Rogers");
        Snd.setEmail("cap_a@stark.inc");
        Snd.setRoles(new String[]{"America's ass", "Old fellow"});
        Snd.setPhones(new String[]{"37544 4444444", "37555 5555555"});

        Trd.setName("Peter");
        Trd.setSurname("Parker");
        Trd.setEmail("sp_man@stark.inc");
        Trd.setRoles(new String[]{"Friendly neighbor"});
        Trd.setPhones(new String[]{"37577 7777777"});

        List.add(Fst);
        List.add(Snd);
        List.add(Trd);
    }

    public void addNewUser() {
        User user = new User();
        user.setName();
        user.setSurname();
        user.setEmail();
        user.setRoles();
        user.setPhones();
        List.add(user);
    }

    public void editUser(int Position) {
        int Index = Position - 1;
        System.out.println("Choose item you want to change");
        System.out.println("\t1.Name\n\t2.Surname\n\t3.Email\n\t4.Roles\n\t5.Phones");
        String choice=new InputChecker().getChoice(5);
        switch (choice) {
            case "1":
                List.elementAt(Index).setName();
            case "2":
                List.elementAt(Index).setSurname();
            case "3":
                List.elementAt(Index).setEmail();
            case "4":
                List.elementAt(Index).setRoles();
            default:
                List.elementAt(Index).setPhones();
        }
    }

    public void deleteUser(int Position) {
        int Index = Position - 1;
        List.remove(Index);
    }

    public void showDatabase() {
        for (int i = 0; i < List.size(); i++) {
            System.out.println();
            System.out.println("User #" + (i + 1));
            System.out.println("Name: " + List.elementAt(i).getName());
            System.out.println("Surname: " + List.elementAt(i).getSurname());
            System.out.println("Email: " + List.elementAt(i).getEmail());
            String[] Roles = List.elementAt(i).getRoles();
            System.out.print("Roles: " + Roles[0]);
            for (int j = 1; j < Roles.length; j++) {
                System.out.print(", " + Roles[j]);
            }
            System.out.println();
            String[] Phones = List.elementAt(i).getPhones();
            System.out.print("Phones: " + Phones[0]);
            for (int j = 1; j < Phones.length; j++) {
                System.out.print(", " + Phones[j]);
            }
            System.out.println();
        }
    }

    public void saveDatabaseToFile() {
        try {
            File dataFile = new File("Database.txt");
            if (!dataFile.exists()) dataFile.createNewFile();
            PrintWriter pw = new PrintWriter(dataFile);
            printDataToFile(pw);
            pw.close();
            System.out.println("Done!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void printDataToFile(PrintWriter data) {
        for (int i = 0; i < List.size(); i++) {
            data.println("");
            data.println("User #" + (i + 1));
            data.println("Name: " + List.elementAt(i).getName());
            data.println("Surname: " + List.elementAt(i).getSurname());
            data.println("Email: " + List.elementAt(i).getEmail());
            String[] Roles = List.elementAt(i).getRoles();
            data.print("Roles: " + Roles[0]);
            for (int j = 1; j < Roles.length; j++) {
                data.print(", " + Roles[j]);
            }
            data.println("");
            String[] Phones = List.elementAt(i).getPhones();
            data.print("Phones: " + Phones[0]);
            for (int j = 1; j < Phones.length; j++) {
                data.print(", " + Roles[j]);
            }
            data.println("");
        }
    }

    public int size(){
        return List.size();
    }
}
