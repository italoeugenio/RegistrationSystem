package user;

import model.Person;
import utils.AgeValidator;

import java.util.Scanner;

public class User extends Person {
    public User(String name, String email, int age, float height) {
        super(name, email, age, height);
    }

    public static void enterInformations(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        while(!AgeValidator.ageValidator(age)){
            System.out.print("Please,enter a valid age: ");
        }

        System.out.println("Height: ");
        float height = scanner.nextFloat();
    }
}
