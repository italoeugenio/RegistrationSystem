package utils;

public class AgeValidator {
    public static boolean ageValidator(int age){
        if(age >= 0 && age <= 150){
            return true;
        }
        return false;
    }
}
