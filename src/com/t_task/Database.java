package com.t_task;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * Contains list of current users
 * and interaction methods
 */
class Database {
    private final Vector<User> list = new Vector<>();

    public Database() {
        setDefaultList();
    }

    private void setDefaultList() {
        User fst = new User();
        User snd = new User();
        User trd = new User();

        fst.setName("Tony");
        fst.setSurname("Stark");
        fst.setEmail("t_stark@stark.inc");
        fst.setRoles(new String[]{"Billionaire", "Playboy", "Philanthropist"});
        fst.setPhones(new String[]{"37511 1111111",
                                    "37522 2222222",
                                    "37533 3333333"});

        snd.setName("Steve");
        snd.setSurname("Rogers");
        snd.setEmail("cap_a@stark.inc");
        snd.setRoles(new String[]{"America's ass", "Old fellow"});
        snd.setPhones(new String[]{"37544 4444444", "37555 5555555"});

        trd.setName("Peter");
        trd.setSurname("Parker");
        trd.setEmail("sp_man@stark.inc");
        trd.setRoles(new String[]{"Friendly neighbor"});
        trd.setPhones(new String[]{"37577 7777777"});

        list.add(fst);
        list.add(snd);
        list.add(trd);
    }

    public void addNewUser() {
        User user = new User();
        user.setName();
        user.setSurname();
        user.setEmail();
        user.setRoles();
        user.setPhones();
        list.add(user);
    }

    public void editUser(int position) {
        int index = position - 1;
        System.out.println("Choose item you want to change");
        System.out.println("\t1.Name" +
                           "\n\t2.Surname" +
                           "\n\t3.Email" +
                           "\n\t4.Roles" +
                           "\n\t5.Phones");
        String choice=new InputChecker().getChoice(5);
        switch (choice) {
            case "1" -> list.elementAt(index).setName();
            case "2" -> list.elementAt(index).setSurname();
            case "3" -> list.elementAt(index).setEmail();
            case "4" -> list.elementAt(index).setRoles();
            default -> list.elementAt(index).setPhones();
        }
    }

    public void deleteUser(int position) {
        int index = position - 1;
        list.remove(index);
    }

    public void showDatabase() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            System.out.println("User #" + (i + 1));
            System.out.println("Name: " + list.elementAt(i).getName());
            System.out.println("Surname: " + list.elementAt(i).getSurname());
            System.out.println("Email: " + list.elementAt(i).getEmail());
            String[] Roles = list.elementAt(i).getRoles();
            System.out.print("Roles: " + Roles[0]);

            for (int j = 1; j < Roles.length; j++) {
                System.out.print(", " + Roles[j]);
            }

            System.out.println();
            String[] Phones = list.elementAt(i).getPhones();
            System.out.print("Phones: " + Phones[0]);
            for (int j = 1; j < Phones.length; j++) {
                System.out.print(", " + Phones[j]);
            }
            System.out.println("");
        }
    }

    public void saveDatabaseToFile() {
        try {
            File dataFile = new File("Database.txt");
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
            PrintWriter pw = new PrintWriter(dataFile);
            printDataToFile(pw);
            pw.close();
            System.out.println("Done!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }

    private void printDataToFile(PrintWriter data) {
        for (int i = 0; i < list.size(); i++) {
            data.println("");
            data.println("User #" + (i + 1));
            data.println("Name: " + list.elementAt(i).getName());
            data.println("Surname: " + list.elementAt(i).getSurname());
            data.println("Email: " + list.elementAt(i).getEmail());
            String[] Roles = list.elementAt(i).getRoles();
            data.print("Roles: " + Roles[0]);
            for (int j = 1; j < Roles.length; j++) {
                data.print(", " + Roles[j]);
            }
            data.println("");
            String[] Phones = list.elementAt(i).getPhones();
            data.print("Phones: " + Phones[0]);
            for (int j = 1; j < Phones.length; j++) {
                data.print(", " + Roles[j]);
            }
            data.println("");
        }
    }

    public int getSizeOfDatabase(){
        return list.size();
    }
}
