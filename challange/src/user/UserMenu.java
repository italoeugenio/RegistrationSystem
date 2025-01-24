package user;

import form.FormReader;
import form.FormWriter;

import java.util.Scanner;

public class UserMenu {
    public static void userMenuOptions(){
        Scanner scanner = new Scanner(System.in);

        FormReader.formReader();
        System.out.println();

        while(true){
            System.out.println("===== MENU =====");
            System.out.println("1- Register the Users");
            System.out.println("2- List All User");
            System.out.println("3- Add a new question to the form");
            System.out.println("4- Delete a questions from the form");
            System.out.println("5- Search for a user by name, age, or email");
            System.out.println("0- Exit");
            System.out.print("Please, enter a option:");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    User.RegisterTheUsers();
                    break;
                case 2:
                    UserManager.listAllUsers();
                    System.out.println();
                    break;
                case 3:
                    FormWriter.addQuestionToForm();
                    break;
                case 4 :
                    FormWriter.removeQuestionToForm();
                    break;
                case 5:
                    System.out.println("5- Loading...");
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }
}
