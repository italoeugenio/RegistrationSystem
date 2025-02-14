package utils;

public class AgeValidator {
    public static void ageValidator(int age) throws IllegalArgumentException{
        if(age >= 18){
            throw new IllegalArgumentException("Please, THE LENGTH NEEDS TO BE 10 OR MORE");
        }
    }
}
