package utils;

public class HeightValidator {
    public static boolean heightValidator(String height){
        try{
            if(height.contains(".")){
                throw new NumberFormatException("Wrong number format, you need to use \",\" ");
            }
            return true;
        }catch(NumberFormatException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
}
