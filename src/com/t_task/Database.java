package com.t_task;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Contains list of current users
 * and interaction methods
 */
class Database {
    private final List<User> list = new ArrayList<>();

    public Database() {
        setDefaultList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Database database = (Database) o;
        return Objects.equals(list, database.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
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

        list.add( fst);
        list.add( snd);
        list.add(trd);
    }

    public void addNewUser() {
        User user = new User();
        System.out.println("\nNew user's data:");
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
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "1" -> list.get(index).setName();
            case "2" -> list.get(index).setSurname();
            case "3" -> list.get(index).setEmail();
            case "4" -> list.get(index).setRoles();
            case "5" -> list.get(index).setPhones();
            default -> System.out.println("Choose one of provided options");
        }
    }

    public void deleteUser(int position) {
        list.remove(position - 1);
    }

    public void showDatabase() {
        for (int i =0; i < list.size(); i++) {
            System.out.println();
            System.out.println("User #" + (i + 1));
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("Surname: " + list.get(i).getSurname());
            System.out.println("Email: " + list.get(i).getEmail());
            String[] roles = list.get(i).getRoles();
            System.out.print("Roles: " + roles[0]);

            for (int j = 1; j < roles.length; j++) {
                System.out.print(", " + roles[j]);
            }

            System.out.println();
            String[] phones = list.get(i).getPhones();
            System.out.print("Phones: " + phones[0]);
            for (int j = 1; j < phones.length; j++) {
                System.out.print(", " + phones[j]);
            }
            System.out.println(" ");
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
            data.println("User #" + (i+1));
            data.println("Name: " + list.get(i).getName());
            data.println("Surname: " + list.get(i).getSurname());
            data.println("Email: " + list.get(i).getEmail());
            String[] roles = list.get(i).getRoles();
            data.print("roles: " + roles[0]);
            for (int j = 1; j < roles.length; j++) {
                data.print(", " + roles[j]);
            }
            data.println("");
            String[] phones = list.get(i).getPhones();
            data.print("Phones: " + phones[0]);
            for (int j = 1; j < phones.length; j++) {
                data.print(", " + phones[j]);
            }
            data.println("");
        }
    }

    public int getSizeOfDatabase() {
        return list.size();
    }
}
