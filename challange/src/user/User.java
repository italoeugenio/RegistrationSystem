package user;

import model.Person;
import utils.AgeValidator;
import utils.EmailValidator;
import utils.NameValidator;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.util.Scanner;

public class User extends Person {
    public User(String name, String email, int age, float height) {
        super(name, email, age, height);
    }

    public static void RegisterTheUsers() throws IOException, InvalidNameException {
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

    private static String enterName() throws InvalidNameException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        while (NameValidator.nameValidator(name)){
            System.out.print("Enter your name again: ");
            name = scanner.nextLine();
        }
        return name;
    }

    private static String enterEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        EmailValidator.emailValidator(email);
        EmailValidator.validateUserExistByEmail(email);
        return email;
    }

    private static int enterAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        AgeValidator.ageValidator(age);
        return age;
    }

    private static float enterHeight(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Height: ");
        return scanner.nextFloat();
    }
}
