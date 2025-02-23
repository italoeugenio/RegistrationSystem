package user;

import form.FormReader;
import form.FormWriterAndRemover;
import model.Person;
import utils.AgeValidator;
import utils.EmailValidator;
import utils.HeightValidator;
import utils.NameValidator;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User extends Person {
    private Map<String, String> additionalResponses = new HashMap<>();

    public User(String name, String email, int age, String height) {
        super(name, email, age, height);
    }

    public User() {
        super();
    }

    public Map<String, String> getAdditionalResponses() {
        return additionalResponses;
    }

    public void setAdditionalResponses(Map<String, String> additionalResponses) {
        this.additionalResponses = additionalResponses;
    }

    protected static void registerTheUsers() throws IOException, InvalidNameException {
        System.out.println();
        FormReader.formReader();
        User userInstance = new User();
        String name = enterName();
        String email = userInstance.enterEmail();
        int age = enterAge();
        String height = enterHeight();

        for (String question : FormWriterAndRemover.getQuestions()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(question + ": ");
            String answer = scanner.nextLine();
            userInstance.getAdditionalResponses().put(question, answer);
        }

        User user = new User(name, email, age, height);
        user.setAdditionalResponses(userInstance.getAdditionalResponses());

        System.out.println("\n" + user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getAge());
        System.out.println(user.getHeight());
        if(!user.additionalResponses.isEmpty()){
            System.out.println("Additional Responses: " + user.getAdditionalResponses());

        }
        UserManager.addUser(user);
        System.out.println();
    }

    protected static String enterName() throws InvalidNameException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        boolean isNameValidator = NameValidator.nameValidator(name);
        while (!isNameValidator) {
            System.out.print("Enter your name again (must be at least 10 characters long): ");
            name = scanner.nextLine();
            isNameValidator = NameValidator.nameValidator(name);
        }
        return name;
    }

    protected String enterEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        boolean isemailValidator = EmailValidator.emailValidator(email);
        boolean isvalidateUserExistByEmail = EmailValidator.validateUserExistByEmail(email);
        while ((!isemailValidator || !isvalidateUserExistByEmail)) {
            System.out.print("Enter your e-mail again: ");
            email = scanner.nextLine();
            isemailValidator = EmailValidator.emailValidator(email);
            isvalidateUserExistByEmail = EmailValidator.validateUserExistByEmail(email);
        }
        return email;
    }

    protected static int enterAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        AgeValidator.ageValidator(age);
        while (age <= 18) {
            System.out.print("Enter your age again (must be older than 18 years old): ");
            age = scanner.nextInt();
        }
        return age;
    }

    protected static String enterHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Height: ");
        String stringHeight = scanner.nextLine();
        boolean isheightValidator = HeightValidator.heightValidator(stringHeight);
        while (!isheightValidator) {
            System.out.print("Enter a valid height with (,):");
            stringHeight = scanner.nextLine();
            isheightValidator = HeightValidator.heightValidator(stringHeight);
        }
        return stringHeight;
    }
}
