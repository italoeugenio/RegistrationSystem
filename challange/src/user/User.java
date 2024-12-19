package user;

import model.Person;
import utils.AgeValidator;

import java.util.Scanner;

public class User extends Person {
    public User(String name, String email, int age, float height) {
        super(name, email, age, height);
    }

    public static void userInformations(){
        enterName();
        enterEmail();
        enterAge();
        enterHeight();
    }

    public static void enterName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        scanner.close();
    }

    public static void enterEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        scanner.close();
    }

    public static void enterAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        while(!AgeValidator.ageValidator(age)){
            System.out.print("Please,enter a valid age: ");
        }
        scanner.close();
    }

    public static void enterHeight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Height: ");
        float height = scanner.nextFloat();
        scanner.close();
    }
}
