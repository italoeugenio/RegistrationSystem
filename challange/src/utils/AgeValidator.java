package utils;

public class AgeValidator {
    public static void ageValidator(int age){
        try{
            if(age <= 18){
                throw new IllegalArgumentException("Please, YOU NEED TO BE 18 YEARS OLD OR MORE");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
