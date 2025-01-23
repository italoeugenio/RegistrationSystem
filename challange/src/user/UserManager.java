package user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
        System.out.println();
        System.out.println("--Congratulations---");
        System.out.println("User: " + user.getName() + " added");
        System.out.println("----------------------");
        System.out.println();
        formWriterUser(user);
    }

    public static void formWriterUser(User user){
        int num = users.size();
        String name = user.getName();
        String[] parts = user.getName().split(" ");
        String concatenated = "";

        if(parts.length > 0){
            String firstName = parts[0];
            String secondName = parts[1];
            concatenated = firstName.toUpperCase() + secondName.toUpperCase();
        }

        File file = new File("C:\\Users\\italo.santana\\OneDrive - cnj.jus.br\\Área de Trabalho\\Language\\RegistrationSystem\\challange\\src\\registration\\" + num + "-" + concatenated + ".txt");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(user.getName() + "\n");
            bw.write(user.getEmail() + "\n");
            bw.write(user.getAge() + "\n");
            String height = String.valueOf(user.getHeight());
            bw.write(height);
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void listAllUsers () {
        if(users.size() == 0){
            System.out.println("Empty list");
        } else {
            int index = 1;
            System.out.println("Registered Users");
            for (User user : users) {
                System.out.println(index + "-" + user.getName());
                index += 1;
            }
        }
    }
}
