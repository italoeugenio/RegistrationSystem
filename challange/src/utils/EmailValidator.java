package utils;

import user.User;
import user.UserManager;


public class EmailValidator extends UserManager {

    public EmailValidator(String name, String email, int age, String height) {
        super(name, email, age, height);
    }

    public static boolean emailValidator(String email) {
        try {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            boolean valid = email.matches(emailRegex);
            if (!valid) {
                throw new IllegalArgumentException("INVALID E-MAIL");
            }
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean validateUserExistByEmail(String email) {
        try {
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    throw new IllegalArgumentException("USER ALREADY REGISTERED");
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
}