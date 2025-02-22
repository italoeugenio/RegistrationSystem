package user;

import form.FormReader;
import form.FormWriterAndRemover;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    public static void userMenuOptions() throws IOException, InvalidNameException {
        Scanner scanner = new Scanner(System.in);

        FormReader.formReader();
        System.out.println();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1- Register the Users");
            System.out.println("2- List All User");
            System.out.println("3- Add a new question to the form");
            System.out.println("4- Delete a questions from the form");
            System.out.println("5- Search for a user by name, age, or email");
            System.out.println("6- Change information about user");
            System.out.println("0- Exit (Select this option to create the files about users)");
            System.out.print("Please, enter a option:");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    User.RegisterTheUsers();
                    break;
                case 2:
                    UserManager.listAllUsers();
                    break;
                case 3:
                    FormWriterAndRemover.addNewQuestionToForm();
                    break;
                case 4:
                    FormWriterAndRemover.removeQuestionToForm();
                    break;
                case 5:
                    UserManager.findUsers();
                    break;
                case 6:
                    UserManager.changeInformationAboutUser();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    UserManager.creatingFileAboutUsers();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again");
                    System.out.println();
            }
        }
    }
}
