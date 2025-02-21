package user;

import utils.EmailValidator;

import javax.naming.InvalidNameException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager extends User {
    protected static List<User> users = new ArrayList<>();

    public UserManager(String name, String email, int age, String height) {
        super(name, email, age, height);
    }

    public UserManager() {

    }

    public static void addUser(User user) throws IOException {
        users.add(user);
        System.out.println();
        System.out.println("--Congratulations---");
        System.out.println(user + " added");
        System.out.println("----------------------");
        System.out.println();
    }

    public static void fileAboutUser(User user) throws IOException {
        int num = users.size();
        String[] parts = user.getName().split(" ");
        String concatenated = "";

        if (parts.length > 0) {
            String firstName = parts[0];
            String secondName = (parts.length > 1) ? parts[1] : "";
            concatenated = firstName.toUpperCase() + secondName.toUpperCase();
        }

        Path path = Path.of("src", "registration", num + "-" + concatenated + ".txt");
        Files.createDirectories(path.getParent());
        File file = path.toFile();
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(user.getName() + "\n");
            bw.write(user.getEmail() + "\n");
            bw.write(user.getAge() + "\n");
            String height = String.valueOf(user.getHeight());
            bw.write(height);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void creatingFileAboutUsers() throws IOException {
        for(User userFile: users){
            fileAboutUser(userFile);
        }
    }

    public static void listAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Empty list");
        } else {
            int index = 1;
            System.out.println("---Registered Users---");
            for (User user : users) {
                System.out.println(index + "-" + user.getName().toUpperCase());
                index += 1;
            }
            System.out.println();
        }
    }

    public static void findUsers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Search by name");
        System.out.println("2- Search by age");
        System.out.println("3- Search by e-mail");
        System.out.print("Enter the a option:");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter the name from users that you'd like to search: ");
                String userSearchFilterByName = scanner.nextLine().toLowerCase();
                List<User> filterFromUsersByName = users.stream()
                        .filter(user -> user.getName().toLowerCase().startsWith(userSearchFilterByName))
                        .toList();
                System.out.println();
                if (users.isEmpty()) {
                    System.out.println("Didn't find any user with this information.");
                }
                System.out.println("--Search by name---");
                filterFromUsersByName.forEach(System.out::println);
                System.out.println();
                break;

            case 2:
                System.out.print("Enter the age from users that you'd like to search: ");
                int userSearchFilterByAge = scanner.nextInt();
                scanner.nextLine();
                List<User> filterFromUsersByAge = users.stream()
                        .filter(user -> user.getAge() == userSearchFilterByAge)
                        .toList();
                System.out.println();
                if (filterFromUsersByAge.isEmpty()) {
                    System.out.println("Didn't find any user with this information.");
                }
                System.out.println("--Search by Age---");
                filterFromUsersByAge.forEach(System.out::println);
                System.out.println();
                break;

            case 3:
                System.out.print("Enter the e-mail from users that you'd like to search: ");
                String userSearchFilterByEmail = scanner.nextLine().toLowerCase();
                List<User> filterFromUsersByEmail = users.stream()
                        .filter(user -> user.getEmail().toLowerCase().startsWith(userSearchFilterByEmail))
                        .toList();
                System.out.println();
                if (filterFromUsersByEmail.isEmpty()) {
                    System.out.println("Didn't find any user with this information.");
                }
                System.out.println("--Search by E-mail---");
                filterFromUsersByEmail.forEach(System.out::println);
                System.out.println();
                break;

            default:
                System.out.println("Invalid option");
        }
        System.out.println();
    }

    protected String enterEmailToChange(String currentEmail) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        boolean isemailValidator = EmailValidator.emailValidator(email);
        boolean isvalidateUserExistByEmail = EmailValidator.validateUserExistByEmail(email);
        if (email.equals(currentEmail)) {
            System.out.println("If you enter your current e-mail, You can disregard the message that the user already registered");
            isvalidateUserExistByEmail = true;
        }
        while ((!isemailValidator || !isvalidateUserExistByEmail)) {
            System.out.print("Enter your e-mail again:");
            isemailValidator = EmailValidator.emailValidator(email);
            isvalidateUserExistByEmail = EmailValidator.validateUserExistByEmail(email);

            if (email.equals(currentEmail)) {
                isvalidateUserExistByEmail = true;
            }
        }
        return email;
    }

    public static void changeInformationAboutUser() throws IOException, InvalidNameException {
        Scanner scanner = new Scanner(System.in);
        UserManager userInstance = new UserManager();
        listAllUsers();
        if(users.isEmpty()){
            System.out.println();
            return;
        }
        System.out.print("Enter the user that you´d like to change: ");
        int selectUser = scanner.nextInt();
        scanner.nextLine();
        User userToUpdate = users.get(selectUser - 1);
        System.out.println(userToUpdate);

        String name = enterName();
        String emailAgain = userInstance.enterEmailToChange(userToUpdate.getEmail());

        int ageAgain = enterAge();
        String heightAgain = enterHeight();

        User updatedUser = new User(name, emailAgain, ageAgain, heightAgain);
        users.set(selectUser - 1, updatedUser);

        System.out.println("UPDATED INFORMATIONS");
        System.out.println(users.get(selectUser - 1));
        System.out.println();
    }
}