package utils;

import user.User;
import user.UserManager;


public class EmailValidator extends UserManager{
    public static void emailValidator(String email){
        try{
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            boolean valid = email.matches(emailRegex);
            if(!valid){
                throw new IllegalArgumentException("INVALID E-MAIL");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void validateUserExistByEmail(String email) {
        try{
            for(User user: users){
                if(user.getEmail().equals(email)){
                    throw new IllegalArgumentException("USER ALREADY REGISTERED");
                }
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
