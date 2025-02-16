package user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    protected static List<User> users = new ArrayList<>();

    public static void addUser(User user) throws IOException {
        users.add(user);
        System.out.println();
        System.out.println("--Congratulations---");
        System.out.println("User: " + user.getName() + " added");
        System.out.println("----------------------");
        System.out.println();
        createFileAboutUser(user);
    }

    public static void createFileAboutUser(User user) throws IOException {
        int num = users.size();
        String[] parts = user.getName().split(" ");
        String concatenated = "";

        if(parts.length > 0){
            String firstName = parts[0];
            String secondName = (parts.length > 1) ? parts[1] : "";
            concatenated = firstName.toUpperCase() + secondName.toUpperCase();
        }

        Path path = Path.of("src", "registration", num + "-" + concatenated + ".txt");
        Files.createDirectories(path.getParent());
        File file = path.toFile();
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
        if(users.isEmpty()){
            System.out.println("Empty list");
        } else {
            int index = 1;
            System.out.println("---Registered Users---");
            for (User user : users) {
                System.out.println(index + "-" + user.getName());
                index += 1;
            }
            System.out.println();
        }
    }

    public static void findUsers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name from users that you'd like to search: ");
        String userSearchFilter = scanner.nextLine().toLowerCase();

        List<User> filterFromUsers = users.stream()
                .filter(user -> user.getName().toLowerCase().startsWith(userSearchFilter))
                .toList();
        filterFromUsers.forEach(System.out::println);
    }

}
