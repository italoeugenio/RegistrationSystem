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
        NameValidator.nameValidator(name);
        String[] nameSplit = name.split(" ");
        while((name.length() - nameSplit.length + 1 <= 10)){
            System.out.print("Enter your name again (must be at least 10 characters long): ");
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
        while(EmailValidator.emailValidator(email) || EmailValidator.validateUserExistByEmail(email) ){
            if(EmailValidator.emailValidator(email)){
                System.out.println("--INVALID E-MAIL--");
            }
            if(EmailValidator.validateUserExistByEmail(email)){
                System.out.println("--USER ALREADY REGISTERED--");
            }
            System.out.println("Enter your e-mail again: ");
            email = scanner.nextLine();
        }
        return email;
    }

    private static int enterAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        AgeValidator.ageValidator(age);
        while(age <= 18){
            System.out.print("Enter your age again (must be at least 18 years old): ");
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
