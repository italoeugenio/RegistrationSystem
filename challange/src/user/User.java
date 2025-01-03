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
        System.out.println("\n" + user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getAge());
        System.out.println(user.getHeight());

        UserManager.addUser(user);
    }

    private static String enterName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    private static String enterEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        return scanner.nextLine();
    }

    private static int enterAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        while(!AgeValidator.ageValidator(age)){
            System.out.print("Please,enter a valid age: ");
            age = scanner.nextInt();
        }
        return age;
    }

    private static float enterHeight(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Height: ");
        return scanner.nextFloat();
    }
}
