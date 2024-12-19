package user;

import model.Person;
import utils.AgeValidator;

import java.util.Scanner;

public class User extends Person {
    public User(String name, String email, int age, float height) {
        super(name, email, age, height);
    }

    public static void userInformations(){
        String name = enterName();
        String email= enterEmail();
        int age = enterAge();
        float height = enterHeight();
        User user = new User(name,email,age,height);
    }

    public static String enterName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    public static String enterEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        return scanner.nextLine();
    }

    public static int enterAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        while(!AgeValidator.ageValidator(age)){
            System.out.print("Please,enter a valid age: ");
        }
        return age;
    }

    public static float enterHeight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Height: ");
        return scanner.nextFloat();
    }
}
