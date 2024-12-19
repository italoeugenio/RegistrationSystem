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


    }
}
